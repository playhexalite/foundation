@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("foundation-jvm-conventions")
    id("foundation-publishing-conventions")
    alias(foundation.plugins.plugin.yml)
    alias(foundation.plugins.paperweight.userdev)
}

repositories {
    maven(url = "https://repo.purpurmc.org/snapshots/") {
        name = "PurpurMC"
    }
}

dependencies {
    implementation(project(":foundation-core-bom"))
    paperweightDevelopmentBundle(foundation.purpur.dev.bundle)
}
