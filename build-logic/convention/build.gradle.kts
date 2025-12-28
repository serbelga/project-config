plugins {
    `kotlin-dsl`
    alias(libs.plugins.gradle.publish)
}

group = "dev.sergiobelda.projectconfig.buildlogic"
version = libs.versions.sergiobeldaBuildLogic.get()

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.jetbrains.kotlin.gradlePlugin)
    implementation(libs.spotless.gradlePlugin)
}

gradlePlugin {
    plugins {
        val conventionPluginsPath = "dev.sergiobelda.projectconfig.buildlogic.convention"
        create("android-library") {
            id = libs.plugins.sergiobelda.convention.android.library.get().pluginId
            implementationClass = "$conventionPluginsPath.AndroidLibraryConventionPlugin"
        }
        create("spotless") {
            id = libs.plugins.sergiobelda.convention.spotless.get().pluginId
            implementationClass = "$conventionPluginsPath.SpotlessConventionPlugin"
        }
    }
}
