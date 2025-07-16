package com.devaseemsharma.notemark.platform.storage

import com.devaseemsharma.notemark.utils.NotesConstants
import kotlinx.io.files.Path

actual class StorageManager {
    actual fun getStorageDir(): Path = Path(NotesConstants.STORAGE_FILE_NAME)
}