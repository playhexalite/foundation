plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("gradle-plugin", foundation.versions.kotlin.get()))
    implementation(kotlin("serialization", foundation.versions.kotlin.get()))
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:" + foundation.plugins.dokka.get().version)
    implementation (files(foundation.javaClass.superclass.protectionDomain.codeSource.location))
}
