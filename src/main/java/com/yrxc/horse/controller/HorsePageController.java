package com.yrxc.horse.controller;
import com.yrxc.horse.entity.CoinsCZ;
import com.yrxc.horse.entity.CoinsTX;
import com.yrxc.horse.entity.Login;
import com.yrxc.horse.entity.User;
import com.yrxc.horse.service.CoinsCZService;
import com.yrxc.horse.service.CoinsTXService;
import com.yrxc.horse.service.LoginService;
import com.yrxc.horse.service.UserService;
import com.yrxc.horse.util.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class HorsePageController {

    @Autowired
    CoinsCZService coinsCZService;

    @Autowired
    CoinsTXService coinsTXService;

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @PassToken
    @GetMapping("/horse")
    public  String horseMain(String ycode,Model model)
    {
        if(ycode ==null)
            ycode="1000";
        model.addAttribute("ycode",ycode);
        return "horse";
    }

    @PassToken
    @GetMapping("/czinfo")
    public String czinfo(Model model)
    {
            List<CoinsCZ> czlist = coinsCZService.selectAll();
            model.addAttribute("czs", czlist);
            return "czinfo";
    }

    @PassToken
    @GetMapping("/txinfo")
    public String txinfo(Model model)
    {

        List<CoinsTX> txList = coinsTXService.selectAll();
        model.addAttribute("txs",txList);
        return "txinfo";
    }

    @PassToken
    @GetMapping("/err")
    public  String err()
    {
        return "error";
    }

    @PassToken
    @GetMapping("/Admin")
    public String userLogin()
    {

        return "userLogin";
    }

    @PassToken
    @GetMapping("/index2")
    public String index2()
    {

        return "index2";
    }

    @PassToken
    @GetMapping("/userinfo")
    public String userinfo(Model model)
    {

        List<User> users =userService.selectAll();
        model.addAttribute("users",users);
        return "userinfo";
    }

    @PassToken
    @GetMapping("/logs")
    public String loginfo(Model model)
    {
        List<Login> logs =loginService.selectAll();
        model.addAttribute("logs",logs);
        return "loginfo";
    }
}
