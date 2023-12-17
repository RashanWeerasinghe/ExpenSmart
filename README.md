# ExpenSmart

## Project Description
ExpenSmart is an Expense Manager API developed using Spring Boot. It provides a set of RESTful APIs for managing expenses, including functionalities for user registration, authentication using JWT, and various operations related to expense management.

### GitHub Repository
- GitHub Repository Link: [ExpenSmart GitHub](https://github.com/RashanWeerasinghe/ExpenSmart.git)

### Technologies Used
- Spring Boot: Backend development framework
- MySQL: Database management
- JWT (JSON Web Tokens): User authentication and authorization

### Features
- User registration with roles (admin, editor, etc.) and authorization using JWT.
- RESTful APIs for managing expenses, including CRUD operations.
- Filtering expenses by category, name, and date range.

### API Endpoints
- **Authentication**
  - `POST /api/v1/register`: User registration
  - `POST /api/v1/login`: User login
  - `DELETE /api/v1/logout`: User logout

- **Expense Management**
  - `GET /api/v1/expenses`: Get all expenses
  - `GET /api/v1/expenses/{id}`: Get expenses by ID
  - `PUT /api/v1/expenses/{id}`: Update an expense
  - `DELETE /api/v1/expenses?id={value}`: Delete expense by ID
  - `POST /api/v1/expenses`: Save a new expense
  - `GET /api/v1/expenses/category?category={value}`: Read expenses by category
  - `GET /api/v1/expenses/expenses/name?keyword={value}`: Get expenses by name
  - `GET /api/v1/expenses/expenses/date?startDate={date}&endDate={date}`: Get expenses by date range

### Getting Started
To get started with ExpenSmart, follow these steps:

1. Clone the project repository from [GitHub](https://github.com/RashanWeerasinghe/ExpenSmart.git).
2. Set up a MySQL database and configure the database connection in `application.properties`.
3. Build and run the project using Maven or your preferred IDE.
4. Access the APIs using the provided endpoints.

### Contributing
Contributions to ExpenSmart are welcome! If you'd like to contribute to the project, please follow our [Contribution Guidelines](CONTRIBUTING.md).

### License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
