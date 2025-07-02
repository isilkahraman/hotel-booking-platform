const express = require('express');
const { createProxyMiddleware } = require('http-proxy-middleware');
require('dotenv').config();

const app = express();

// Proxy routes
app.use('/api/admin', createProxyMiddleware({
    target: process.env.ADMIN_SERVICE_URL,
    changeOrigin: true,
    pathRewrite: { '^/api/admin': '' }
}));

app.use('/api/search', createProxyMiddleware({
    target: process.env.SEARCH_SERVICE_URL,
    changeOrigin: true,
    pathRewrite: { '^/api/search': '' }
}));

app.use('/api/book', createProxyMiddleware({
    target: process.env.BOOK_SERVICE_URL,
    changeOrigin: true,
    pathRewrite: { '^/api/book': '' }
}));

app.use('/api/comments', createProxyMiddleware({
    target: process.env.COMMENTS_SERVICE_URL,
    changeOrigin: true,
    pathRewrite: { '^/api/comments': '' }
}));

app.use('/api/admin', createProxyMiddleware({
  target: process.env.ADMIN_SERVICE_URL,
  changeOrigin: true,
  pathRewrite: { '^/api/admin': '' }
}));


app.listen(3000, () => {
    console.log('API Gateway running on http://localhost:3000');
});