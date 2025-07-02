import axios from 'axios';

const API = axios.create({
  baseURL: 'http://localhost:3000/api' // Gateway base
});

export default API;
