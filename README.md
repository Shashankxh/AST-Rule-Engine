rule-engine-ast/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── ruleengine/
│   │   │               ├── RuleEngineApplication.java
│   │   │               ├── controller/
│   │   │               │   └── RuleController.java
│   │   │               ├── model/
│   │   │               │   └── Node.java
│   │   │               ├── service/
│   │   │               │   └── RuleService.java
│   │   │               └── util/
│   │   │                   └── RuleParser.java
├── pom.xml


## Project Description

This project is a rule engine built using **AST (Abstract Syntax Tree)** to evaluate logical expressions. The system supports:
- Simple rule creation (leaf nodes with operands).
- Combining multiple rules with logical operators (`AND`, `OR`, `NOT`).
- Evaluating rules based on given inputs.

### Key Concepts:
1. **AST Representation**: The rules are represented as a tree structure where:
   - Operators (`AND`, `OR`, `NOT`) are internal nodes.
   - Operands (conditions) are leaf nodes.

2. **Evaluation**: The engine can traverse and evaluate the AST to determine the result of the logical expression based on inputs.

## Features
- Create complex rules using logical operators.
- Combine multiple rules and evaluate them.
- RESTful API to interact with the rule engine.
- Easily extendable to add more operators or rules.

## Requirements

Before running the project, ensure you have the following installed:
- **Java 17** or higher
- **Maven** (for managing dependencies)
- **Postman** (for API testing)

## Dependencies

The project relies on the following dependencies:

- **Spring Boot**: 3.x.x
  - `spring-boot-starter-web`: For building RESTful services.
  - `spring-boot-starter-test`: For testing the application.
- **Jackson**: For JSON serialization and deserialization.
- **Lombok**: To reduce boilerplate code.

You can find the full list of dependencies in the `pom.xml` file.

## API Endpoints

This section outlines how to use the API endpoints exposed by the Rule Engine with AST. You can interact with these endpoints via **Postman** or any other API testing tool.
### Combine Rules
Endpoint: /api/rules/combine
Method: POST
Description: Combines two rules using a logical operator (AND, OR).
Request Body: JSON object containing two rules and the operator used to combine them.
Content-Type: application/json
Json request 
{
  "rule1": {
    "type": "operand",
    "value": "age > 18"
  },
  "rule2": {
    "type": "operand",
    "value": "income > 50000"
  },
  "operator": "AND"
}




### . Evaluate Rule Endpoint

- **Endpoint**: `/api/rules/evaluate`
- **Method**: `POST`
- **Description**: Evaluates a rule represented in AST format.
- **Content-Type**: `application/json`

#### JSON Input Example:

In the request body, you need to send a JSON object that represents the AST of the rule. Below is a basic example:

```json
{
  "type": "AND",
  "left": {
    "type": "operand",
    "value": "age > 18"
  },
  "right": {
    "type": "operand",
    "value": "income > 50000"
  }
}


### Key Sections in the README:

- **Project Description**: Briefly describes the rule engine and how it works using AST.
- **Features**: Key features of the rule engine, such as combining and evaluating rules.
- **Requirements**: Necessary software and tools needed before running the project.
- **Dependencies**: External libraries or frameworks required to run the project.
- **Installation and Setup**: Instructions to clone, build, and run the application.
- **Endpoints**: Describes the API endpoints with request and response examples.
- **Usage with Postman**: Simple instructions to test the API using Postman.

You can edit this `README.md` to suit your specific project details further! Let me know if you need any help.
