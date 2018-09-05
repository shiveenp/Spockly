package com.shiveenp.neo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ClosestApproachData(
        @JsonProperty("close_approach_date")
        val closeApproachDate: String,
        @JsonProperty("epoch_date_close_approach")
        val epochDateCloseApproach: String,
        @JsonProperty("relative_velocity")
        val relativeVelocity: RelativeVelocity,
        @JsonProperty("miss_distance")
        val missDistance: MissDistance,
        @JsonProperty("orbiting_body")
        val orbitingBody: String
)