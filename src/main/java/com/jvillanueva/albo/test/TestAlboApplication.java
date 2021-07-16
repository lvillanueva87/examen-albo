package com.jvillanueva.albo.test;

import com.jvillanueva.albo.test.constants.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(Constants.PACKAGE_ALL)
@EnableFeignClients(basePackages = Constants.PACKAGE_ALL)
@EnableScheduling
public class TestAlboApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestAlboApplication.class, args);
  }
}
