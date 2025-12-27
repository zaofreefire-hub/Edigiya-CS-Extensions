plugins {
    id("com.lagradost.cloudstream3.gradle-plugin")
    kotlin("android")
}

cloudstream {
    language.set("ar")
    description.set("Cima provider test plugin")
    authors.set(listOf("Edigiya Store"))
}
