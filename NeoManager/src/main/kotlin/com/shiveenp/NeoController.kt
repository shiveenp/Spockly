package com.shiveenp

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NeoController(val neoService: NeoService) {
    companion object {
        val LOG = LoggerFactory.getLogger(NeoController::class.java.name)
    }


    @GetMapping("/getBrowseListOfAsteroid")
    fun getSomething() = neoService.getNeoJson()

    @GetMapping("/getNearEarthObj")
    fun getNearEarthObj() = neoService.createNearEarthObject();
}