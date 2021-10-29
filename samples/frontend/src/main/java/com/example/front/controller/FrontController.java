package com.example.front.controller;

import com.example.front.model.Product;
import com.example.front.service.FrontService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@ComponentScan("com.example.front.service")
@Controller
public class FrontController {

    public FrontController() throws Exception {
        //log.info("init controller: 30s");
        //Thread.sleep(2_000L);
    }

    @Autowired
    private FrontService frontService;

    @GetMapping("/")
    public String index(Model model) {
        log.info("Mapping: Index");
        model.addAttribute("host", getHost());
        return "index";
    }

    @GetMapping("/retry")
    public String retry(Model model) {
        log.info("Start: retry");
        Mono<Product[]> items = frontService.get();

        model.addAttribute("items", items);
        return "retry";
    }

    @GetMapping("/sleep")
    public String sleep(Model model) throws Exception {
        log.info("Sleep: 30s");
        Thread.sleep(180_000L); // 30秒後に画面返す

        model.addAttribute("message", " Graceful shutdown complete");
        return "sleep";
    }

    @GetMapping("/host")
    public String host(Model model) {
        model.addAttribute("host", getHost());
        return "host";
    }

    private String getHost() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
        }
        return "UnknownHost";
    }

}
