// frontend/src/App.js
// Главный компонент React-приложения.

import React from 'react';
import NewsFeed from './components/NewsFeed';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>City Assistant</h1>
      </header>
      <main>
        {/* Здесь будут другие компоненты: платежи, знакомства и т.д. */}
        <NewsFeed />
      </main>
      <footer className="App-footer">
        <p>© 2025 City Assistant Project</p>
      </footer>
    </div>
  );
}

export default App;
