plugins {
    java
    id("com.github.johnrengelman.shadow")
}

repositories {
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
}

dependencies {
    implementation(project(":core"))

    implementation("org.bstats:bstats-bukkit:2.2.1")
    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version)
        }
    }
}