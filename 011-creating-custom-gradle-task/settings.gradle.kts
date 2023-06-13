/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user manual at https://docs.gradle.org/8.0.2/userguide/multi_project_builds.html
 */

rootProject.name = "011-creating-custom-gradle-task"

plugins {
    // download repositories: https://docs.gradle.org/8.0.2/userguide/toolchains.html#sub:download_repositories
    // used for automatically downloading different java toolchains (upgrading from 1 version to newer one)
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.4.0")
}

include("service")
include("api")
include("ui")
