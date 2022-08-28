# ⚙️ foundation

![Kotlin](https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white&color=0d1117)
[![Discord](https://img.shields.io/discord/908438033613848596?style=for-the-badge&logo=discord&logoColor=white&colorA=0d1117&colorB=1a222e)](https://discord.hexalite.org/)
![CI](https://img.shields.io/github/workflow/status/playhexalite/foundation/Kotlin%20CI%20with%20Gradle.svg?colorA=0d1117&colorB=1a222e&label=Workflow&style=for-the-badge&logo=githubactions&logoColor=white)
![Version](https://img.shields.io/nexus/s/org.hexalite/foundation-core?server=https%3A%2F%2Fs01.oss.sonatype.org&colorA=0d1117&colorB=1a222e&label=Maven&style=for-the-badge&logo=maven&logoColor=white)

Extended gameplay mechanics and brand-new code foundations for Minecraft: Java Edition platforms.

## 🎏 Getting Started

You can find information about how to use this library in the classes' documentation! We will go into more details as
soon our website is ready.

The installation process is pretty straightforward. You just need to install a compiled version of your platform of
choice and install it as a plugin. It will take care automatically of anything else that is required to run. The modules
are lazily downloaded: it only will be downloaded when required; unnecessary modules won't be downloaded.

> **Warning**
> The Bukkit platform implementation uses [Purpur] API behind the scenes, so you need to run a Purpur-based server 
> software. For now, [Petal] is highly recommended to achieve optimal performance.

[Petal]: https://github.com/Bloom-host/Petal

[Purpur]: https://github.com/PurpurMC/Purpur

## 🌀 Progress

**Goal:** An abstraction layer that can be implemented in any platform (e.g. Bukkit, Sponge, Velocity, etc.). That's
why all our of our modules are an independent/agnostic implementation.

- [ ] `core/biome` - Custom biomes support
- [ ] `core/command` - Kotlin command framework based on Brigadier
- [ ] `core/container` - Extended containers (player inventories, chests, etc.) API
- [ ] `core/ecs` - ECS (Entity Component System) architectural pattern support
- [ ] `core/entity` - Custom entities support
- [ ] `core/gameplay` - Custom items and custom blocks support
- [ ] `core/scoreboard` - Lightweight sidebar API
- [ ] `core/text` - Extended chat and text components API
- [ ] `platform/bukkit` - Implementation of all above for Purpur-based server implementations

### 🐚 Installation

**Gradle (Kotlin DSL)**
> ```kotlin
> repositories {
>    maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots/") {
>        name = "SonatypeSnapshots"
>    }
> }
> 
> dependencies {
>     // replace x.y.z with the latest version
>     implementation("org.hexalite", "foundation-platform-bukkit", "x.y.z")
> }
> ```
