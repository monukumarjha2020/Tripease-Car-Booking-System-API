# 🚗 Tripease – Car Booking System API

Welcome to **Tripease** – a Spring Boot–based backend system for managing car bookings, powered by MySQL, Docker, and deployed using CI/CD on AWS EC2 🚀

---

## 🧰 Tech Stack

- ⚙️ **Spring Boot 3** – RESTful API development  
- 🐬 **MySQL** – Relational database  
- 🐳 **Docker & Docker Compose** – Containerization  
- 🔁 **GitHub Actions** – CI/CD pipeline  
- ☁️ **AWS EC2** – Cloud hosting  
- 📄 **Swagger UI** – API documentation

---

## 📦 Features

- ✅ Book and manage car rentals
- 🔐 Secure API architecture (DTOs, validation)
- 📜 Swagger UI for testing and docs
- 🐳 Containerized app for easy deployment
- 🔁 CI/CD pipeline using GitHub Actions
- ☁️ Hosted on AWS EC2

---

## 📁 Project Structure

```bash
car-booking-api/
├── src/
├── target/
├── Dockerfile
├── docker-compose.yml
├── .github/workflows/
│   └── ci-cd.yml
├── README.md
└── pom.xml
```

---

## 🚀 How to Run Locally (Without Docker)

1. ✅ **Clone the repo**

```bash
git clone https://github.com/your-username/tripease.git
cd tripease
```

2. ⚙️ **Configure `application.properties`**

```properties
# src/main/resources/application.properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/car_booking_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
springdoc.swagger-ui.path=/swagger-ui.html
```

3. 🧪 **Build and Run**

```bash
mvn clean package
java -jar target/*.jar
```

---

## 🐳 Run with Docker

1. 📦 **Build Docker Image**

```bash
docker build -t car-booking-api .
```

2. ▶️ **Run Container**

```bash
docker run -p 8081:8081 car-booking-api
```

3. 🌍 **Visit Swagger UI**

```text
http://localhost:8081/swagger-ui.html
```

---

## 🧱 Docker Compose (Multi-Container Setup)

1. 📂 Ensure this `docker-compose.yml` exists:

```yaml
version: '3.8'
services:
  app:
    build: .
    ports:
      - "8081:8081"
    depends_on:
      - db
  db:
    image: mysql:8
    environment:
      MYSQL_ROOT_PASSWORD: 8877
      MYSQL_DATABASE: car_booking_db
    ports:
      - "3306:3306"
```

2. ▶️ **Run Compose**

```bash
docker-compose up --build
```

---

## 🔄 CI/CD with GitHub Actions

🚀 Every push to `main` triggers:

- Maven build (`mvn clean package`)
- Docker image build
- SSH deployment to AWS EC2

✅ Sample workflow file:

```yaml
# .github/workflows/ci-cd.yml
name: CI/CD Pipeline

on:
  push:
    branches: [ "main" ]

jobs:
  deploy:
    ...
```

---

## ☁️ AWS EC2 Deployment

🪄 Steps performed:

1. Setup EC2 Ubuntu instance with Docker & Java
2. Pushed image to instance via GitHub Actions
3. Started Docker container on EC2

🔗 Access: `http://<your-ec2-ip>:8081/swagger-ui.html`

---

## 🙌 Author

👨‍💻 **Monu Kumar**

Feel free to connect on [LinkedIn](https://www.linkedin.com/) or contribute via pull requests 💡

---

## 🌟 Star this repo if you found it useful!
