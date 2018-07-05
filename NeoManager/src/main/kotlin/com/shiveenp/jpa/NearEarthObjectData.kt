package com.shiveenp.jpa

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "near_earth_object")
data class NearEarthObjectData(
        @Id
        @Column(name = "neo_reference_id")
        val neoReferenceId: Int?,
        @Column(name = "name")
        val name: String?,
        @Column(name = "nasa_jpl_url")
        val nasaJplUrl: String?,
        @Column(name = "absolute_magnitude_h")
        val absoluteMagnitudeH: Double?,
        @Column(name = "estimated_diameter_km_min", columnDefinition = "float4")
        val estimatedDiameterKmMin: Double?,
        @Column(name = "is_potentially_hazardous_asteroid")
        val isPotentiallyHazardousAsteroid: Boolean?,
        @Column(name = "close_approach_dt")
        val closeApproachDt: String?,
        @Column(name = "epoch_date_velocity_approach")
        val epochDateCloseApproach: String?,
        @Column(name = "relative_velocity_kmps",  columnDefinition = "float4")
        val relativeVelocityKmps: Double?,
        @Column(name = "relative_velocity_kmph",  columnDefinition = "float4")
        val relativeVelocityKmph: Double?,
        @Column(name = "relative_velocity_mph",  columnDefinition = "float4")
        val relativeVelocityMph: Double?,
        @Column(name = "miss_distance_astronomical",  columnDefinition = "float4")
        val missDistanceAstronomical: Double?,
        @Column(name = "miss_distance_lunar",  columnDefinition = "float4")
        val missDistanceLunar: Double?,
        @Column(name = "miss_distance_km",  columnDefinition = "float4")
        val missDistanceKm: Double?,
        @Column(name = "miss_distance_miles",  columnDefinition = "float4")
        val missDistanceMiles: Double?,
        @Column(name = "orbiting_body")
        val orbitingBody: String?,
        @Column(name = "orbit_id", columnDefinition = "int2")
        val orbitId: Int?,
        @Column(name = "orbit_determination_dt")
        val orbitDeterminationDt: String?,
        @Column(name = "orbit_uncertainity",  columnDefinition = "float4")
        val orbitUncertainity: Double?,
        @Column(name = "min_orbit_intersection",  columnDefinition = "float4")
        val minOrbitIntersection: Double?,
        @Column(name = "jupiter_tisserand_invariant",  columnDefinition = "float4")
        val jupiterTisserandInvariant: Double?,
        @Column(name = "epoch_osculation",  columnDefinition = "float4")
        val epochOsculation: Double?,
        @Column(name = "eccentricity",  columnDefinition = "float4")
        val eccentricity: Double?,
        @Column(name = "semi_major_axis",  columnDefinition = "float4")
        val semiMajorAxis: Double?,
        @Column(name = "inclination",  columnDefinition = "float4")
        val inclination: Double?,
        @Column(name = "ascending_node_longitude",  columnDefinition = "float4")
        val ascendingNodeLongitude: Double?,
        @Column(name = "orbital_period",  columnDefinition = "float4")
        val orbitalPeriod: Double?,
        @Column(name = "perihelion_distance",  columnDefinition = "float4")
        val perihelionDistance: Double?,
        @Column(name = "perihelion_argument",  columnDefinition = "float4")
        val perihelionArgument: Double?,
        @Column(name = "aphelion_distance",  columnDefinition = "float4")
        val aphelionDistance: Double?,
        @Column(name = "perihelion_time",  columnDefinition = "float4")
        val perihelionTime: Double?,
        @Column(name = "mean_anomaly",  columnDefinition = "float4")
        val meanAnomaly: Double?,
        @Column(name = "mean_motion",  columnDefinition = "float4")
        val meanMotion: Double?,
        @Column(name = "equinox")
        val equinox: String?
)