# REST API Test Automation Framework

A professional REST API testing framework built with **Java**, **Rest-Assured**, and **JUnit 5**.  
This project demonstrates industry-standard practices for automating backend API testing, validating complex JSON structures, and implementing serialization/deserialization strategies.

---

## Project Architecture & Features

This framework follows a **Hybrid Testing Approach**, combining reusable configurations with flexible validation strategies.

### Core Capabilities

- ✅ **Full CRUD Operations** – Automated GET, POST, PUT requests with validation  
- ✅ **Dynamic JSON Construction** – Nested request bodies using `JSONObject` (e.g., booking dates)  
- ✅ **Query & Path Parameters** – Filtered requests using query parameters and dynamic endpoints  
- ✅ **Status & Header Validation** – HTTP status code and response header verification  
- ✅ **Response Body Validation** – Full body comparison and partial field validation  
- ✅ **Array & Size Assertions** – Validating list responses using Hamcrest matchers  

---

## Advanced API Testing Implementations

### 1️⃣ Serialization & Deserialization (POJO Usage)

Implemented response deserialization using custom POJO classes.

```java
PostPojo actualData = response.as(PostPojo.class);

assertEquals(expectedData.getTitle(), actualData.getTitle());
assertEquals(expectedData.getBody(), actualData.getBody());
assertEquals(expectedData.getUserId(), actualData.getUserId());
assertEquals(expectedData.getId(), actualData.getId());

2️⃣ Dynamic Request Body Creation (JSONObject)
Example PUT request body creation:

java
JSONObject requestBody = new JSONObject();
requestBody.put("title", "Ahmet");
requestBody.put("body", "Merhaba");
requestBody.put("userId", 10);
requestBody.put("id", 70);

3️⃣ Fluent API Assertions (Rest-Assured & Hamcrest)
java
response.then().assertThat()
        .statusCode(200)
        .body("booking.firstname", equalTo("Murat"))
        .body("booking.totalprice", equalTo(500));

4️⃣ JsonPath Data Extraction
java
JsonPath resJP = response.jsonPath();
assertEquals("Murat", resJP.getString("booking.firstname"));
assertEquals(500, resJP.getInt("booking.totalprice"));


## Technical Skills Demonstrated

### API Testing Expertise
- Deep understanding of HTTP methods and status codes  
- JSON navigation using GPath expressions  
- RESTful API principles  
- Nested object validation  
- Data type handling (String, Integer, Boolean)  

### Framework Development
- Reusable `RequestSpecification` configuration  
- Base URL abstraction  
- POJO-based deserialization  
- Clean test structure with JUnit 5  
- Strong assertion strategies  

### Development Tools
- Git version control  
- Maven dependency management  
- IntelliJ IDEA  
- Structured package organization  

---

## Real-World Test Scenarios

### Booking API Testing
- Booking creation with nested dates  
- Query parameter filtering (firstname & lastname)  
- Status code and response size validation  
- Data integrity verification  

### JSONPlaceholder API Testing
- GET request full body validation  
- PUT request body update verification  
- Expected vs Actual data comparison  
- Deserialization into POJO objects  

---



Author
Yaprak Ersan

Tech Stack:
Java | Rest-Assured | JUnit 5 | Maven | Git | JSON | REST APIs
