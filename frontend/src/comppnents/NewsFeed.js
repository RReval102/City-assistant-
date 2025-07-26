// frontend/src/components/NewsFeed.js
// Компонент для отображения ленты новостей.

import React, { useState, useEffect } from 'react';
import { getNews } from '../services/api';
import './NewsFeed.css';

function NewsFeed() {
    const [articles, setArticles] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchNews = async () => {
            try {
                setLoading(true);
                const response = await getNews();
                setArticles(response.data);
                setError(null);
            } catch (err) {
                setError('Не удалось загрузить новости. Попробуйте позже.');
                console.error(err);
            } finally {
                setLoading(false);
            }
        };

        fetchNews();
    }, []);

    if (loading) {
        return <div className="loading">Загрузка новостей...</div>;
    }

    if (error) {
        return <div className="error">{error}</div>;
    }

    return (
        <div className="news-feed">
            <h2>Лента новостей</h2>
            <div className="articles-container">
                {articles.length > 0 ? (
                    articles.map(article => (
                        <div key={article.id} className="article-card">
                            <h3>{article.title}</h3>
                            <p>{article.content.substring(0, 150)}...</p>
                            <span className="article-category">{article.category}</span>
                        </div>
                    ))
                ) : (
                    <p>Новостей пока нет.</p>
                )}
            </div>
        </div>
    );
}

export default NewsFeed;
