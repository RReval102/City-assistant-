# city_assistant_project/apps/news/views.py
# Представления (контроллеры) для обработки API-запросов.

from rest_framework import generics
from .models import Article
from .serializers import ArticleSerializer
from rest_framework.permissions import AllowAny

class NewsListView(generics.ListAPIView):
    """
    API эндпоинт для получения списка новостей.
    Доступен всем пользователям (даже неаутентифицированным).
    """
    queryset = Article.objects.all().order_by('-published_date')
    serializer_class = ArticleSerializer
    permission_classes = [AllowAny] # Разрешаем доступ без токена
