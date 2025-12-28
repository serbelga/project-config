plugins {
    id("version-catalog")
    alias(libs.plugins.vanniktech.mavenpublish)
}

group = "dev.sergiobelda.projectconfig.dependencies"
version = libs.versions.sergiobeldaDependencies.get()

catalog {
    versionCatalog {
        from(files("./libs.versions.toml"))
    }
}

mavenPublishing {
    publishToMavenCentral(true)

    signAllPublications()
}
