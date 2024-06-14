import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api', // 根据你的后端地址进行配置
});

export default api;
