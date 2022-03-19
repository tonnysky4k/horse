package com.yrxc.horse;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class HorseApp {

    public static void main(String[] args)
    {
        SpringApplication.run(HorseApp.class,args);
    }
}
