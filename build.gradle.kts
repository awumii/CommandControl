plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

allprojects {
    group = "me.xneox"
    version = "1.0.0"

    repositories {
        mavenCentral()
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    shadowJar {
        minimize()

        relocate("org.bstats", "me.xneox.commandcontrol.libs.bstats")
        relocate("org.spongepowered.configurate", "me.xneox.commandcontrol.libs.configurate")
        relocate("io.leangen.geantyref", "me.xneox.commandcontrol.libs.geantyref")
        relocate("com.typesafe.config", "me.xneox.commandcontrol.libs.config")
    }
}


// Include all platforms in one jar.
dependencies {
    implementation(project(":core"))
    implementation(project(":paper"))
    implementation(project(":velocity"))
}