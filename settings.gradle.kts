rootProject.name = "project-config"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("./dependencies/dependencies/libs.versions.toml"))
        }
    }
}

include(":build-logic:convention")
include(":dependencies:dependencies")
