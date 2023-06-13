package com.vighnesh153.pokemon

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.RegularFileProperty
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.register

interface FileDiffPluginExtension {
    val file1: RegularFileProperty
    val file2: RegularFileProperty
}

class FileDiffPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<FileDiffPluginExtension>("fileDiff")

        project.tasks.register<FileDiffTask>("fileDiff") {
            file1.set(extension.file1)
            file2.set(extension.file2)
        }
    }
}
