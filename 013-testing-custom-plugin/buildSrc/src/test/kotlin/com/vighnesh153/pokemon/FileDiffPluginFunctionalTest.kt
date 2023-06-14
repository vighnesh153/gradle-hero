package com.vighnesh153.pokemon

import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.api.Assertions.*
import java.io.File
import org.gradle.testkit.runner.TaskOutcome.SUCCESS


class FileDiffPluginFunctionalTest {
    @field:TempDir
    lateinit var testProjectDir: File

    lateinit var testFile1: File
    lateinit var testFile2: File
    lateinit var buildFile: File

    @BeforeEach
    fun setup() {
        testFile1 = File(testProjectDir, "testFile1.txt")
        testFile2 = File(testProjectDir, "testFile2.txt")
        buildFile = File(testProjectDir, "build.gradle.kts")

        buildFile.writeText("""
            plugins {
                id("fileDiffPlugin")
            }

            fileDiff {
                file1.set(project.file("${testFile1.name}"))
                file2.set(project.file("${testFile2.name}"))
            }
        """.trimIndent())
    }

    @Test
    fun `can diff 2 files when both files have same size`() {
        // arrange
        testFile1.createNewFile()
        testFile2.createNewFile()

        // act
        val result = GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withArguments("fileDiff")
                .withPluginClasspath()
                .build()

        // assert
        assertTrue(result.output.contains("testFile1.txt and testFile2.txt have the same size"))
        assertEquals(result.task(":fileDiff")?.outcome, SUCCESS)
    }

    @Test
    fun `can diff 2 files where first file is larger than second`() {
        // arrange
        testFile1.createNewFile()
        testFile2.writeText("Some text")

        // act
        val result = GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withArguments("fileDiff")
                .withPluginClasspath()
                .build()

        // assert
        assertTrue(result.output.contains("testFile2.txt is larger"))
        assertEquals(result.task(":fileDiff")?.outcome, SUCCESS)
    }

    @Test
    fun `can diff 2 files where second file is larger than first`() {
        // arrange
        testFile1.writeText("Some text")
        testFile2.createNewFile()

        // act
        val result = GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withArguments("fileDiff")
                .withPluginClasspath()
                .build()

        // assert
        assertTrue(result.output.contains("testFile1.txt is larger"))
        assertEquals(result.task(":fileDiff")?.outcome, SUCCESS)
    }
}