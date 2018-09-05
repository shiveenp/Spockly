package com.shiveenp.neo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Page(
        @JsonProperty("size")
        val size: Int?,
        @JsonProperty("total_elements")
        val totalElements: Int?,
        @JsonProperty("total_pages")
        val totalPages: Int?,
        @JsonProperty("number")
        val number: Int?
)