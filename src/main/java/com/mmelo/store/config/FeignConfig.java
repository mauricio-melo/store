package com.mmelo.store.config;

import com.mmelo.store.integration.ProviderClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {ProviderClient.class})
public class FeignConfig {

}