// Top-level build file where you can add configuration options common to all sub-projects/modules.
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("org.jlleitschuh.gradle.ktlint") version KtlintVersion
    id("jacoco")
}

ktlint {
    setVersion(Config.Versions.Ktlint)
    debug.set(true)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    reporters.set(setOf(ReporterType.PLAIN, ReporterType.CHECKSTYLE))
    ignoreFailures.set(true)
    kotlinScriptAdditionalPaths {
        include(fileTree("scripts/"))
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}

jacoco {
    toolVersion = Config.Versions.jacoco
}

buildscript {
    repositories {
        google()
        jcenter()
        maven { setUrl("https://jitpack.io") }
        maven { setUrl("https://plugins.gradle.org/m2/") }
    }
    dependencies {
        classpath(kotlin("gradle-plugin", KotlinVersion))
        classpath(Config.Classpaths.gradle)
        classpath(Config.Classpaths.navigation)
        classpath(Config.Classpaths.ktlint)
        classpath(Config.Classpaths.jacoco)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { setUrl("https://jitpack.io") }
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "jacoco")
}

task<JacocoReport>(GradleTasks.jacocoTestReport) {
    dependsOn(
        "app:testDebugUnitTest",
        "bitcoin-grafik:testDebugUnitTest",
        "domain:compileTestJava",
        "repository:compileTestJava",
        "remote:testDebugUnitTest",
        "local:testDebugUnitTest"
    )
    group = "Reporting"
    description = "This task generates a jacoco report for all unit test across all modules"

    reports {
        xml.isEnabled = false
        html.isEnabled = false
    }

    val fileFilter = listOf(
        "**/R.class",
        "**/R\$*.class",
        "**/BuildConfig.*",
        "**/Manifest*.*",
        "**/*Test*.*",
        "android/**/*.*",

        //Dagger 2
        "**/*Dagger*Component*.*",
        "**/*Module.*",
        "**/*Module\$*.*",
        "**/*MembersInjector*.*",
        "**/*_Factory*.*",
        "**/*Provide*Factory*.*"
    )
    val appFile = fileTree(mapOf("dir" to "${project.rootDir}/app/build/intermediates/javac/debug", "excludes" to fileFilter))
    val bitcoinGrafikFile = fileTree(mapOf("dir" to "${project.rootDir}/bitcoin-grafik/build/intermediates/javac/debug", "excludes" to fileFilter))
    val domainFile = fileTree(mapOf("dir" to "${project.rootDir}/domain/build/intermediates/javac/debug", "excludes" to fileFilter))
    val repositoryFile = fileTree(mapOf("dir" to "${project.rootDir}/repository/build/intermediates/javac/debug", "excludes" to fileFilter))
    val remoteFile = fileTree(mapOf("dir" to "${project.rootDir}/remote/build/intermediates/javac/debug", "excludes" to fileFilter))
    val localFile = fileTree(mapOf("dir" to "${project.rootDir}/local/build/intermediates/javac/debug", "excludes" to fileFilter))

    val appSourceDir = "${project.rootDir}/app/src/main/java"
    val bitcoinGrafikSourceDir = "${project.rootDir}/app/src/main/java"
    val domainSourceDir = "${project.rootDir}/app/src/main/java"
    val repositorySourceDir = "${project.rootDir}/app/src/main/java"
    val remoteSourceDir = "${project.rootDir}/app/src/main/java"
    val localSourceDir = "${project.rootDir}/app/src/main/java"

    val appExecutionData = "app/build/jacoco/testDebugUnitTest.exec"
    val bitcoinGrafikExecutionData = "bitcoin-grafik/build/jacoco/testDebugUnitTest.exec"
    val domainExecutionData = "domain/build/jacoco/testDebugUnitTest.exec"
    val repositoryExecutionData = "repository/build/jacoco/testDebugUnitTest.exec"
    val remoteExecutionData = "remote/build/jacoco/testDebugUnitTest.exec"
    val localExecutionData = "local/build/jacoco/testDebugUnitTest.exec"

    classDirectories.setFrom(files(appFile, bitcoinGrafikFile, domainFile, repositoryFile, remoteFile, localFile))
    additionalSourceDirs.from(files(appSourceDir, bitcoinGrafikSourceDir, domainSourceDir, repositorySourceDir, remoteSourceDir, localSourceDir))
    sourceDirectories.setFrom(files(appSourceDir, bitcoinGrafikSourceDir, domainSourceDir, repositorySourceDir, remoteSourceDir, localSourceDir))

    val executionDataFileTree = mapOf(
        "dir" to "${project.rootDir}",
        "includes" to listOf(
            appExecutionData,
            bitcoinGrafikExecutionData,
            domainExecutionData,
            repositoryExecutionData,
            remoteExecutionData,
            localExecutionData
        )
    )
    executionData.setFrom(fileTree(executionDataFileTree))
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}