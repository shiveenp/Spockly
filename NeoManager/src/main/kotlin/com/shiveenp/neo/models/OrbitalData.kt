package com.shiveenp.neo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class OrbitalData(
        @JsonProperty("orbit_id")
        val orbitId: Int,
        @JsonProperty("orbit_determination_date")
        val orbitDeterminationDate: String,
        @JsonProperty("orbit_uncertainty")
        val orbitUncertainity: Double,
        @JsonProperty("minimum_orbit_intersection")
        val minOrbitIntersection: Double,
        @JsonProperty("jupiter_tisserand_invariant")
        val jupiterTisserandInvariant: Double,
        @JsonProperty("epoch_osculation")
        val epochOsculation: Double,
        @JsonProperty("eccentricity")
        val eccentricity: Double,
        @JsonProperty("semi_major_axis")
        val semiMajorAxis: Double,
        @JsonProperty("inclination")
        val inclination: Double,
        @JsonProperty("ascending_node_longitude")
        val ascendingNodeLongitude: Double,
        @JsonProperty("orbital_period")
        val orbitalPeriod: Double,
        @JsonProperty("perihelion_distance")
        val perihelionDistance: Double,
        @JsonProperty("perihelion_argument")
        val periHelionArgument: Double,
        @JsonProperty("aphelion_distance")
        val aphelionDistance: Double,
        @JsonProperty("perihelion_time")
        val perihelionTime: Double,
        @JsonProperty("mean_anomaly")
        val meanAnomaly: Double,
        @JsonProperty("mean_motion")
        val meanMotion: Double,
        @JsonProperty("equinox")
        val equinox: String
)