# 2. Product Backlog - PolishPro: Nail Salon Booking System

## 📋 Overview
This **Product Backlog** is structured using the **MoSCoW prioritization** method:
- **Must-have**: Essential features required for the system to function.
- **Should-have**: Important but not immediately critical features.
- **Could-have**: Nice-to-have features.
- **Won’t-have**: Features excluded from the current scope.

## 📑 Product Backlog Table

| Story ID | User Story | Priority (MoSCoW) | Effort Estimate | Dependencies |
|----------|-----------|-------------------|----------------|--------------|
| US001| As a **client**, I want to **register an account** so that I can **book appointments online**. | Must-have | 3 | None |
| US002 | As a **client**, I want to **log into my account** so that I can **access my booking history and schedule new appointments**. | Must-have | 2 | US001 |
| US003 | As a **client**, I want to **reset my password** so that I can **regain access to my account if I forget it**. | Should-have | 3 | US001 |
| US004 | As a **client**, I want to **view available services** so that I can **choose the right treatment for my needs**. | Must-have | 2 | None |
| US005| As a **client**, I want to **book an appointment** so that I can **schedule a nail treatment at a convenient time**. | Must-have | 5 | US001, US004 |
| US006 | As a **client**, I want to **receive an appointment confirmation email** so that I can **be sure my booking was successful**. | Must-have | 3 | US005 |
| US007 | As a **client**, I want to **cancel or reschedule an appointment** so that I can **change my plans if needed**. | Must-have | 4 | US005 |
| US008 | As a **client**, I want to **receive email reminders** so that I can **avoid missing my appointments**. | Should-have | 3 | US005, US006 |
| US009 | As a **nail technician**, I want to **view my assigned appointments** so that I can **prepare for upcoming clients**. | Must-have | 2 | US005 |
| US010 | As a **nail technician**, I want to **view client preferences** so that I can **personalize my service**. | Should-have | 3 | US005 |
| US011 | As a **salon owner/manager**, I want to **manage time slots and scheduling** so that I can **ensure smooth operations**. | Must-have | 4 | US005 |
| US012 | As a **salon owner/manager**, I want to **modify available services** so that I can **keep offerings up to date**. | Should-have | 3 | None |
| US013 | As an **IT administrator**, I want to **manage email failures** so that I can **ensure all notifications are sent properly**. | Could-have | 2 | US006, US008 |

## 📌 Justification for Prioritization

### **Must-have User Stories**
These are fundamental for the system's **core functionality** and **business goals**.

- **US001 (User Registration)**: Without registration, clients cannot book appointments.
- **US002 (User Login)**: Clients need access to manage bookings.
- **US004 (View Services)**: Users must see services before booking.
- **US005 (Book Appointment)**: Core feature, ensuring clients can schedule treatments.
- **US006 (Confirmation Email)**: Users need confirmation to avoid booking uncertainty.
- **US007 (Cancel/Reschedule Appointments)**: Provides flexibility and reduces no-shows.
- **US009 (Technician Viewing Appointments)**: Essential for technicians to prepare.
- **US011 (Manage Scheduling)**: Crucial for business operations to avoid double bookings.

### **Should-have User Stories**
These enhance the **user experience** but do not block system usability.

- **US003 (Password Reset)**: Important for accessibility but not required for initial launch.
- **US008 (Email Reminders)**: Helps reduce missed appointments but is not critical.
- **US010 (Client Preferences for Technicians)**: Improves service quality but can be added later.
- **US012 (Modify Services)**: Important for management but does not impact immediate usability.

### **Could-have User Stories**
These add **extra functionality** but are not a priority.

- **US013 (Manage Email Failures)**: Ensuring email delivery is valuable but not urgent.

### **Won’t-have User Stories**
These are **out of scope** for this release due to complexity, budget, or priority alignment.

- Social media integrations (Nice but not essential for booking)
- loyalty rewards (Future enhancement)
- Advanced analytics (Future enhancement)
- Rating Reviews (Future enhancement)
These would further enhance usability and customer retention but are not essential for initial deployment.

This backlog ensures that **Must-have features align with PolishPro’s success metrics**, particularly **usability, reliability, and operational efficiency**. **Should-have and Could-have features** are scheduled for later phases, balancing **business value and development effort**.

## Product Backlog - Non-Functional Requirements

