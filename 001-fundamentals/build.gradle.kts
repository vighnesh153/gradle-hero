import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    id("base")
}

tasks.register<Copy>("copyMessage") {
    from("important-message.txt")
    into("$buildDir")
}

tasks.register<Copy>("generateDescriptions") {
    from("descriptions")
    into("$buildDir/descriptions")
    filter(ReplaceTokens::class, "tokens" to mapOf("THEME_PARK_NAME" to "Shreya's Park"))
}

tasks.register<Zip>("zipDescriptions") {
    from("$buildDir/descriptions")
    destinationDirectory.set(buildDir)
    archiveFileName.set("descriptions.zip")
}
