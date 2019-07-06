package io.shiveenp.neo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class MissDistance(
        val astronomical: Double?,
        val lunar: Double?,
        val kilometers: Double?,
        val miles: Double?
)
