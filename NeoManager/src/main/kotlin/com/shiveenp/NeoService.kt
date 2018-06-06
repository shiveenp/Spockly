package com.shiveenp

import com.shiveenp.neo.models.NearEarthObject
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class NeoService {
    companion object {
        val LOG = LoggerFactory.getLogger(NeoController::class.java.name)
    }

    val neoUri = "https://api.nasa.gov/neo/rest/v1/neo/browse?api_key=f3fQwK3Kh2tBAeOc8Tn9H9B6MPmz39FGCwAtgLyt"
    val restTemplate = RestTemplate()

    fun getNeoJson() = restTemplate.getForObject(neoUri, String::class.java)

    fun createNearEarthObject(): NearEarthObject? {
        return restTemplate.getForObject("https://api.nasa.gov/neo/rest/v1/neo/2021277?api_key=f3fQwK3Kh2tBAeOc8Tn9H9B6MPmz39FGCwAtgLyt", NearEarthObject::class.java)
    }
}