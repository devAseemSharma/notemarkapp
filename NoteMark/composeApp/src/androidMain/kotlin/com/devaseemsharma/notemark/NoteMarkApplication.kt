package com.devaseemsharma.notemark

import android.app.Application
import com.devaseemsharma.notemark.di.initKoin

class NoteMarkApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin(this)
    }
}