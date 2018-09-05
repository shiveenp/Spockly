package com.shiveenp.jpa

import com.shiveenp.neo.models.NearEarthObject
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

fun createNearEarthDataObjectFromNeoObject(nearEarthObject: NearEarthObject?): NearEarthObjectData {
        return NearEarthObjectData(
            neoReferenceId = nearEarthObject?.neoRefId,
            name = nearEarthObject?.name,
            nasaJplUrl = nearEarthObject?.nasaJplUrl,
            absoluteMagnitudeH = nearEarthObject?.absoluteMagnitudeH,
            estimatedDiameterKmMin = nearEarthObject
                ?.estimatedDiameter
                ?.kilometers
                ?.estimatedKmDiameterMin,
            isPotentiallyHazardousAsteroid = nearEarthObject?.isPotentiallyHazardousAsteroid,
            closeApproachDt = if (nearEarthObject?.closestApproachData?.isEmpty()!!) null else nearEarthObject.closestApproachData[0].closeApproachDate,
            epochDateCloseApproach = if (nearEarthObject.closestApproachData.isEmpty()) null else nearEarthObject.closestApproachData[0].epochDateCloseApproach,
            relativeVelocityKmps = if (nearEarthObject.closestApproachData.isEmpty()) null else nearEarthObject.closestApproachData[0].relativeVelocity.kmps,
            relativeVelocityKmph = if (nearEarthObject.closestApproachData.isEmpty()) null else nearEarthObject.closestApproachData[0].relativeVelocity.kmph,
            relativeVelocityMph = if (nearEarthObject.closestApproachData.isEmpty()) null else nearEarthObject.closestApproachData[0].relativeVelocity.mph,
            missDistanceAstronomical = if (nearEarthObject.closestApproachData.isEmpty()) null else nearEarthObject.closestApproachData[0].missDistance.astronomical,
            missDistanceLunar = if (nearEarthObject.closestApproachData.isEmpty()) null else nearEarthObject.closestApproachData[0].missDistance.lunar,
            missDistanceKm = if (nearEarthObject.closestApproachData.isEmpty()) null else nearEarthObject.closestApproachData[0].missDistance.kilometers,
            missDistanceMiles = if (nearEarthObject.closestApproachData.isEmpty()) null else nearEarthObject.closestApproachData[0].missDistance.miles,
            orbitingBody = if (nearEarthObject.closestApproachData.isEmpty()) null else nearEarthObject.closestApproachData[0].orbitingBody,
            orbitId = nearEarthObject.orbitalData?.orbitId,
            orbitDeterminationDt = nearEarthObject.orbitalData?.orbitDeterminationDate,
            orbitUncertainity = nearEarthObject.orbitalData?.orbitUncertainity,
            minOrbitIntersection = nearEarthObject.orbitalData?.minOrbitIntersection,
            jupiterTisserandInvariant = nearEarthObject.orbitalData?.jupiterTisserandInvariant,
            epochOsculation = nearEarthObject.orbitalData?.epochOsculation,
            eccentricity = nearEarthObject.orbitalData?.eccentricity,
            semiMajorAxis = nearEarthObject.orbitalData?.semiMajorAxis,
            inclination = nearEarthObject.orbitalData?.inclination,
            ascendingNodeLongitude = nearEarthObject.orbitalData?.ascendingNodeLongitude,
            orbitalPeriod = nearEarthObject.orbitalData?.orbitalPeriod,
            perihelionDistance = nearEarthObject.orbitalData?.perihelionDistance,
            perihelionArgument = nearEarthObject.orbitalData?.periHelionArgument,
            aphelionDistance = nearEarthObject.orbitalData?.aphelionDistance,
            perihelionTime = nearEarthObject.orbitalData?.perihelionTime,
            meanAnomaly = nearEarthObject.orbitalData?.meanAnomaly,
            meanMotion = nearEarthObject.orbitalData?.meanMotion,
            equinox = nearEarthObject.orbitalData?.equinox
        )
}
