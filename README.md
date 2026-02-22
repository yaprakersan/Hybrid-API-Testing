REST API Test Automation Framework
A professional REST API testing framework built with Java, Rest-Assured, and JUnit 5. This project demonstrates industry-standard practices for automating backend API testing and validating complex JSON structures.

Project Architecture & Features
This framework uses a Hybrid Testing Approach combining maintainable code structure with comprehensive test coverage:

Core Capabilities
Full CRUD Operations: Automated GET, POST, PUT operations with validation
Dynamic JSON Construction: Complex nested request bodies using JSONObject (booking dates, user data)
Query & Path Parameters: Advanced parameter handling for filtered requests
Status & Header Validation: HTTP status codes (200, 201) and response header verification
Response Analysis: Array size validation and data integrity checks
Technical Implementation
Specification Objects: Reusable RequestSpecification for consistent base configuration
Content-Type Management: Proper JSON handling for POST/PUT operations
Debug Logging: Integrated prettyPrint() for response analysis
Error Handling: Robust exception management for network and data issues
Validation Strategy
1. Fluent API Assertions (Rest-Assured & Hamcrest)
Direct response pipeline validation:

java
response.then().assertThat()
    .statusCode(200)
    .body("booking.firstname", equalTo("Murat"))
    .body("booking.totalprice", equalTo(500));
2. JsonPath Data Extraction
Variable-based assertions for complex validation:

java
JsonPath resJP = response.jsonPath();
assertEquals("Murat", resJP.getString("booking.firstname"));
assertEquals(500, resJP.getInt("booking.totalprice"));
Technical Skills Demonstrated
API Testing Expertise

HTTP protocol mastery (methods, status codes, headers)
JSON navigation using GPath expressions
RESTful API design principles
Data type handling and conversion
Framework Development

Test architecture design and implementation
Reusable component creation
Multiple assertion strategies
Comprehensive error handling
Development Tools

Git version control with advanced workflows
Maven dependency management
IntelliJ IDEA integration
Real-World Test Scenarios
Booking System Validation

User registration with complete data validation
Search functionality using query parameters
Date range and pricing verification
Edge case and error response testing
External API Integration

Third-party service validation (JSONPlaceholder)
Data integrity across different endpoints
Getting Started
Prerequisites


bash
git clone https://github.com/yaprakersan/Hybrid-API-Testing.git
cd Hybrid-API-Testing
mvn clean install
mvn test

Author: Yaprak Ersan
Tech Stack: Java | Rest-Assured | JUnit 5 | Maven | Git | JSON | REST APIs
