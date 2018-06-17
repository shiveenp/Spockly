package com.shiveenp

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Service
class NeoUriService(
        val neoManagerProperties: NeoManagerProperties) {
    companion object {
        val LOG = LoggerFactory.getLogger(NeoUriService::class.java.name)
        const val HTTPS_SCHEME = "https"
        const val API_KEY_PARAM_NAME = "api_key"
        const val DEFAULT_PAGE_SIZE = "20"
    }


    fun getNeoDataByIdUri(id: String): URI {
        val uri = UriComponentsBuilder.newInstance()
                .scheme(HTTPS_SCHEME)
                .host(neoManagerProperties.host)
                .queryParam(API_KEY_PARAM_NAME, neoManagerProperties.apiKey)
                .path("/{id}")
                .buildAndExpand(id)
                .toUri()
        LOG.debug("URI string for getNeoDataByIdUri is: {}", uri)
        return uri
    }

    fun getNeoBrowseUriByPage(page: String): URI {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams["page"] = page
        queryParams["size"] = DEFAULT_PAGE_SIZE
        queryParams["api_key"] = neoManagerProperties.apiKey
        val uri = UriComponentsBuilder.newInstance()
                .scheme(HTTPS_SCHEME)
                .host(neoManagerProperties.baseBrowseHost)
                .queryParams(queryParams)
                .buildAndExpand()
                .toUri()
        LOG.debug("URI string for getNeoBrowseUriByPage is {}", uri)
        return uri
    }
}

