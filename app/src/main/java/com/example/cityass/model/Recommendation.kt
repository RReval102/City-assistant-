package com.example.cityassistant.data.model

import kotlinx.serialization.Serializable

// Модель данных для рекомендации (должна совпадать с моделью на бэкенде)
@Serializable
data class Recommendation(
    val title: String,
    val description: String,
    val type: String
)
