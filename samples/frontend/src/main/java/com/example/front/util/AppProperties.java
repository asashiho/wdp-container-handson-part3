package com.example.front.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="product")
@Getter @Setter
public class AppProperties {

    private String service;
    private String port;

}
