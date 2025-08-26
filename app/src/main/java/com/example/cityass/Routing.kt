package com.example.plugins

import com.example.services.RecommendationService
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    val recommendationService = RecommendationService()

    routing {
        // Основной маршрут для получения рекомендаций
        get("/recommendations") {
            // Получаем ID пользователя из параметров запроса
            val userId = call.request.queryParameters["userId"] ?: "defaultUser"
            // Генерируем рекомендации
            val recommendations = recommendationService.getRecommendations(userId)
            // Отправляем ответ в формате JSON
            call.respond(recommendations)
        }
    }
}
