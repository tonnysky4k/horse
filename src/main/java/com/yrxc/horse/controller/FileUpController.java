package com.yrxc.horse.controller;

import com.yrxc.horse.entity.TFile;
import com.yrxc.horse.service.FileService;
import com.yrxc.horse.util.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class FileUpController {

    @Value("${user.file.path}")
    private String filePath;

    @Value("${user.file.name}")
    private String fileName;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    FileService fileService;


    @GetMapping("/upFile")
    public String upFile()
    {
        return "upload";
    }


    @RequestMapping(value="/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename)
    {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:"+ Paths.get(filePath+filename)));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST )
    @ResponseBody
    public String uploadFile2(@RequestParam("file") MultipartFile multipartFile,@RequestParam("user") String user) {
        String fname = multipartFile.getOriginalFilename();
        int ipos =fname.lastIndexOf('.');
        String ftype =fname.substring(ipos);
        try {
            File file = new File(filePath + user+ftype);
            if(file.exists())
                file.delete();
            multipartFile.transferTo(file);
            TFile tf =new TFile();
            tf.setId(0L);
            tf.setFname(fname);
            tf.setFpath(filePath);
            tf.setFtype(ftype);
            tf.setFile(filePath+user+ftype);
            tf.setUname(user.substring(user.indexOf("_")+1,user.length()));
            fileService.insertFile(tf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user+ftype;
    }
}
