package com.devaseemsharma.notemark.platform.storage

import com.devaseemsharma.notemark.usecase.MainActivityUseCase
import com.devaseemsharma.notemark.utils.NotesConstants
import kotlinx.io.files.Path

actual class StorageManager(private val mainActivityUseCase: MainActivityUseCase) {
    actual fun getStorageDir(): Path {
        return Path("${mainActivityUseCase.requireActivity().filesDir.path}${NotesConstants.STORAGE_FILE_NAME}")
    }
}