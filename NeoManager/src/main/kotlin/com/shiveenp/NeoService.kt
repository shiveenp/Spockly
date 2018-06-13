package com.shiveenp

import com.shiveenp.neo.models.NearEarthObject
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class NeoService(
        val neoUriService: NeoUriService,
        val restTemplate: RestTemplate) {
    companion object {
        val LOG = LoggerFactory.getLogger(NeoController::class.java.name)
    }

    fun getNeoById(id: String): NearEarthObject? {
        return restTemplate.getForObject(neoUriService.getNeoDataByIdUri(id), NearEarthObject::class.java)
    }
}