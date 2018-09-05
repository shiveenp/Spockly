package com.shiveenp.neo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class NearEarthObject(
        @JsonProperty("links")
        val selfLink: Links?,
        @JsonProperty("neo_reference_id")
        val neoRefId: Int?,
        @JsonProperty("name")
        val name: String?,
        @JsonProperty("nasa_jpl_url")
        val nasaJplUrl: String?,
        @JsonProperty("absolute_magnitude_h")
        val absoluteMagnitudeH: Double?,
        @JsonProperty("estimated_diameter")
        val estimatedDiameter: EstimatedDiameter?,
        @JsonProperty("is_potentially_hazardous_asteroid")
        val isPotentiallyHazardousAsteroid: Boolean?,
        @JsonProperty("close_approach_data")
        val closestApproachData: List<ClosestApproachData>?,
        @JsonProperty("orbital_data")
        val orbitalData: OrbitalData?
)