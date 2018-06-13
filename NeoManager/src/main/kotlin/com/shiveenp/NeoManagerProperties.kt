package com.shiveenp

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("neomanager")
data class NeoManagerProperties(
        var baseUri: String = "",
        var baseBrowseUri: String = "",
        var getByIdUri: String = "",
        var host: String = "",
        var apiKey: String = ""
)