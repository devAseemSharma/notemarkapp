package com.devaseemsharma.notemark

import androidx.compose.ui.window.ComposeUIViewController
import com.devaseemsharma.notemark.di.initKoin

fun MainViewController() = ComposeUIViewController(content = { App() }, configure = {
    initKoin()
})