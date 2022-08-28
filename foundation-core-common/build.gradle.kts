plugins {
    id("foundation-jvm-conventions")
    id("foundation-publishing-conventions")
}

dependencies {
    implementation(foundation.adventure.api)
    api(foundation.uuid)
}

