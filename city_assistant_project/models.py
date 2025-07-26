# city_assistant_projectappsusersmodels.py
# Модель данных для пользователя.

from django.contrib.auth.models import AbstractUser
from django.db import models

class User(AbstractUser)
    
    Расширенная модель пользователя.
    Добавляем дополнительные поля, например, фото профиля и баланс.
    
    email = models.EmailField(unique=True, verbose_name='Электронная почта')
    profile_picture = models.ImageField(upload_to='profile_pics', null=True, blank=True, verbose_name='Фото профиля')
    balance = models.DecimalField(max_digits=10, decimal_places=2, default=0.00, verbose_name='Баланс')

    USERNAME_FIELD = 'email'
    REQUIRED_FIELDS = ['username']

    def __str__(self)
        return self.email

class Profile(models.Model)
    
    Профиль пользователя для приложения знакомств.
    
    user = models.OneToOneField(User, on_delete=models.CASCADE, related_name='dating_profile')
    bio = models.TextField(max_length=500, blank=True, verbose_name='О себе')
    birth_date = models.DateField(null=True, blank=True, verbose_name='Дата рождения')
    # Другие поля для анкеты знакомств...

    def __str__(self)
        return fПрофиль {self.user.username}
