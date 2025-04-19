# 💅PolishPro 
Nail Salon Booking System

## Project Description
The Nail Salon Booking System is an online solution designed to automate the booking process for nail care services. This system will streamline appointment management, reduce operational errors, and enhance the customer experience by providing a user-friendly interface for booking, rescheduling, and canceling appointments.

# Links
## Specification 
- [SPECIFICATION](https://github.com/demifarquhar01/PolishPro/blob/f09bce30ff488a3d06ebd398bc550e2b811fc41c/Specification/SPECIFICATION.md)
- [ARCHITECTURE](https://github.com/demifarquhar01/PolishPro/blob/f09bce30ff488a3d06ebd398bc550e2b811fc41c/Specification/ARCHITECTURE.md)

## System Requirements Document 
- [Stakeholder-Analysis-Table](https://github.com/demifarquhar01/PolishPro/blob/f09bce30ff488a3d06ebd398bc550e2b811fc41c/System-Requirements-Document/Stakeholder-Analysis-Table.md)
- [System-Requirements-Document](https://github.com/demifarquhar01/PolishPro/blob/f09bce30ff488a3d06ebd398bc550e2b811fc41c/System-Requirements-Document/System-Requirements-Document.md)

## Use Case And Test Case Document
- [Test-And-Use-Case-Document](https://github.com/demifarquhar01/PolishPro/blob/f09bce30ff488a3d06ebd398bc550e2b811fc41c/Test-And-Use-Case-Document/Test-And-Use-Case-Document.md)


## Agile Planning Document 
- [User-Story](https://github.com/demifarquhar01/PolishPro/blob/c6db6a9cb9956febd955a53b6b6b72f6ff7dafa0/Agile-Planning-Document/User-Story.md)
- [Product-Backlog](https://github.com/demifarquhar01/PolishPro/blob/c6db6a9cb9956febd955a53b6b6b72f6ff7dafa0/Agile-Planning-Document/Product-Backlog.md)
- [Sprint-Plan](https://github.com/demifarquhar01/PolishPro/blob/8e0bd4938a08c4a6b8668a179c3805860262e5a9/Agile-Planning-Document/Sprint-Plan.md)
- [Reflection6](https://github.com/demifarquhar01/PolishPro/blob/8e0bd4938a08c4a6b8668a179c3805860262e5a9/Agile-Planning-Document/Reflection6.md)

## GitHub Project Templates and Kanban Board Implementation
- [template-analysis](https://github.com/demifarquhar01/PolishPro/blob/78a53ee88a1d269d6e23d339ed2cc5275fc8f36e/GitHub-Kanban-Board-Document/template-analysis.md)
- [kanban-explanation](https://github.com/demifarquhar01/PolishPro/blob/78a53ee88a1d269d6e23d339ed2cc5275fc8f36e/GitHub-Kanban-Board-Document/kanban-explanation.md)
- [Screenshot](https://github.com/demifarquhar01/PolishPro/blob/78a53ee88a1d269d6e23d339ed2cc5275fc8f36e/GitHub-Kanban-Board-Document/Screenshot.md)
- [reflection](https://github.com/demifarquhar01/PolishPro/blob/78a53ee88a1d269d6e23d339ed2cc5275fc8f36e/GitHub-Kanban-Board-Document/reflection.md)

##  Object State Modeling and Activity Workflow Modeling Objective 
- [State-Transition-Diagrams](https://github.com/demifarquhar01/PolishPro/blob/2e9b097dca5eecf7b775e149e64a8ffc1fad5724/State-Transition-Diagrams.md)
- [Activity-Diagrams](https://github.com/demifarquhar01/PolishPro/blob/2e9b097dca5eecf7b775e149e64a8ffc1fad5724/Activity-Diagrams.md)
- [Explanations](https://github.com/demifarquhar01/PolishPro/blob/2e9b097dca5eecf7b775e149e64a8ffc1fad5724/Explanations.md)
- [Reflection](https://github.com/demifarquhar01/PolishPro/blob/e9858bae975cde4939398c57fee2557fd6104541/Reflection.md)

## Domain Modeling and Class Diagram Development
- [Domain-Model](https://github.com/demifarquhar01/PolishPro/blob/c53efab877b6bb486167379be0f35b2602bcedf8/Domain-Model.md)
- [Class-Diagram](https://github.com/demifarquhar01/PolishPro/blob/c53efab877b6bb486167379be0f35b2602bcedf8/Class-Diagram.md)
- [Reflection](https://github.com/demifarquhar01/PolishPro/blob/c53efab877b6bb486167379be0f35b2602bcedf8/Reflection.md)

## From Class Diagrams to Code with All Creational Patterns

### Class Implementation - Language Choice & Design Decisions
### 🔷 Language Choice: Java

I chose **Java** for the implementation of this system due to the following reasons:

- **Object-Oriented Structure:** Java is fully object-oriented, making it an excellent fit for translating UML class diagrams directly into code using encapsulation, inheritance, and polymorphism.
- **Strong Typing & Compile-Time Checking:** Java's strict type checking helps prevent common bugs early, which is especially useful for a structured system like a booking platform.
- **Standard Design Pattern Support:** Java makes it easier to implement design patterns such as Factory, Singleton, and Builder, which are used throughout this system for object creation and management.
- **Scalability and Maintainability:** Java applications are easier to maintain and scale. For a medium-sized business like a nail salon, it’s important to be able to add new features (e.g., loyalty systems, staff rating) without rewriting core logic.
- **Community and Documentation:** Java has a massive developer community, and most issues are well-documented online, which helps speed up development and learning.

### 🔷 Key Design Decisions
- **Encapsulation:** All attributes are marked private and accessed via getters/setters to protect data and allow validation logic if needed.
- **Inheritance:** Classes like `Client`, `SalonOwner`, and `NailTechnician` extend from a base `User` class to reduce redundancy.
- **Composition:** The system uses composition for entities like `Appointment`, `Schedule`, and `ClientPreference` to ensure modularity and loose coupling.
- **Error Handling:** Most methods check for `null` inputs or invalid states to make the application more robust.
- **Clear Separation of Concerns:** Each class has a single responsibility (e.g., `ClientPreference` handles only client preferences).

### 📁 Code Structure
The full source code is located in the `polishpro/src/demifarquhar01` directory.



 
