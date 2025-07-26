# city_assistant_project/city_assistant_project/urls.py
# Этот файл определяет главные URL-маршруты проекта.

from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),

    # API v1
    path('api/v1/users/', include('apps.users.urls')),
    path('api/v1/payments/', include('apps.payments.urls')),
    path('api/v1/dating/', include('apps.dating.urls')),
    path('api/v1/news/', include('apps.news.urls')),
]
