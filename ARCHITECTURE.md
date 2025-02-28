# C4 Architectural Diagrams

## C4 Context Diagram:
This diagram provides a high-level view of the PolishPro System, showcasing its interactions with external entities like customers, admins, and third-party services such as an email service and a database.

```mermaid
C4Context
title PolishPro: Nail Salon Booking System - Context Diagram
Person(customer, "Customer", "A customer who books nail care services.")
Person(admin, "Admin", "An admin who manages the system and appointments.")
System(webApp, "Nail Salon Booking System", "A platform to book, reschedule, and manage nail care appointments and view available services.")
System_Ext(emailService, "Email Service", "Sends email notifications for bookings and reminders.")
SystemDb_Ext(database, "Database", "Stores user data, appointments, services, and displays service information.")

Rel(customer, webApp, "Uses to book appointments and view services")
Rel(admin, webApp, "Manages appointments and services")
Rel(webApp, emailService, "Sends notifications to")
Rel(webApp, database, "Reads from and writes to")

UpdateElementStyle(customer, $fontColor="white", $bgColor="#FFB6C1", $borderColor="#FF69B4")
UpdateElementStyle(admin, $fontColor="white", $bgColor="#FFD700", $borderColor="#FF69B4")
UpdateElementStyle(webApp, $fontColor="white", $bgColor="#BA55D3", $borderColor="#FF69B4")
UpdateElementStyle(emailService, $fontColor="white", $bgColor="#FF69B4", $borderColor="#FF69B4")
UpdateElementStyle(database, $fontColor="white", $bgColor="#FFC0CB", $borderColor="#FF69B4")

UpdateRelStyle(customer, webApp, $textColor="grey", $lineColor="#FF69B4", $offsetY="-5")
UpdateRelStyle(admin, webApp, $textColor="grey", $lineColor="#FF69B4", $offsetY="5")
UpdateRelStyle(webApp, emailService, $textColor="grey", $lineColor="#FF69B4", $offsetY="15")
UpdateRelStyle(webApp, database, $textColor="grey", $lineColor="#FF69B4", $offsetY="25")

UpdateLayoutConfig($c4ShapeInRow="2", $c4BoundaryInRow="1")

```

## C4 Container Diagram:
This diagram details the PolishPro system's structural containers, including the Web App, API, and Database, and how they interact with external services like the Email Service and roles like Customer and Admin.

```mermaid
C4Container
title PolishPro: Nail Salon Booking System - Container Diagram

Person(customer, "Customer", "Books nail care services.")
Person(admin, "Admin", "Manages service and appointments.")

Container_Boundary(salonSys, "Nail Salon System") {
    Container(webApp, "Single Web App", "React", "User interface for booking and managing services.")
    Container(api, "API", "Node.js", "Handles business logic and API requests.")
    ContainerDb(database, "Database", "MySQL", "Stores user data, appointments, and service details.")
    Container_Ext(emailService, "Email Service", "Sends booking confirmations and updates.")
}

Rel(customer, webApp, "Uses")
Rel(admin, webApp, "Oversees")
Rel(webApp, api, "Interacts with", "HTTPS")
Rel(api, database, "Reads/Writes", "JDBC")
Rel(api, emailService, "Communicates with", "SMTP")

UpdateElementStyle(customer, $fontColor="black", $bgColor="#FFB6C1", $borderColor="#FF69B4", $shadowing="true")
UpdateElementStyle(admin, $fontColor="black", $bgColor="#FFD700", $borderColor="#FF69B4", $shadowing="true")
UpdateElementStyle(webApp, $fontColor="black", $bgColor="#BA55D3", $borderColor="#FF69B4", $shadowing="true")
UpdateElementStyle(api, $fontColor="black", $bgColor="#F0E68C", $borderColor="#DAA520", $shadowing="true")
UpdateElementStyle(emailService, $fontColor="black", $bgColor="#FF69B4", $borderColor="#FF69B4", $shadowing="true")
UpdateElementStyle(database, $fontColor="black", $bgColor="#FFC0CB", $borderColor="#FF69B4", $shadowing="true")

UpdateRelStyle(customer, webApp, $textColor="black", $lineColor="#FF69B4", $offsetY="-5")
UpdateRelStyle(admin, webApp, $textColor="black", $lineColor="#FF69B4", $offsetY="5")
UpdateRelStyle(webApp, api, $textColor="black", $lineColor="#FF69B4", $offsetY="15")
UpdateRelStyle(api, database, $textColor="black", $lineColor="#FF69B4", $offsetY="25")
UpdateRelStyle(api, emailService, $textColor="black", $lineColor="#FF69B4", $offsetY="35")

UpdateLayoutConfig($c4ShapeInRow="2", $c4BoundaryInRow="1")

```
## C4 Compontent Diagram:
This diagram breaks down the API Application into smaller components such as the Booking Handler, Notification Sender, and Database Access Manager, detailing their interactions and roles within the system.
```mermaid
C4Component
title PolishPro: Nail Salon Booking System - Component Diagram

Container_Boundary(api, "API Application") {
    Component(bookingHandler, "Booking Handler", "Node.js Module", "Manages bookings, reschedules, and cancellations.")
    Component(notificationSender, "Notification Sender", "Node.js Module", "Sends booking confirmations and reminders.")
    Component(dbAccessManager, "Database Access Manager", "Node.js Module", "Performs CRUD operations with MySQL database.")
    Component_Ext(webApp, "Single Web Application", "React", "Interface for booking and managing services.")

    Rel(bookingHandler, dbAccessManager, "CRUD operations", "JDBC")
    Rel(bookingHandler, notificationSender, "Triggers notifications")
    Rel(webApp, bookingHandler, "Submits requests to", "HTTPS")
}

ContainerDb(database, "Database", "MySQL", "Stores user data, appointments, and service details.")
Container_Ext(emailService, "Email Service", "Handles email notifications.")

Rel(dbAccessManager, database, "Reads from and writes to", "JDBC")
Rel(notificationSender, emailService, "Sends emails", "SMTP")

UpdateElementStyle(bookingHandler, $fontColor="white", $bgColor="#BA55D3", $borderColor="#FF69B4")
UpdateElementStyle(notificationSender, $fontColor="white", $bgColor="#FFC0CB", $borderColor="#FF69B4")
UpdateElementStyle(dbAccessManager, $fontColor="white", $bgColor="#FFD700", $borderColor="#FF69B4")
UpdateElementStyle(webApp, $fontColor="white", $bgColor="#00CED1", $borderColor="#FF69B4")

UpdateRelStyle(bookingHandler, dbAccessManager, $textColor="#FF69B4", $lineColor="#FF69B4", $offsetX="-10")
UpdateRelStyle(bookingHandler, notificationSender, $textColor="#FF69B4", $lineColor="#FF69B4", $offsetX="10")
UpdateRelStyle(dbAccessManager, database, $textColor="#FF69B4", $lineColor="#FF69B4", $offsetX="-10")
UpdateRelStyle(notificationSender, emailService, $textColor="#FF69B4", $lineColor="#FF69B4", $offsetX="10")
UpdateRelStyle(webApp, bookingHandler, $textColor="#FF69B4", $lineColor="#FF69B4", $offsetX="10")

UpdateLayoutConfig($c4ShapeInRow="3", $c4BoundaryInRow="1")

```

