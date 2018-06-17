package com.shiveenp

import com.shiveenp.neo.models.NearEarthObject
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NeoController(val neoService: NeoService) {
    companion object {
        val LOG = LoggerFactory.getLogger(NeoController::class.java.name)
    }


    @GetMapping("/neo/{id}")
    fun getNeoById(@PathVariable id: String): NearEarthObject? = neoService.getNeoById(id)

    @GetMapping("/saveNeo/{id}")
    fun saveNeoById(@PathVariable id: String) = neoService.saveNeoInTheDbById(id)

    @GetMapping("getByPageNumber/{pageNumber}")
    fun getNeoWithMetadata(@PathVariable pageNumber: String) = neoService.getNeoByPageNumber(pageNumber)

    @PostMapping("saveAllNeoInDb")
    fun saveAllNeoInDb() = neoService.iterateAndSaveAllNeo()

}