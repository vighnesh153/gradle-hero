import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
}

tasks.withType<Test>().configureEach {
    // Using JUnitPlatform for running tests
    useJUnitPlatform()
}

gradlePlugin {
    plugins {
        create("fileDiffPlugin") {
            id = "fileDiffPlugin"
            implementationClass = "com.vighnesh153.pokemon.FileDiffPlugin"
        }
    }
}
