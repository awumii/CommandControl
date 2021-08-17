plugins {
    java
}

dependencies {
    implementation("org.spongepowered:configurate-hocon:4.1.1")

    compileOnly("net.kyori:adventure-api:4.8.1")
    compileOnly("net.kyori:adventure-text-serializer-legacy:4.8.1")
    compileOnly("org.slf4j:slf4j-api:1.7.32")
}