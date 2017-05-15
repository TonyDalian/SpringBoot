package com.fil.ap.bean;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(ConditionWindows.class)
    public ConditionListService windowsListService() {
        return new ConditionWindowsListService();
    }

    @Bean
    @Conditional(ConditionLinux.class)
    public ConditionListService linuxListService() {
        return new ConditionLinuxListService();
    }
}