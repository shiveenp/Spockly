package com.shiveenp.neo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Kilometers(
        @JsonProperty("estimated_diameter_min")
        val estimatedKmDiameterMin: Double,
        @JsonProperty("estimated_diameter_max")
        val estimatedKmDiameterMax: Double
)