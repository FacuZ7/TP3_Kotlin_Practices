package com.example.retrofit.model

data class PaginateResponse<T>(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<T>
)
