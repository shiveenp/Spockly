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
        @Column(name = "estimated_diameter_km_min")
        val estimatedDiameterKmMin: Double?,
        @Column(name = "is_potentially_hazardous_asteroid")
        val isPotentiallyHazardousAsteroid: Boolean?,
        @Column(name = "close_approach_dt")
        val closeApproachDt: String?,
        @Column(name = "epoch_date_close_approach")
        val epochDateCloseApproach: String?,
        @Column(name = "relative_velocity_kmps")
        val relativeVelocityKmps: Double?,
        @Column(name = "relative_velocity_kmph")
        val relativeVelocityKmph: Double?,
        @Column(name = "relative_velocity_mph")
        val relativeVelocityMph: Double?,
        @Column(name = "miss_distance_astronomical")
        val missDistanceAstronomical: Double?,
        @Column(name = "miss_distance_lunar")
        val missDistanceLunar: Double?,
        @Column(name = "miss_distance_km")
        val missDistanceKm: Double?,
        @Column(name = "miss_distance_miles")
        val missDistanceMiles: Double?,
        @Column(name = "orbiting_body")
        val orbitingBody: String?,
        @Column(name = "orbit_id")
        val orbitId: Int?,
        @Column(name = "orbit_determination_dt")
        val orbitDeterminationDt: String?,
        @Column(name = "orbit_uncertainity")
        val orbitUncertainity: Double?,
        @Column(name = "min_orbit_intersection")
        val minOrbitIntersection: Double?,
        @Column(name = "jupiter_tisserand_invariant")
        val jupiterTisserandInvariant: Double?,
        @Column(name = "epoch_osculation")
        val epochOsculation: Double?,
        @Column(name = "eccentricity")
        val eccentricity: Double?,
        @Column(name = "semi_major_axis")
        val semiMajorAxis: Double?,
        @Column(name = "inclination")
        val inclination: Double?,
        @Column(name = "ascending_node_longitude")
        val ascendingNodeLongitude: Double?,
        @Column(name = "orbital_period")
        val orbitalPeriod: Double?,
        @Column(name = "perihelion_distance")
        val perihelionDistance: Double?,
        @Column(name = "perihelion_argument")
        val perihelionArgument: Double?,
        @Column(name = "aphelion_distance")
        val aphelionDistance: Double?,
        @Column(name = "perihelion_time")
        val perihelionTime: Double?,
        @Column(name = "mean_anomaly")
        val meanAnomaly: Double?,
        @Column(name = "mean_motion")
        val meanMotion: Double?,
        @Column(name = "equinox")
        val equinox: String?
)