| **Story ID** | **User Story** | **Priority (MoSCoW)** | **Effort Estimate** | **Dependencies** |
|-------------|--------------|-----------------|------------------|----------------|
| **US-014** | As a UI/UX designer, I want to ensure WCAG 2.1 compliance so that users with accessibility needs can navigate the system easily. | Must-have | 4 | None |
| **US-015** | As a user, I want the system to be accessible on desktops, tablets, and mobile devices so that I can book appointments seamlessly regardless of my device.| Must-have | 3 | None |
| **US-016** | As a client, I want a simple and intuitive UI so that I can navigate and book appointments easily. | Must-have | 3 | None |
| **US-017** | As a developer, I want a well-documented API so that I can easily integrate new features and third-party services. | Should-have | 3 | None |
| **US-018** | As an IT administrator, I want logs to capture failed email notifications so that I can troubleshoot and resolve issues efficiently. | Must-have | 2 | Email notification system implementation |
| **US-019** | As an IT admin, I want the system to support up to 1,500 concurrent users so that performance is maintained during peak usage. | Should-have | 4 | Performance testing tools |
| **US-020** | As an IT administrator, I want the system to scale horizontally so that it can accommodate future business growth. | Should-have | 5 | Initial architecture design |
| **US-021** | As an IT administrator, I want user data encrypted with AES-256 so that security compliance is met. | Must-have | 4 | None |
| **US-022** | As an IT administrator, I want all user activities to be logged so that security monitoring and auditing can be performed. | Should-have | 3 | Logging infrastructure |
| **US-023** | As an IT administrator, I want role-based access control (RBAC) so that only authorized users can perform admin functions. | Must-have | 4 | Authentication system implementation |
| **US-024** | As a user, I want seamless interactions between the front-end and back-end so that my actions are processed within 2 seconds. | Must-have | 3 | Optimized database queries, API performance |
| **US-025** | As a Salon owner, I want the system to maintain an uptime of at least 99.9% so that appointment bookings and management are always available. | Must-have | 5 | Server infrastructure & monitoring setup |
| **US-026** | As an IT admin, I want automated system updates via CI/CD so that system stability and security are maintained with minimal downtime. | Should-have | 4 | CI/CD pipeline setup |
 
 ## 📌 Justification for Prioritization
The prioritization follows the **MoSCoW (Must-have, Should-have, Could-have, Won’t-have) framework**, ensuring that critical system functionalities are prioritized while allowing flexibility for future enhancements.  

### **Must-have (Critical for System Functionality, Security, and User Experience)**  
These requirements are essential for the system to function as intended, ensuring usability, accessibility, security, and system stability. Without them, the system would fail to meet stakeholder expectations or legal/compliance standards.  
- **US-014 (WCAG 2.1 Compliance)** – Ensuring accessibility is a **legal and ethical requirement**, making it critical for users with disabilities.  
- **US-015 (Cross-Device Compatibility)** – Given that users will access the system from various devices, responsiveness is essential for usability.  
- **US-016 (Intuitive UI for Clients)** – A poor user experience would lead to low adoption rates, directly impacting business success.  
- **US-018 (Failed Email Logging)** – Essential for troubleshooting and ensuring important communications (e.g., appointment confirmations) are not lost.  
- **US-021 (AES-256 Encryption)** – Required for **data security and compliance** with industry standards. Any breach could lead to legal liabilities and reputational damage.  
- **US-023 (Role-Based Access Control - RBAC)** – Ensures proper access management, preventing unauthorized actions that could compromise the system.  
- **US-024 (Fast Frontend-Backend Interactions)** – Slow performance leads to frustration and system abandonment, making performance a core necessity.  
- **US-025 (99.9% Uptime)** – Since the booking system is business-critical, downtime directly affects revenue and customer satisfaction.  

### **Should-have (Enhances Performance, Maintainability, and Scalability)**  
These requirements are valuable but not immediately necessary. The system can function without them in the initial release, but they provide long-term benefits in terms of growth, efficiency, and automation.  
- **US-017 (API Documentation)** – While essential for long-term development, Agile methodologies emphasize iterative documentation, so initial releases can function without complete API documentation.  
- **US-019 (Concurrent Users Support)** – Scalability is important but not an immediate blocker for launch, as traffic will grow over time.  
- **US-020 (Horizontal Scaling)** – Future-proofing the system is crucial, but initial usage may not require extensive scaling from the start.  
- **US-022 (User Activity Logging)** – While valuable for **security auditing**, it’s not required in the MVP (Minimum Viable Product) phase. Logs can be expanded iteratively.  
- **US-026 (CI/CD Automation)** – Automating updates improves stability, but manual deployments can suffice in early stages.  

### **Won’t-have**  
- Every listed requirement directly impacts.
