plugins {
    id("version-catalog")
    alias(deps.plugins.vanniktech.mavenpublish)
}

group = "dev.sergiobelda.projectconfig.catalog"

catalog {
    versionCatalog {
        from(files("./deps.versions.toml"))
    }
}

mavenPublishing {
    publishToMavenCentral(true)

    signAllPublications()
}
