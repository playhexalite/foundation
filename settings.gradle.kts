rootProject.name = "foundation"
enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        maven(url = "https://repo.papermc.io/repository/maven-public/") {
            name = "PaperMC"
        }
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    versionCatalogs {
        create("foundation") {
            from(files("./foundation.libs.toml"))
        }
    }
}

includeBuild("build-logic")
include(
    ":foundation-core-bom",
    ":foundation-core-biome",
    ":foundation-core-command",
    ":foundation-core-common",
    ":foundation-core-container",
    ":foundation-core-ecs",
    ":foundation-core-entity",
    ":foundation-core-gameplay",
    ":foundation-core-scoreboard",
    ":foundation-core-text",
    ":foundation-platform-bukkit",
)
