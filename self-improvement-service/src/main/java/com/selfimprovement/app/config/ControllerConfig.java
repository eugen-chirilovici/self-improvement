package com.selfimprovement.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.selfimprovement.app.controller")
public class ControllerConfig {
}
