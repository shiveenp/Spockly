package com.shiveenp.neo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class NeoWithPageMetadata(
        @JsonProperty("links")
        val links: Links?,
        @JsonProperty("page")
        val page: Page?,
        @JsonProperty("near_earth_objects")
        val nearEarthObjects: List<NearEarthObject>?
)