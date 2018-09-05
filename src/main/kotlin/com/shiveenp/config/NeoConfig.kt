package com.shiveenp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class NeoConfig {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }


}