package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*

fun main() {
    // Запуск встроенного сервера Netty на порту 8080
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

// Главный модуль приложения
fun Application.module() {
    // Настройка маршрутизации API
    configureRouting()
    // Настройка сериализации для JSON
    configureSerialization()
}
