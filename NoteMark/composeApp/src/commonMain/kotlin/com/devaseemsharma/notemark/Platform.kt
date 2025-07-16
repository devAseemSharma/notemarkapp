package com.devaseemsharma.notemark

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform