plugins {
    id("java")
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
}

// plugins {
//     id("application")
// }

// application {
//     mainClass.set("com.vighnesh153.PokemonApplication")
// }

repositories {
    mavenCentral()
    google()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(18))
    }
}

dependencies {
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
    // dependency version handled by the dependency management plugin
    implementation("org.springframework.boot:spring-boot-starter-web")
}
