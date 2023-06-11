plugins {
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    id("pokemon-conventions")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation(project(":service"))
    implementation(project(":ui"))
}
