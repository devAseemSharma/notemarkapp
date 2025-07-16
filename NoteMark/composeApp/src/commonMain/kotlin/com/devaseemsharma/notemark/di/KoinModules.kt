package com.devaseemsharma.notemark.di

import com.devaseemsharma.notemark.ui.home.viewmodel.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            provideViewModelModule,
            provideDataSourceModule,
            provideRepositoryModule,
            provideNetworkModule,
        )
    }

val provideViewModelModule = module {
    viewModelOf(::HomeViewModel)
}

val provideDataSourceModule = module {
    //singleOf(::AudioLocalDatasourceImpl).bind(AudioLocalDatasource::class)
}

val provideRepositoryModule = module {
   // singleOf(::AudioRepositoryImpl).bind(AudioRepository::class)
}

val provideNetworkModule = module {
    single { createJson() }
    single { createHttpClient(get(), true) }
}

fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }

fun createHttpClient(json: Json, enableNetworkLogs: Boolean) = HttpClient {
    install(ContentNegotiation) {
        json(json)
    }
    if (enableNetworkLogs) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.NONE
        }
    }
}