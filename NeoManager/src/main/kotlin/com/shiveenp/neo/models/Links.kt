package com.shiveenp.neo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Links(
        val next: String?,
        val self: String?
)