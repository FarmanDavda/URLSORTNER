# 🔗 URL Shortener Service

A backend service built using **Spring Boot** that shortens long URLs into compact links, tracks the number of times a shortened URL is accessed, and redirects users to the original URL.

---

## 🚀 Features

- Generate short, unique URLs using Base62 encoding
- Redirect to the original URL using short links
- Track click count for each shortened URL
- Built-in API documentation using Swagger UI
- In-memory H2 Database for testing
- Lightweight and easy to deploy

---

## 🛠️ Tech Stack

| Technology       | Description                    |
|------------------|-------------------------------|
| Java             | Java 17                        |
| Spring Boot      | Backend framework              |
| Spring Data JPA  | ORM for database interaction   |
| H2 Database      | In-memory database             |
| Swagger UI       | API documentation              |
| Postman          | API testing                    |
| Maven            | Build tool                     |

---

## 📁 Project Structure

```
src/
├── controller/       # Handles API requests
├── model/            # Entity and DTOs
├── repository/       # JPA repositories
├── service/          # Business logic
├── config/           # Swagger configuration
└── UrlShortenerApplication.java
```

---

## 📦 API Endpoints

| Method | Endpoint                     | Description                      |
|--------|------------------------------|----------------------------------|
| POST   | `/api/shorten`               | Shorten a long URL               |
| GET    | `/r/{shortCode}`             | Redirect to original URL         |
| GET    | `/api/stats/{shortCode}`     | Get click count and analytics    |

---

## 🧪 Testing the APIs

### Swagger UI  
Visit: `http://localhost:8080/swagger-ui/index.html`

### H2 Console  
Visit: `http://localhost:8080/h2-console`  
JDBC URL: `jdbc:h2:mem:testdb`

---

## 🧰 How to Run

1. **Clone the repo:**
   ```bash
   git clone https://github.com/FarmanDavda/URLSORTNER.git
   cd URLSORTNER
   ```

2. **Build and Run the project:**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Access API documentation:**
   - Swagger: `http://localhost:8080/swagger-ui/index.html`
   - H2 Console: `http://localhost:8080/h2-console`

---

## 📊 Example Request

### Shorten a URL
```http
POST /api/shorten
Content-Type: application/json

{
  "originalUrl": "https://www.example.com/long-link"
}
```

### Response
```json
{
  "shortUrl": "http://localhost:8080/r/abc123"
}
```

---

## 🧠 Future Enhancements

- Add user accounts and login
- Custom short codes
- Expiry time for URLs
- MySQL/PostgreSQL database integration
- URL analytics dashboard

---

## 👨‍💻 Author

**Farman Davda**  
🔗 [GitHub](https://github.com/FarmanDavda)

---

## 📃 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
