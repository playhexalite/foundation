plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

val foundation = the<org.gradle.accessors.dm.LibrariesForFoundation>()

tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn", "-Xcontext-receivers")
            jvmTarget = "17"
        }
    }
    test {
        useJUnitPlatform()
    }
}

dependencies {
    implementation(foundation.kotlin.logging)
    implementation(foundation.bundles.kotlin)
    implementation(foundation.mechanism.core)
    testImplementation(foundation.bundles.kotest)
    testImplementation(foundation.mockk)
    testImplementation(foundation.kotest.runner.junit5)
    testImplementation(foundation.slf4j.simple)
    testImplementation(kotlin("test-common"))
    testImplementation(kotlin("test-annotations-common"))
}

kotlin {
    explicitApi()
}
