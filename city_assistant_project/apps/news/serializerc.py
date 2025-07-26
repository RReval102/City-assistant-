# city_assistant_project/apps/news/serializers.py
# Сериализаторы для преобразования моделей Django в JSON.

from rest_framework import serializers
from .models import Article

class ArticleSerializer(serializers.ModelSerializer):
    """
    Сериализатор для модели Article.
    """
    class Meta:
        model = Article
        fields = ['id', 'title', 'content', 'published_date', 'category']
