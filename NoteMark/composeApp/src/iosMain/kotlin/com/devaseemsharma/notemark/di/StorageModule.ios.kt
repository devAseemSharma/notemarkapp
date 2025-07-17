package com.devaseemsharma.notemark.di

import com.devaseemsharma.notemark.data.model.NoteTable
import com.devaseemsharma.notemark.platform.storage.StorageManager
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual fun provideStorageModule() = module {
    single<KStore<NoteTable>> {
        val storageManager: StorageManager = get()
        val directory = storageManager.getStorageDir()

        storeOf(
            file = directory,
            default = NoteTable()
        )
    }
}

actual fun provideStorageManager() = module {
    singleOf(::StorageManager)
}