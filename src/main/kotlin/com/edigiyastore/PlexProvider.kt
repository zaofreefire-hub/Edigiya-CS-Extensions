package com.edigiyastore

import com.lagradost.cloudstream3.*

class PlexProvider : MainAPI() {

    override var mainUrl = "https://plex.tv"
    override var name = "Plex Free Movies - Edigiya Store"
    override val lang = "ar"
    override val supportedTypes = setOf(TvType.Movie)

    override suspend fun search(query: String): List<SearchResponse>? {
        return listOf(
            MovieSearchResponse(
                name = "Plex Sample Movie",
                url = mainUrl,
                apiName = name,
                type = TvType.Movie,
                posterUrl = ""
            )
        )
    }

    override suspend fun load(url: String): LoadResponse? {
        return MovieLoadResponse(
            name = "Plex Movie",
            url = url,
            dataUrl = url,
            posterUrl = "",
            plot = "Sample Plex Content",
            recommendations = listOf()
        )
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {

        callback(
            ExtractorLink(
                source = name,
                name = "Plex Server",
                url = "https://stream.plex.tv/video.mp4",
                referer = mainUrl,
                quality = Qualities.P1080.value,
                isM3u8 = false
            )
        )

        return true
    }
}
