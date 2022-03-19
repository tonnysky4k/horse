package com.yrxc.horse.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.yrxc.horse.entity.Login;
import com.yrxc.horse.mapper.LoginMapper;
import com.yrxc.horse.service.LoginService;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class SendSMS {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    int appId =1400288767;

    String appKey="208bee36bd60dc5fd6458e26a7eb0538";

    int  templateId=871112;
    String smsSign="鱼人新创";
    @Autowired
    LoginService loginService;

    public  void sendSms(String pho,String ip)
    {
        int key = 0;
        String[] phoneNumbers = {"1"};
        phoneNumbers[0] = pho;
        Random rand = new Random();
        key = rand.nextInt(10000);
        String s = String.valueOf(key);
        switch (s.length()){
            case 1:
                s="000"+s;
            case 2:
                s="00"+s;
            case 3:
                s="0"+s;
        }
        try {
            String[] params = {"5678"};
            params[0] = s;
            SmsSingleSender ssender = new SmsSingleSender(appId, appKey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, smsSign, "", "");
            Login l = new Login();
            l.setUname(pho);
            l.setScode(s);
            l.setIndate(new Date());
            loginService.insertLogin(l);
            logger.info("短信发送成功！");
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
            logger.info("短信失败！");
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
            logger.info("短信失败！");
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
            logger.info("短信失败！");
        }
    }
}
