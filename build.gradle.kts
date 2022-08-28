@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(foundation.plugins.kotlin.jvm) apply false
    alias(foundation.plugins.kotlin.serialization) apply false
    alias(foundation.plugins.dokka) apply false
}

allprojects {
    repositories {
        maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots/") {
            name = "Sonatype"
        }
        maven(url = "https://repo.papermc.io/repository/maven-public/") {
            name = "PaperMC"
        }
        mavenCentral()
    }
}
