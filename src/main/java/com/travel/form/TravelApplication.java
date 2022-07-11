package com.travel.form;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.logging.Logger;


/**
 * @author by 李泽阳 2021/12/2 17:56
 * @description：
 */
@MapperScan("com.travel.form.mapper")
@SpringBootApplication
@EnableSwagger2
@EnableAsync
@EnableTransactionManagement(proxyTargetClass = true)
public class TravelApplication {
    private static final Logger logger = Logger.getLogger(String.valueOf(TravelApplication.class));

    public static void main(String[] args) {
        SpringApplication.run(TravelApplication.class, args);
        logger.info("========================启动成功==============================");
    }

}
