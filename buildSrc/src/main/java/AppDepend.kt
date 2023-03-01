import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDepend {
    //region android ui
    private val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    private val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    private val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    private val material = "com.google.android.material:material:${Version.material}"
    private val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    //endregion

    //region Lifecycle
    private val fragmentKtx = "androidx.fragment:fragment-ktx:${Version.fragmentKtx}"
    private val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Version.viewModel}"
    private val liveData = "androidx.lifecycle:lifecycle-livedata:${Version.liveData}"
    //endregion

    //region fastAdapter
    private val fastAdapterBinding =
        "com.mikepenz:fastadapter-extensions-binding:${Version.fastAdapterBinding}"
    private val fastAdapterExtensions =
        "com.mikepenz:fastadapter-extensions-diff:${Version.fastadapterExtensions}"
    private val fastAdapter = "com.mikepenz:fastadapter:${Version.fastAdapter}"
    private val recyclerview = "androidx.recyclerview:recyclerview:${Version.recyclerview}"
    //endregion

    //region Dagger
    private val dagger = "com.google.dagger:dagger:${Version.dagger}"
    private val daggerKapt = "com.google.dagger:dagger-compiler:${Version.daggerKapt}"
    //endregion

    //region Turbine
    private val turbine = "app.cash.turbine:turbine:${Version.turbine}"
    //endregion

    //region Retrofit
    private val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    private val retrofitConverter =
        "com.squareup.retrofit2:converter-gson:${Version.retrofitConverter}"
    private val retrofitAdapter =
        "com.squareup.retrofit2:adapter-rxjava2:${Version.retrofitAdapter}"
    private val okhttp = "com.squareup.okhttp3:okhttp:${Version.okhttp}"
    private val interceptor = "com.squareup.okhttp3:logging-interceptor:${Version.interceptor}"
    //endregion

    //region Navigation
    private val navigation = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    private val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navigationUi}"
    //endregion

    //region Location
    private val location = "com.google.android.gms:play-services-location:${Version.location}"
    //endregion

    //region Coroutines
    private const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Version.coroutines}"
    //region

    //region Tests
    private val androidTestJunit = "androidx.test.ext:junit:${Version.androidTestJunit}"
    private val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
    private val junitCompose = "androidx.compose.ui:ui-test-junit4:${Version.composeUiVersion}"


    private val uiTooling = "androidx.compose.ui:ui-tooling:${Version.composeUiVersion}"
    private val testManifest = "androidx.compose.ui:ui-test-manifest:${Version.composeUiVersion}"

    private val junit = "junit:junit:${Version.junit}"
    private val mockito = "org.mockito:mockito-core:${Version.mockito}"
    private val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Version.mockitoKotlin}"
    private val mockitoInline = "org.mockito:mockito-inline:${Version.mockitoInline}"
    private val junitJupiter = "org.junit.jupiter:junit-jupiter:${Version.junitJupiter}"
    private val coreTest = "androidx.arch.core:core-testing:${Version.coreTest}"
    private val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutinesTest}"
    //endregion

    //region Compose
    val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleRuntimeKtx}"
    val activityCompose = "androidx.activity:activity-compose:${Version.activityCompose}"
    val composeUi = "androidx.compose.ui:ui:${Version.composeUiVersion}"
    val composeTooling = "androidx.compose.ui:ui-tooling-preview:${Version.composeUiVersion}"
    val materialCompose = "androidx.compose.material:material:${Version.materialCompose}"
    //endregion

    //region appLibraries list
    val appLibraries = listOf(
        kotlinStdLib,
        coreKtx,
        appcompat,
        material,
        constraintLayout,
        fragmentKtx,
        viewModel,
        liveData,
        fastAdapterBinding,
        daggerKapt,
        fastAdapterExtensions,
        fastAdapter,
        recyclerview,
        dagger,
        retrofit,
        retrofitConverter,
        retrofitAdapter,
        okhttp,
        interceptor,
        navigation,
        navigationUi,
        location,
        coroutines,
        lifecycleRuntimeKtx,
        activityCompose,
        composeUi,
        composeTooling,
        materialCompose
    )
    //endregion

    //region kapt list
    val kapt = listOf(
        daggerKapt
    )
    //endregion

    //region androidTestLibraries list
    val androidTestLibraries = listOf(
        androidTestJunit,
        espresso,
        junitCompose
    )
    //endregion

    //region testLibraries list
    val testLibraries = listOf(
        junit,
        mockito,
        mockitoKotlin,
        mockitoInline,
        junitJupiter,
        coroutinesTest,
        coreTest,
        turbine
    )
    //endregion

    val debugImplementationLibraries = listOf(
        uiTooling,
        testManifest
    )
}

//region functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}
//endregion