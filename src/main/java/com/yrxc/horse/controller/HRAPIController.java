package com.yrxc.horse.controller;

import com.yrxc.horse.entity.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hr-api")
public class HRAPIController {


    @RequestMapping("/getPro")
    public Object getProduct(String id)
    {
        List<Product> items = new ArrayList<>();
        int i_id =Integer.valueOf(id);
        String ls_prefix="https://www.yurenxinchuang.com";
        int i_loop =0;
        switch (i_id){
            case 0:
                ls_prefix +="/ztg";
                i_loop =3;
                break;
            case 1:
                ls_prefix +="/rc";
                i_loop =26;
                break;
            case 2:
                ls_prefix +="/tcps";
                i_loop =4;
                break;
            case 3:
                ls_prefix +="/cxps";
                i_loop =11;
                break;
            case 5:
                ls_prefix +="/b";
                i_loop=20;
                break;
            case 6:
                ls_prefix +="/w";
                i_loop=40;
                break;
        }

        for(int i =1;i<=i_loop;i++)
        {
            Product product = new Product();
            product.setImg(ls_prefix+ i +".png");
            product.setTxt("");
            items.add(product);
        }

        return items;
    }

}
