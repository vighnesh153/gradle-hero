package com.vighnesh153.pokemon

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction

abstract class FileDiffTask : DefaultTask() {
  @get:InputFile
  abstract val file1: RegularFileProperty

  @get:InputFile
  abstract val file2: RegularFileProperty

  @TaskAction
  fun fileDiff() {
    val file1Name = file1.get().asFile.name
    val file1Length = file1.get().asFile.length()
    val file2Name = file2.get().asFile.name
    val file2Length = file2.get().asFile.length()

    println("sizeOf($file1Name) = $file1Length")
    println("sizeOf($file2Name) = $file2Length")

    if (file1Length == file2Length) {
      println("$file1Name and $file2Name have the same size")
    } else if (file1Length > file2Length) {
      println("$file1Name is larger")
    } else {
      println("$file2Name is larger")
    }
  }
}
