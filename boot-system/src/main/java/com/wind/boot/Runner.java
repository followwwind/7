package com.wind.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title: Runner
 * @Package com.wind.boot
 * @Description: 启动程序入口
 * @author huanghy
 * @date 2019/2/26 9:29
 * @version V1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.wind.boot")
public class Runner {

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

}
