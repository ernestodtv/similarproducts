package com.zara.similarproducts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

  @Value("${remote.service.timeout-in-seconds}")
  private String timeoutInSeconds;

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    var timeout = Duration.ofMillis(Integer.parseInt(timeoutInSeconds) * 1000L);
    return restTemplateBuilder
        .setConnectTimeout(timeout)
        .setReadTimeout(timeout)
        .build();
  }

}
