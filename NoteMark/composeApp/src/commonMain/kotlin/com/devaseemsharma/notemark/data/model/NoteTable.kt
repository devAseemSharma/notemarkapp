package com.devaseemsharma.notemark.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NoteTable(
    val listNotes: List<NoteData> = emptyList(),
    ) {
    @Serializable
    data class NoteData(
        val title: String = "",
        val subtitle: String = "",
        val note: String = "",
        val createdAt: Long = 0L
    )
}