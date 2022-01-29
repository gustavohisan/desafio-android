object Versions {
    const val compileSdk = 31
    const val targetSdk = 31
    const val minSdk = 26

    const val gradle = "7.0.2"
    const val kotlin = "1.5.31"
    const val coroutines = "1.5.2"
    const val detekt = "1.14.0"
    const val ktlint = "0.41.0"
    const val koin = "3.1.5"
    const val retrofit = "2.9.0"
    const val gson = "2.8.6"

    const val timber = "4.7.1"

    const val ktx = "1.3.2"
    const val appcompat = "1.2.0"

    const val compose = "1.1.0-beta01"
    const val composeActivity = "1.4.0"
    const val composeViewModel = "2.4.0"
    const val accompanist = "0.24.1-alpha"
    const val coil = "1.4.0"

    const val room = "2.4.1"

    const val junit_engine = "5.8.1"
    const val junit_runner = "1.8.1"
}

object Deps {
    val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val detekt = "io.gitlab.arturbosch.detekt:detekt-cli:${Versions.detekt}"
    val ktlint = "com.pinterest:ktlint:${Versions.ktlint}"
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = RetrofitDeps
    val jetpack = JetpackDeps
    val koin = KoinDeps
    val compose = ComposeDeps
    val room = RoomDeps
    val test = TestDeps
}

object JetpackDeps {
    val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
}

object RetrofitDeps {
    val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}

object KoinDeps {
    val core = "io.insert-koin:koin-core:${Versions.koin}"
    val android = "io.insert-koin:koin-android:${Versions.koin}"
    val compose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
}

object ComposeDeps {
    val core = "androidx.compose.ui:ui:${Versions.compose}"
    val compiler = "androidx.compose:compose-compiler:${Versions.compose}"
    val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    val material = "androidx.compose.material:material:${Versions.compose}"
    val materialIconsCore = "androidx.compose.material:material-icons-core:${Versions.compose}"
    val materialIconsExtended =
        "androidx.compose.material:material-icons-extended:${Versions.compose}"
    val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
    val liveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    val test = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    val placeholder = "com.google.accompanist:accompanist-placeholder:${Versions.accompanist}"
    val pager = "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
    val pagerIndicator = "com.google.accompanist:accompanist-pager-indicators:${Versions.accompanist}"
    val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
    val flowLayouts = "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist}"
    val coil = "io.coil-kt:coil-compose:${Versions.coil}"
}

object RoomDeps {
    val runtime = "androidx.room:room-runtime:${Versions.room}"
    val compiler = "androidx.room:room-compiler:${Versions.room}"
    val ktx = "androidx.room:room-ktx:${Versions.room}"
}

object TestDeps {
    val junit5_engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit_engine}"
    val junit5_runner = "org.junit.platform:junit-platform-runner:${Versions.junit_runner}"
    val coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}
