package com.example.cityassistant.data.remote

import com.example.cityassistant.data.model.Recommendation
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

// Интерфейс для описания API-запросов
interface ApiService {
    @GET("recommendations")
    suspend fun getRecommendations(@Query("userId") userId: String): List<Recommendation>
}

// Объект для создания клиента Retrofit
object ApiClient {
    // ВАЖНО: Для эмулятора Android используйте 10.0.2.2 вместо localhost
    private const val BASE_URL = "http://10.0.2.2:8080/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
