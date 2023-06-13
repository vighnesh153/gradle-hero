import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("fileDiffPlugin") {
            id = "fileDiffPlugin"
            implementationClass = "com.vighnesh153.pokemon.FileDiffPlugin"
        }
    }
}
