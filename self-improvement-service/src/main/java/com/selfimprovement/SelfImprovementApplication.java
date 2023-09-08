package com.selfimprovement;

import com.selfimprovement.app.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = AppConfig.class)
public class SelfImprovementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelfImprovementApplication.class, args);
    }
}
