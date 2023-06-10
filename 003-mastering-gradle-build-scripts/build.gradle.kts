description = "This is a Pikachu project"
group = "com.vighnesh153"
version = "1.0.0-SNAPSHOT"

plugins {
    id("base")
    id("java")
    id("org.barfuin.gradle.taskinfo") version "2.1.0"
}

repositories {
    mavenCentral()
    google()
    
    // custom repository
    // maven {
    //     url = "..."
    // }
}

dependencies {
    implementation("commons-beanutils:commons-beanutils:1.9.4")
}

val generateDescriptionsTask = tasks.register<Copy>("generateDescriptions") {
    dependsOn(tasks.named("clean"))

    group = "lol"
    description = "some description"

    from("my-dir")
    into("$buildDir/my-dir")

    doFirst {
        println("Configuring generateDescriptions...")
    }

    // "taskname" will also be executed when this task is executed
    // dependsOn("taskname")

    // if "taskname" is going to be executed, it will be executed before this task
    // mustRunAfter("taskname")

    // if "taskname" is going to be executed, it will be executed after this task
    // finalizedBy("taskname")
}

base {
    archivesName.set("stuff")
}

tasks.register<Zip>("zipDescriptions") {
    from(generateDescriptionsTask)
    destinationDirectory.set(buildDir)
    // archiveFileName.set("my-dir.zip")
}

// or
val generateDescriptions2 by tasks.registering(Copy::class) {
    group = "lol"
    description = "some description 2"
    dependsOn(generateDescriptionsTask)

    from("my-dir")
    into("$buildDir/my-dir")

    doFirst {
        println("Configuring generateDescriptions2...")
    }
}

tasks.named<Copy>("generateDescriptions") {
    description = description + " (updated)"
}

// should be avoided because it immediately configures the task
// tasks.getByName("generateDescriptions") {
//     description = description + " (updated)"
// }

generateDescriptions2 {
    description = description + " (updated)"
}