package com.example.mortyapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.http.HttpClient;

@Configuration
public class WebConfig {

    @Bean
    @Scope("prototype")
    public HttpClient getHttpClient() {
        return HttpClient.newHttpClient();
    }

}
