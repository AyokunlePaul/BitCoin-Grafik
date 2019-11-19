// Top-level build file where you can add configuration options common to all sub-projects/modules.
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()
        maven { setUrl("https://jitpack.io") }
    }
    dependencies {
        classpath (kotlin("gradle-plugin", KotlinVersion))
        classpath (Config.Classpaths.gradle)
        classpath (Config.Classpaths.navigation)
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

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}