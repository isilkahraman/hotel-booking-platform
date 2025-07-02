hotel-booking-platform
Hotel Booking System - Final Project
This is a hotel booking application designed as a distributed system using microservices. The project is developed for the SE4458 Software Engineering course final assignment.

Project Overview
The system allows users to:

Search hotels by location, date and number of people
View available rooms and their prices
Book a room
Write comments and ratings for hotels
Get recommendations from an AI chat agent
It also includes an admin interface (API) to add hotels and rooms.

Technologies Used
Backend:

Java + Spring Boot (for all services)
PostgreSQL (for admin, search and booking services)
MongoDB (for comments)
Redis (for caching in search)
RabbitMQ (for booking notifications)
Node.js + Express (for API Gateway and AI agent)
Frontend:

React (Vite)
Axios for HTTP requests
Chart.js for data visualization
Microservices
Service Name	Port	Description
hotel-admin-service	8081	Admin login and hotel management
hotel-search-service	8082	Hotel search with Redis cache
book-hotel-service	8083	Room booking and RabbitMQ message
comments-service	8084	Posting and charting hotel comments
notification-service	8085	Low capacity room alerts + consumer
api-gateway (Node.js)	3000	Routes all frontend API calls
ai-agent (Node.js)	5000	AI agent that calls the search API
hotel-booking-ui	5173	React-based frontend application
Installation & Running the System
Prerequisites
Java 17
Node.js 18+
PostgreSQL
MongoDB
Redis
RabbitMQ
Docker (optional)
1. Database Setup
Create PostgreSQL databases:

hotel_admin_db hotel_search_db book_hotel_db

Start MongoDB, Redis, and RabbitMQ locally or in Docker.

2. Start Backend Services
Build and run each Spring Boot project:

mvn clean install
mvn spring-boot:run

Start the Node.js gateway and AI agent:

cd api-gateway
npm install
node app.js

cd ai-agent
npm install
node ai-agent.js

3. Start Frontend

cd hotel-booking-ui
npm install
npm run dev

Notes:

Authentication is disabled during testing

Booking and commenting do not require login

You can test all services with Postman or the frontend UI


This project was developed by Işıl Kahraman.
