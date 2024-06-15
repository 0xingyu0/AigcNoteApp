import React, { useState } from 'react';
import { TextField, Button } from '@mui/material';
import { useNavigate } from 'react-router-dom';

function GenerateText() {
  const [prompt, setPrompt] = useState('');
  const [generatedText, setGeneratedText] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();
    // 处理生成文本逻辑
  };

  const handleLoginClick = () => {
      navigate('/login');
    };
  const handleSignUpClick = () => {
      navigate('/register');
    };

  return (
    <div>
      <h2>Welcome to AIGC NoteBook Web</h2>
      <h2>請先登入或註冊</h2>
      <Button variant="contained" color="secondary" onClick={handleLoginClick}>Login</Button>
      <Button variant="contained" color="secondary" onClick={handleSignUpClick}>Sign up</Button>
      <form onSubmit={handleSubmit}>
        <TextField
          label="Prompt"
          value={prompt}
          onChange={(e) => setPrompt(e.target.value)}
        />
        <Button type="submit" variant="contained" color="primary">Generate</Button>
      </form>
      <div>
        <h3>Generated Text</h3>
        <p>{generatedText}</p>
      </div>
      
    </div>
  );
}

export default GenerateText;
