plugins {
    id("com.lagradost.cloudstream3.gradle-plugin")
}

cloudstream {
    language.set("ar")
    description.set("Cima provider test plugin")
    authors.set(listOf("Edigiya Store"))
    pluginClass.set("com.cimaprovider.CimaProvider")
}
