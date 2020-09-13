package com.marand.databinding.model

data class Photo(
    val id: Int,
    val albumId: Int,
    val url: String,
    val thumbnailUrl: String,
    val title: String
)