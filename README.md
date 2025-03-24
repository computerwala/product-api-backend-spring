

## Getting Started

### Prerequisites
Ensure you have the following installed:
- **Java 17** (or later)
- **Maven**

###  Clone the Repository

git clone <repository-url>
cd product-api

 Build the Project

mvn clean install

Run the Project

mvn spring-boot:run

Once the application starts, it will be available at:

http://localhost:8080



⸻
### API Endpoints

Method	Endpoint	Description
POST	/api/products/load	Load products from external API
GET	/api/products	Get all products
GET	/api/products/search	Search products
GET	/api/products/{id}	Get product by ID

Example API Call to Search Products

GET http://localhost:8080/api/products/search?query=laptop

Example Response:

[
  {
    "id": 1,
    "title": "Gaming Laptop",
    "description": "High-performance laptop",
    "price": 1500,
    "thumbnail": "https://example.com/laptop.jpg"
  }
]



⸻

### Technologies Used
	•	Spring Boot – Backend framework
	•	Spring Data JPA – Database access
	•	H2 Database – In-memory database for easy testing
	•	Maven – Build automation tool
	•	Lombok – Reduces boilerplate code



### How to Share or Deploy This Project

If you need to share this project, you can:
	1.	Push it to GitHub/GitLab and share the repository link.
	2.	Send a ZIP file of the project.
	3.	Provide the built JAR file for direct execution:

java -jar target/product-api.jar


