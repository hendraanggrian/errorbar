plugins {
    android("library")
    kotlin("android")
}

android {
    compileSdk = SDK_TARGET
    defaultConfig {
        minSdk = SDK_MIN
        targetSdk = SDK_TARGET
        multiDexEnabled = true
    }
    sourceSets {
        named("main") {
            manifest.srcFile("AndroidManifest.xml")
            java.srcDir("src")
            res.srcDir("res")
            resources.srcDir("src")
        }
    }
    libraryVariants.all {
        generateBuildConfigProvider.orNull?.enabled = false
    }
}

dependencies {
    api(kotlin("stdlib"))
    api(kotlin("test-junit", VERSION_KOTLIN))
    api(material())
    api(androidx("multidex", version = VERSION_MULTIDEX))
    api(androidx("core", "core-ktx"))
    api(androidx("appcompat"))
    api(androidx("coordinatorlayout", version = "1.1.0"))
    api(androidx("test", "core-ktx", VERSION_ANDROIDX_TEST))
    api(androidx("test", "runner", VERSION_ANDROIDX_TEST))
    api(androidx("test", "rules", VERSION_ANDROIDX_TEST))
    api(androidx("test.ext", "junit-ktx", VERSION_ANDROIDX_JUNIT))
    api(androidx("test.ext", "truth", VERSION_ANDROIDX_TRUTH))
    api(androidx("test.espresso", "espresso-core", VERSION_ESPRESSO))
}
