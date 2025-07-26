# ml_service/app/main.py
# Основной файл микросервиса на FastAPI для обработки ML-запросов.

from fastapi import FastAPI
from pydantic import BaseModel
from typing import List

# Импортируем наши "модели"
# В реальном проекте здесь будет загрузка обученных файлов (.h5, .pth, .pkl)
from .models.news_classifier import classify_news_text
from .models.recommendation_engine import get_dating_recommendations

app = FastAPI(
    title="City Assistant ML Service",
    description="Микросервис для выполнения задач машинного обучения.",
    version="1.0.0"
)

# --- Модели данных для запросов и ответов ---

class NewsArticle(BaseModel):
    text: str

class NewsCategory(BaseModel):
    category: str
    confidence: float

class DatingProfile(BaseModel):
    user_id: int
    interests: List[str]
    age: int

class Recommendations(BaseModel):
    recommended_user_ids: List[int]


# --- Эндпоинты API ---

@app.get("/")
def read_root():
    """Корневой эндпоинт для проверки работоспособности сервиса."""
    return {"status": "ok", "message": "ML Service is running"}

@app.post("/news/classify", response_model=NewsCategory)
def classify_news(article: NewsArticle):
    """
    Классифицирует текст новости.
    Принимает текст и возвращает предсказанную категорию.
    """
    category, confidence = classify_news_text(article.text)
    return {"category": category, "confidence": confidence}

@app.post("/dating/recommend", response_model=Recommendations)
def recommend_profiles(profile: DatingProfile):
    """
    Возвращает рекомендации анкет для знакомств.
    Принимает профиль пользователя и выдает список ID рекомендованных пользователей.
    """
    user_ids = get_dating_recommendations(profile)
    return {"recommended_user_ids": user_ids}

# В реальном приложении здесь также будет логика для загрузки моделей при старте
# @app.on_event("startup")
# async def load_models():
#     ...
