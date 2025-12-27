package com.edigiyastore

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class ArchiveProvider : MainAPI() {

    override var mainUrl = "https://archive.org"
    override var name = "Archive Movies - Edigiya Store"
    override val lang = "ar"
    override val supportedTypes = setOf(TvType.Movie)

    override suspend fun search(query: String): List<SearchResponse>? {
        return listOf(
            MovieSearchResponse(
                name = "Archive Movie",
                url = "$mainUrl/details/BigBuckBunny_328",
                apiName = name,
                type = TvType.Movie,
                posterUrl = "https://archive.org/services/img/BigBuckBunny_328"
            )
        )
    }

    override suspend fun load(url: String): LoadResponse? {
        return MovieLoadResponse(
            name = "Public Domain Movie",
            url = url,
            dataUrl = url,
            posterUrl = "",
            plot = "From Archive.org (Edigiya Store)",
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
                name = "MP4 Server",
                url = "https://archive.org/download/BigBuckBunny_328/BigBuckBunny_512kb.mp4",
                referer = mainUrl,
                quality = Qualities.P720.value,
                isM3u8 = false
            )
        )

        return true
    }
}
