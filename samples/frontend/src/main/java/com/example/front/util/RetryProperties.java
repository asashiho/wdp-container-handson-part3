package com.example.front.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="retry")
@Getter @Setter
public class RetryProperties {

    private int backoff;
    private int duration;
    private double jitter;

}
