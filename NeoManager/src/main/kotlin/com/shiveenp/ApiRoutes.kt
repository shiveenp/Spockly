package com.shiveenp

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class ApiRoutes(private val neoService: NeoService, private val indexHandler: IndexHandler) {
    @Bean
    fun neoRouter() = router {
        (accept(MediaType.APPLICATION_JSON) and "/api").nest {
            "/neo".nest {
                GET("/{id}", neoService::getNeoById)
                POST("/index",indexHandler::initiateIndexing)
            }
        }
    }
}