package com.shiveenp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor


@Configuration
@EnableAsync
class NeoAsyncConfigurer : AsyncConfigurer {

    @Bean("neoIndexerAsync")
    override fun getAsyncExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 1
        executor.maxPoolSize = 1
        executor.setQueueCapacity(0)
        executor.threadNamePrefix = "NeoIndexer-"
        executor.initialize()
        return executor
    }

}