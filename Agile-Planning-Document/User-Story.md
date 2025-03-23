# 📌 User Stories for PolishPro: Nail Salon Booking System
## 🎯 Overview  
This document contains user stories derived from functional requirements and use cases for the **PolishPro: Nail Salon Booking System**.

# 1. User Stories  

## Github project tools for user story table

![image](https://github.com/demifarquhar01/PolishPro/blob/c6db6a9cb9956febd955a53b6b6b72f6ff7dafa0/Agile-Planning-Document/user%20story.png)

--- 

## User Stories Table 

| Story ID  | User Story  | Acceptance Criteria  | Priority  |
|-----------|------------|----------------------|-----------|
| US001  | As a **client**, I want to **register an account** so that I can **book appointments online**. | - User provides name, email, and password.<br>- System validates input and creates an account.<br>- A confirmation email is sent. | High  |
| US002  | As a **client**, I want to **log into my account** so that I can **access my booking history and schedule new appointments**. | - User enters valid email and password.<br>- System authenticates and grants access.<br>- If invalid, an error message is displayed. | High  |
| US003  | As a **client**, I want to **reset my password** so that I can **regain access to my account if I forget it**. | - User requests password reset.<br>- System sends an email with a reset link.<br>- User sets a new password, and system updates it. | Medium  |
| US004  | As a **client**, I want to **view available services** so that I can **choose the right treatment for my needs**. | - User navigates to the services page.<br>- System retrieves and displays available services. | High  |
| US005  | As a **client**, I want to **book an appointment** so that I can **schedule a nail treatment at a convenient time**. | - User selects a service, date, and time.<br>- System checks technician availability.<br>- System books the appointment and sends confirmation. | High  |
| US006  | As a **client**, I want to **receive an appointment confirmation email** so that I can **be sure my booking was successful**. | - System generates and sends confirmation email.<br>- Email includes appointment details. | High  |
| US007  | As a **client**, I want to **cancel or reschedule an appointment** so that I can **change my plans if needed**. | - User selects an appointment.<br>- If > 24 hours away, user cancels or selects a new date/time.<br>- System updates and sends confirmation. | High  |
| US008  | As a **client**, I want to **receive email reminders** so that I can **avoid missing my appointments**. | - System schedules reminders based on appointment time.<br>- Email reminder is sent 24 hours before. | Medium  |
| US009  | As a **nail technician**, I want to **view my assigned appointments** so that I can **prepare for upcoming clients**. | - User logs in with technician credentials.<br>- System retrieves and displays assigned appointments. | High  |
| US010  | As a **nail technician**, I want to **view client preferences** so that I can **personalize my service**. | - Technician navigates to client profile.<br>- System retrieves and displays past preferences. | Medium  |
| US011  | As a **salon owner/manager**, I want to **manage time slots and scheduling** so that I can **ensure smooth operations**. | - Admin navigates to scheduling settings.<br>- System allows time slot updates and saves changes. | High  |
| US012  | As a **salon owner/manager**, I want to **modify available services** so that I can **keep offerings up to date**. | - Admin updates service details.<br>- System applies and saves changes. | Medium  |
| US013  | As an **IT administrator**, I want to **manage email failures** so that I can **ensure all notifications are sent properly**. | - System detects failed emails and retries sending.<br>- IT admin is alerted for persistent failures. | Medium  |

## Non-Functional User Stories
## Usability & Accessibility
- **As a UI/UX designer,** I want to ensure WCAG 2.1 compliance so that users with accessibility needs can navigate the system easily.
- **As a user,** I want the system to be accessible on desktops, tablets, and mobile devices so that I can easily interact with the system on any device.
- **As a client,** I want a simple and intuitive UI so that I can navigate and book appointments easily.**  
## Maintainability
- **As a developer,** I want a well-documented API so that I can easily integrate new features and third-party services.
- **As an IT administrator,** I want logs to capture failed email notifications so that I can troubleshoot and resolve issues efficiently.**  
## Scalability
- **As a IT administrator,** I want the system to support up to 1,500 concurrent users so that performance is maintained during peak usage.
- **As a IT administrator,** I want the system to scale horizontally so that it can accommodate future business growth.
## Security
- **As a IT administrator,** I want user data encrypted with AES-256 so that security compliance is met.
- **As IT administrator,** I want all user activities to be logged so that security monitoring and auditing can be performed.
- **As a IT administrator,** I want role-based access control (RBAC) so that only authorized users can perform admin functions.
## Performance
- **As a user,** I want seamless interactions between the front-end and back-end so that my actions are processed within 2 seconds.
- **As a Salon owner,** I want the system to maintain an uptime of at least 99.9% so that appointment bookings and management are always available.
## Deployment & Updates
- **As a IT administrator,** I want automated system updates via CI/CD so that system stability and security are maintained with minimal downtime.

---

