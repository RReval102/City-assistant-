# city_assistant_project/apps/news/urls.py
# URL-маршруты для приложения "Новости".

from django.urls import path
from .views import NewsListView

urlpatterns = [
    path('', NewsListView.as_view(), name='news-list'),
]
