import React from 'react';
import { Routes, Route } from 'react-router-dom';
import './App.css';
import GenerateText from './pages/GenerateText';
import Login from './pages/Login';
import Register from './pages/Register';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<GenerateText />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
      </Routes>
    </div>
  );
}

export default App;
