import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    id("base")
}

tasks.register<Copy>("generateDescriptions") {
    dependsOn(":clean")

    from("my-dir")
    into("$buildDir/my-dir")
    filter<ReplaceTokens>("tokens" to mapOf("THEME_PARK_NAME" to "Essel world"))
}

tasks.register<Zip>("zipDescriptions") {
    dependsOn(":generateDescriptions")

    from("$buildDir/my-dir/")
    destinationDirectory.set(buildDir)
    archiveFileName.set("descriptions.zip")
}
