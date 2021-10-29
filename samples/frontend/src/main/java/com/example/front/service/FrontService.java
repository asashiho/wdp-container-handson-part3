package com.example.front.service;

import java.time.Duration;

import com.example.front.model.Product;
import com.example.front.util.AppProperties;
import com.example.front.util.RetryProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@Slf4j
@RestController
@ComponentScan("com.example.front.util")
@Service
public class FrontService {

    @Autowired
    private AppProperties app;

    @Autowired
    private RetryProperties retry;

    private WebClient webClient = WebClient.builder().build();

    // retry opetatorの場合
    // public Mono<Employee[]> get() {

    // return webClient.get()
    // .uri(this.getUri())
    // .retrieve()
    // .bodyToMono(Employee[].class)
    // .retry(3);
    // }

    // retryWhen opetatorの場合
    // public Mono<Employee[]> get() {

    // return webClient.get()
    // .uri(this.getUri())
    // .retrieve()
    // .bodyToMono(Employee[].class)
    // .retryWhen(Retry.fixedDelay(4,Duration.ofSeconds(5)));
    // }

    // retryWhen opetator with jitter with
    public Mono<Product[]> get() {

        return webClient.get()
            .uri(this.getUri())
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Product[].class)
            .retryWhen(Retry.backoff(retry.getBackoff(), Duration.ofSeconds(retry.getDuration()))
                .jitter(retry.getJitter())
                .doBeforeRetry(sig -> {
                    log.error("Retrying: " + sig.totalRetries());
                }));
    }

    private String getUri() {
        return app.getService() + ":" + app.getPort() + "/items";
    }

}
