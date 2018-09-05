package com.shiveenp

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserter
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class IndexHandler(private val neoService: NeoService) {

    //ToDo: Debug why the async runs but we get a null pointer exception on the REST call
    @Async("neoIndexerAsync")
    fun initiateIndexing(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.accepted().body(BodyInserters.fromObject(Mono.just("").then(neoService.iterateAndSaveAllNeo())))
    }
}