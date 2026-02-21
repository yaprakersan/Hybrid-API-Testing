# 🚀 REST API Test Automation Framework

A professional **REST API testing framework** built with **Java**, **Rest-Assured**, and **JUnit 5**. This project demonstrates industry-standard practices for automating backend endpoints, validating data integrity, and handling complex JSON structures.

---

## 🏗️ Project Architecture & Features

This framework adopts a **Hybrid Approach**, ensuring tests are both readable and highly reusable. Key features include:

* **Full CRUD Operations:** Automated execution and validation of `GET`, `POST`, and `PUT` HTTP methods.
* **Dynamic Payload Construction:** Utilizing `JSONObject` to dynamically build nested and complex JSON request bodies (e.g., handling `bookingdates`).
* **Header & Status Validation:** Strict verification of HTTP Status Codes (200 OK, 201 Created) and Response Headers.
* **Advanced Logging:** Integrated `prettyPrint()` for effective debugging and response visualization.

---

## 🧪 Advanced Validation Strategies

The framework implements two distinct assertion methodologies to ensure maximum reliability:

### 1. Fluent API Assertions (Rest-Assured & Hamcrest)
Streamlined, chainable validations directly within the response pipeline.
```java
response.then().assertThat()
        .statusCode(200)
        .body("booking.firstname", equalTo("Ahmet"));
2. Data Extraction via JsonPath (Hard Assertions)
Extracting specific values into Java variables for precise comparison using JUnit 5.

Java
JsonPath resJP = response.jsonPath();
assertEquals(500, resJP.getInt("booking.totalprice"));

🔑 Key Skills & Technical Expertise
HTTP Protocol Mastery: Deep understanding of methods, status codes, and headers.

JSON Navigation: Deep object navigation using GPath (e.g., booking.bookingdates.checkin).

Data Types: Handling and converting JSON values to Java types (String, Integer, Boolean).

Version Control: Managed with Git, utilizing pull --rebase and push workflows.

⚙️ How to Run
Clone the repository: git clone https://github.com/yaprakersan/Hybrid-API-Testing.git

Navigate to the project directory: cd Hybrid-API-Testing

Execute tests via IntelliJ IDEA or Maven.

Author: Yaprak Ersan
