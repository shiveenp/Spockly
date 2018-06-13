package com.shiveenp

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Service
class NeoUriService(
        val neoManagerProperties: NeoManagerProperties) {
    companion object {
        val LOG = LoggerFactory.getLogger(NeoUriService::class.java.name)
        const val HTTPS_SCHEME = "https"
        const val API_KEY_PARAM_NAME = "api_key"
    }


    fun getNeoDataByIdUri(id: String): URI {
        val uri = UriComponentsBuilder.newInstance()
                .scheme(HTTPS_SCHEME)
                .host(neoManagerProperties.host)
                .queryParam(API_KEY_PARAM_NAME, neoManagerProperties.apiKey)
                .path("/{id}")
                .buildAndExpand(id)
                .toUri()
        LOG.debug("URI string to getById is: {}", uri)
        return uri
    }

    fun getNeoDataByPageUri(page: Int) = neoManagerProperties.baseBrowseUri + "?page=" + page + "&size=20&api_key=" + neoManagerProperties.apiKey
}

