# ml_service/app/models/news_classifier.py
# Заглушка для модели классификации новостей.

# В реальном проекте здесь будет код для загрузки и использования
# модели TensorFlow/Keras/PyTorch.
# Например:
# from tensorflow.keras.models import load_model
# model = load_model('path/to/your/news_model.h5')
# tokenizer = ... # Загрузка токенизатора

def classify_news_text(text: str) -> (str, float):
    """
    Заглушка функции классификации.
    Вместо реальной модели, она просто ищет ключевые слова.
    """
    text_lower = text.lower()
    if "футбол" in text_lower or "хоккей" in text_lower:
        return "Спорт", 0.95
    if "президент" in text_lower or "правительство" in text_lower:
        return "Политика", 0.89
    if "технологии" in text_lower or "apple" in text_lower:
        return "Технологии", 0.99
    
    return "Общее", 0.5