## C4 Deployment Diagram:
C4 Deployment Diagram provides a comprehensive view of the infrastructure and environment where the PolishPro Nail Salon Booking System is deployed. It illustrates how the system components are distributed across different environments, including client devices, data centers, and external services.

```mermaid
C4Deployment
    title PolishPro: Nail Salon Booking System - Deployment Diagram

    Deployment_Node(clientDevice, "Client Device", "iOS, Android, Windows, macOS") {
        Deployment_Node(webBrowser, "Web Browser", "Chrome, Firefox, Safari") {
            Container(spa, "Single Page Application (SPA)", "React", "Interface for booking and managing services.")
        }
    }

    Deployment_Node(dataCenter, "PolishPro Data Center", "AWS Cloud") {
        Deployment_Node(serverCluster, "Node.js Servers", "Node.js Deployment") {
            Container(api, "API", "Node.js", "Handles business logic and API requests.")
            Container(authController, "Auth Controller", "Node.js", "Handles authentication.")
            Container(bookingController, "Booking Controller", "Node.js", "Manages bookings.")
            Container(serviceController, "Service Controller", "Node.js", "View and manage services.")
            Container(notificationComponent, "Notification Component", "Node.js", "Handles notifications.")
        }

        Deployment_Node(dbServer, "Database Server", "MySQL") {
            ContainerDb(database, "Database", "MySQL", "Stores users, services, and bookings.")
        }
    }

    Deployment_Node(externalService, "External Email Service", "SMTP Provider") {
        System_Ext(emailService, "Email Service", "Handles sending notifications.")
    }

    Rel(spa, api, "Makes API calls to", "HTTPS")
    Rel(api, authController, "Delegates authentication to", "HTTPS")
    Rel(api, bookingController, "Delegates booking management to", "HTTPS")
    Rel(api, serviceController, "Delegates service management to", "HTTPS")
    Rel(api, notificationComponent, "Delegates notifications to", "HTTPS")
    Rel(notificationComponent, emailService, "Sends notifications using", "SMTP")
    Rel(authController, database, "Reads/Writes user data", "JDBC")
    Rel(bookingController, database, "Reads/Writes booking data", "JDBC")
    Rel(serviceController, database, "Reads/Writes service data", "JDBC")

    UpdateElementStyle(spa, $fontColor="black", $bgColor="#ADD8E6", $borderColor="#4682B4")
    UpdateElementStyle(api, $fontColor="black", $bgColor="#F0E68C", $borderColor="#DAA520")
    UpdateElementStyle(authController, $fontColor="black", $bgColor="#98FB98", $borderColor="#2E8B57")
    UpdateElementStyle(bookingController, $fontColor="black", $bgColor="#FFDAB9", $borderColor="#FF6347")
    UpdateElementStyle(serviceController, $fontColor="black", $bgColor="#E6E6FA", $borderColor="#9370DB")

```
