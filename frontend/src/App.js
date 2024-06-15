import React from 'react';
import { Routes, Route } from 'react-router-dom';
import './App.css';
import GenerateText from './pages/GenerateText';
import Login from './pages/Login';
import Register from './pages/Register';
import CreateNote from './pages/CreateNote';
import EditNote from './pages/EditNote';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<GenerateText />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/create-note" component={CreateNote} />
        <Route path="/edit-note/:id" component={EditNote} />
      </Routes>
    </div>
  );
}

export default App;
