package com.shiveenp.neo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class RelativeVelocity(
        @JsonProperty("kilometers_per_second")
        val kmps: Double?,
        @JsonProperty("kilometers_per_hour")
        val kmph: Double?,
        @JsonProperty("miles_per_hour")
        val mph: Double?
)