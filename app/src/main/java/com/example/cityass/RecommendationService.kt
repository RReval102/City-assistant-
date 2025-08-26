package com.example.cityassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cityassistant.data.model.Recommendation
import com.example.cityassistant.ui.theme.CityAssistantTheme
import com.example.cityassistant.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CityAssistantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AssistantScreen()
                }
            }
        }
    }
}

@Composable
fun AssistantScreen(mainViewModel: MainViewModel = viewModel()) {
    // Получаем состояние из ViewModel
    val recommendations by mainViewModel.recommendations.collectAsState()
    val isLoading by mainViewModel.isLoading.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("City Assistant") })
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text(
                "Здравствуйте! Вот ваши персональные рекомендации:",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(16.dp))

            if (isLoading) {
                CircularProgressIndicator()
            } else {
                RecommendationList(recommendations)
            }
        }
    }
}

@Composable
fun RecommendationList(recommendations: List<Recommendation>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(recommendations) { recommendation ->
            RecommendationCard(recommendation)
        }
    }
}

@Composable
fun RecommendationCard(recommendation: Recommendation) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(recommendation.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(recommendation.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
