package com.shiveenp

import com.shiveenp.jpa.NearEarthObjectData
import com.shiveenp.jpa.NearEarthObjectRepository
import com.shiveenp.neo.models.NearEarthObject
import com.shiveenp.neo.models.NeoWithPageMetadata
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import javax.transaction.Transactional

@Service
class NeoService(
        val neoUriService: NeoUriService,
        val restTemplate: RestTemplate,
        val nearEarthObjectRepository: NearEarthObjectRepository) {
    companion object {
        const val START_PAGE = "0"
        val logger = LoggerFactory.getLogger(NeoService::class.java.name)
    }

    fun iterateAndSaveAllNeo(): Mono<String> {
        logger.info("Starting indexing")
        val neoWithMetadata = restTemplate.getForObject(neoUriService.getNeoBrowseUriByPage(NeoService.START_PAGE), NeoWithPageMetadata::class.java)
        try {
            for (i in 1..neoWithMetadata!!.page?.totalPages!!)  {
                retrieveAndSavePage(i)
            }
        } catch (e: Exception) {
            NeoService.logger.error("Unable to index all neos due to", e)
        }
        return Mono.empty<String>()
    }

    @Transactional
    fun retrieveAndSavePage(pageNumber: Int) {
        val neoWithPageMetadata = restTemplate.getForObject(neoUriService.getNeoBrowseUriByPage(pageNumber.toString()), NeoWithPageMetadata::class.java)
        neoWithPageMetadata.nearEarthObjects?.forEach {
            logger.info("Object saved in db is: $it")
            saveNeoInDbByObject(it)
        }
    }

    fun saveNeoInDbByObject(nearEarthObject: NearEarthObject) {
        nearEarthObjectRepository.save(com.shiveenp.jpa.createNearEarthDataObjectFromNeoObject(nearEarthObject))
    }


    fun getNeoById(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("id")
        return ok()
            .body(restTemplate
                .getForObject(neoUriService.getNeoDataByIdUri(id), NearEarthObject::class.java))
    }


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

}