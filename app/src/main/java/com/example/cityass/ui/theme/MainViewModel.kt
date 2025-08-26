package com.example.cityassistant.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cityassistant.data.model.Recommendation
import com.example.cityassistant.data.remote.ApiClient
import com.example.cityassistant.domain.ai.AssistantManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val assistantManager = AssistantManager()

    // StateFlow для хранения списка рекомендаций
    private val _recommendations = MutableStateFlow<List<Recommendation>>(emptyList())
    val recommendations: StateFlow<List<Recommendation>> = _recommendations

    // StateFlow для отслеживания состояния загрузки
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        // Загружаем рекомендации при инициализации ViewModel
        loadRecommendations()
    }

    private fun loadRecommendations() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // Получаем ID пользователя (в реальном приложении это будет реальный ID)
                val userId = assistantManager.getUserId()
                // Выполняем сетевой запрос
                val response = ApiClient.apiService.getRecommendations(userId)
                _recommendations.value = response
            } catch (e: Exception) {
                // Обработка ошибок (например, показать сообщение пользователю)
                e.printStackTrace()
                _recommendations.value = emptyList() // Очищаем список в случае ошибки
            } finally {
                _isLoading.value = false
            }
        }
    }
}
