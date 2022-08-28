plugins {
    id("foundation-jvm-conventions")
    id("foundation-publishing-conventions")
}

dependencies {
    arrayOf(
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
    ).forEach {
        api(project(it))
    }
}
