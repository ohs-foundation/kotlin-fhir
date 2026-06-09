pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    dependencyResolutionManagement {
        versionCatalogs {
            create("libs") {
                from(files("../gradle/libs.versions.toml"))
            }
        }
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}
