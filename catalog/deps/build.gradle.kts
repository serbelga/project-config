plugins {
    id("version-catalog")
    alias(deps.plugins.vanniktech.mavenpublish)
}

group = "dev.sergiobelda.projectconfig.catalog"
version = deps.versions.sergiobelda.projectconfig

catalog {
    versionCatalog {
        from(files("./deps.versions.toml"))
    }
}

mavenPublishing {
    publishToMavenCentral(true)

    signAllPublications()
}
