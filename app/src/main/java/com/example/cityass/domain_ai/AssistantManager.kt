package com.example.cityassistant.domain.ai

// Класс для управления логикой ИИ-ассистента
class AssistantManager {

    /**
     * Получает уникальный идентификатор пользователя.
     * В реальном приложении это будет ID из системы аутентификации.
     */
    fun getUserId(): String {
        // Для примера возвращаем статичный ID
        return "user-123"
    }

    /**
     * Анализирует запрос пользователя и возвращает тип интереса.
     * Это упрощенная модель, которая может быть заменена на нейросеть.
     */
    fun analyzeQuery(query: String): String {
        val lowerCaseQuery = query.lowercase()
        return when {
            "музей" in lowerCaseQuery || "выставка" in lowerCaseQuery -> "culture"
            "концерт" in lowerCaseQuery || "фестиваль" in lowerCaseQuery -> "event"
            "ресторан" in lowerCaseQuery || "кафе" in lowerCaseQuery -> "food"
            "спорт" in lowerCaseQuery || "парк" in lowerCaseQuery -> "sport"
            else -> "unknown"
        }
    }
}
