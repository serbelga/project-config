plugins {
    `kotlin-dsl`
    alias(libs.plugins.vanniktech.mavenpublish)
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
    website.set("https://github.com/serbelga/project-config")
    vcsUrl.set("https://github.com/serbelga/project-config")
    plugins {
        val conventionPluginsPath = "dev.sergiobelda.projectconfig.buildlogic.convention"
        create("android-library") {
            id = libs.plugins.sergiobelda.convention.android.library.get().pluginId
            implementationClass = "$conventionPluginsPath.android.AndroidLibraryConventionPlugin"
            displayName = "android-library"
            description = "Convention plugin for android library modules"
            tags = listOf("convention", "android-library")
        }
        create("spotless") {
            id = libs.plugins.sergiobelda.convention.spotless.get().pluginId
            implementationClass = "$conventionPluginsPath.spotless.SpotlessConventionPlugin"
            displayName = "spotless"
            description = "Convention plugin that applies a custom spotless configuration"
            tags = listOf("convention", "spotless")
        }
    }
}

mavenPublishing {
    publishToMavenCentral(true)

    signAllPublications()
}
