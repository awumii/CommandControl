plugins {
    java
    id("net.kyori.blossom") version "1.2.0"
}

blossom {
    replaceToken("{version}", project.version)
}

repositories {
    maven { url = uri("https://nexus.velocitypowered.com/repository/maven-public/") }
}

dependencies {
    implementation(project(":core"))

    implementation("org.bstats:bstats-velocity:2.2.1")

    compileOnly("com.velocitypowered:velocity-api:1.1.5")
    annotationProcessor("com.velocitypowered:velocity-api:1.1.5")
}