package com.yrxc.horse.controller;

import com.yrxc.horse.entity.*;
import com.yrxc.horse.service.*;
import com.yrxc.horse.util.IpUtil;
import com.yrxc.horse.util.PassToken;
import com.yrxc.horse.util.RunHorse;
import com.yrxc.horse.util.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HorseController {


    @Value("${user.file.path}")
    private String filePath;
    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @Autowired
    SmsService smsService;

    @Autowired
    RaceRecordService raceRecordService;

    @Autowired
    CoinsCZService coinsCZService;

    @Autowired
     CoinsTXService coinsTXService;

    @Autowired
     TokenService tokenService;

    @Autowired
            FileService fileService;

    RunHorse run =null;
    RaceData raceData;

    private String ip;

    int index=-1;

    @UserLoginToken
    @RequestMapping(value = "/runHorse",method = RequestMethod.POST)
    public int getHorseData(@RequestBody RaceObj raceObj)
    {

        RaceRecord rr= new RaceRecord();
        rr.setId(0L);
        rr.setUname(raceObj.getUname());
        rr.setPdate(new Date());
        int won =0;
        int cos =0;
        rr.setM16(""+raceObj.getBls().get(0)+"-"+raceObj.getBtms().get(0));
        rr.setM15(""+raceObj.getBls().get(1)+"-"+raceObj.getBtms().get(1));
        rr.setM14(""+raceObj.getBls().get(2)+"-"+raceObj.getBtms().get(2));
        rr.setM13(""+raceObj.getBls().get(3)+"-"+raceObj.getBtms().get(3));
        rr.setM12(""+raceObj.getBls().get(4)+"-"+raceObj.getBtms().get(4));

        rr.setM26(""+raceObj.getBls().get(5)+"-"+raceObj.getBtms().get(5));
        rr.setM25(""+raceObj.getBls().get(6)+"-"+raceObj.getBtms().get(6));
        rr.setM24(""+raceObj.getBls().get(7)+"-"+raceObj.getBtms().get(7));
        rr.setM23(""+raceObj.getBls().get(8)+"-"+raceObj.getBtms().get(8));

        rr.setM36(""+raceObj.getBls().get(9)+"-"+raceObj.getBtms().get(9));
        rr.setM35(""+raceObj.getBls().get(10)+"-"+raceObj.getBtms().get(10));
        rr.setM34(""+raceObj.getBls().get(11)+"-"+raceObj.getBtms().get(11));

        rr.setM46(""+raceObj.getBls().get(12)+"-"+raceObj.getBtms().get(12));
        rr.setM45(""+raceObj.getBls().get(13)+"-"+raceObj.getBtms().get(13));

        rr.setM56(""+raceObj.getBls().get(14)+"-"+raceObj.getBtms().get(14));

        won =raceObj.getBls().get(index) * raceObj.getBtms().get(index);
        for(int i =0 ;i<raceObj.getBtms().size();i++)
            cos +=raceObj.getBtms().get(i);

        rr.setWcoins(won);
        rr.setCcoins(cos);
        rr.setMark(""+raceObj.getBls().get(index)+"-"+raceObj.getBtms().get(index));
        raceRecordService.insertRaceRecord(rr);
        return 1;
    }

    @PassToken
    @RequestMapping(value="/sendSms")
    public int sendSms(String pho,String ycode, HttpServletRequest request) throws  Exception
    {
        ip =IpUtil.getIpAddr(request);
        smsService.sendSms(pho,ycode,ip);
        return 1;
    }

    @RequestMapping(value = "/coinsCZ",method = RequestMethod.POST)
    public int coinsCZ(String uname,int czs,String ctype)
    {
        CoinsCZ ccz = new CoinsCZ();
        ccz.setUname(uname);
        ccz.setCzs(czs);
        ccz.setCdate(new Date());
        ccz.setIp(ip);
        ccz.setId(0L);
        ccz.setCztype(ctype);
        coinsCZService.insertCoinsCZ(ccz);
        return 1;
    }
    @RequestMapping(value = "/coinsTX",method = RequestMethod.POST)
    public int coinsTX(String uname,int tsl,String ttype)
    {
        CoinsTX ctx = new CoinsTX();
        ctx.setUname(uname);
        ctx.setTsl(tsl);
        ctx.setTdate(new Date());
        ctx.setId(0L);
        ctx.setIp(ip);
        ctx.setTtype(ttype);
        coinsTXService.insertCoinsTX(ctx);
        return 1;
    }
    @PassToken
    @PostMapping("/login")
    public Object login(String uname,String scode,HttpServletRequest request)
    {
        Map<String,Object> map= new HashMap<String,Object>();
        Login log = new Login();
        log.setUname(uname);
        log.setScode(scode);
        ip =IpUtil.getIpAddr(request);
        int coins = userService.selectCoins(uname);
        log = loginService.selectByName(log);

        List<TFile> files= fileService.selectByName(uname);
        String ptype =".png";
        if(files.size()>0)
            ptype = files.get(0).getFtype();
        if( log== null)
        {
            map.put("text","用户不存在!");
            return map;
        }else{
            if(!scode.equals(log.getScode()))
            {
                map.put("text","验证码错误!");
                return map;
            }else{
                String token =tokenService.getToken(log);
                map.put("text","登录成功!");
                map.put("token",token);
                map.put("coins",coins);
                map.put("ptype",ptype);
                return map;
            }
        }
    }

    @UserLoginToken
    @PostMapping("/getData")
    public Object getData()
    {
        if(run ==null)
            run = new RunHorse();
        RaceData rd = run.generatRace();
        raceData =rd ;
        index = rd.getIndex();
        Map<String,Object> ndata = new HashMap<>();
        ndata.put("bls",rd.getBl_list());
        return ndata;

    }
    @UserLoginToken
    @PostMapping("/zmResult")
    public Object zmResult()
    {
        Map<String ,Object> objectMap = new HashMap<>();
        objectMap.put("zindex",index);
        objectMap.put("pic",raceData.getMark_list().get(index)+".gif");
        objectMap.put("zmbl",raceData.getBl_list().get(index));
        return objectMap;
    }

    @PostMapping("/submitCZ")
    public int submitCZ(Long id)
    {
        CoinsCZ coinsCZ = coinsCZService.selectById(id);
        String uname =coinsCZ.getUname();
        User  u = userService.selectByName(uname);
        u.setCoins(coinsCZ.getCzs());
        userService.updateCoins(u);
        coinsCZService.deleteCoinsCZ(id);

        return 1;

    }

    @PostMapping("/deleteCZ")
    public int deleteCZ(Long id)
    {
        coinsCZService.deleteCoinsCZ(id);
        return 1;

    }

    @PostMapping("/submitTX")
    public int submitTX(Long id)
    {
        CoinsTX coinsTX = coinsTXService.selectById(id);
        String uname =coinsTX.getUname();

        User u = userService.selectByName(uname);
        u.setCoins( 0 - coinsTX.getTsl());
        userService.updateCoins(u);
        coinsTXService.deleteCoinsTX(id);
        return 1;

    }
    @PostMapping("/deleteTX")
    public int deleteTX(Long id)
    {
        coinsTXService.deleteCoinsTX(id);
        return 1;

    }

    @PostMapping("/userlogin")
    public int userLogin(String uname ,String pwd)
    {
        if(uname.equals("Admin"))
            if(pwd.equals("tonny1000"))
                return 1;
            return 0;

    }

    @PostMapping("/getFileType")
    public String getFileType(String uname)
    {
      List<TFile> files= fileService.selectByName(uname);
      if(files.size()>0)
          return files.get(0).getFtype();
      return ".png";
    }
}
