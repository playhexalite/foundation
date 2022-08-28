rootProject.name = "build-logic"

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    versionCatalogs {
        create("foundation") {
            from(files("../foundation.libs.toml"))
        }
    }
}
