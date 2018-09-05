package com.shiveenp.neo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Links(
        @JsonProperty("next")
        val next: String?,
        @JsonProperty("prev")
        val prev: String?,
        @JsonProperty("self")
        val self: String?
)