package com.selfimprovement.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.selfimprovement.app.mapper",
        "com.selfimprovement.app.service",
        "com.selfimprovement.app.repository",
        "com.selfimprovement.app.facade"
})
public class ServiceConfig {
}
