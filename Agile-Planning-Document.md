# 📌 User Stories for PolishPro: Nail Salon Booking System
## 🎯 Overview  
This document contains user stories derived from functional requirements and use cases for the **PolishPro: Nail Salon Booking System**.

## 1. User Stories  

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
 
 ### Justifications for Prioritization  
The prioritization follows the **MoSCoW (Must-have, Should-have, Could-have, Won’t-have) framework**, ensuring that critical system functionalities are prioritized while allowing flexibility for future enhancements.  

#### **Must-have (Critical for System Functionality, Security, and User Experience)**  
These requirements are essential for the system to function as intended, ensuring usability, accessibility, security, and system stability. Without them, the system would fail to meet stakeholder expectations or legal/compliance standards.  
- **US-014 (WCAG 2.1 Compliance)** – Ensuring accessibility is a **legal and ethical requirement**, making it critical for users with disabilities.  
- **US-015 (Cross-Device Compatibility)** – Given that users will access the system from various devices, responsiveness is essential for usability.  
- **US-016 (Intuitive UI for Clients)** – A poor user experience would lead to low adoption rates, directly impacting business success.  
- **US-018 (Failed Email Logging)** – Essential for troubleshooting and ensuring important communications (e.g., appointment confirmations) are not lost.  
- **US-021 (AES-256 Encryption)** – Required for **data security and compliance** with industry standards. Any breach could lead to legal liabilities and reputational damage.  
- **US-023 (Role-Based Access Control - RBAC)** – Ensures proper access management, preventing unauthorized actions that could compromise the system.  
- **US-024 (Fast Frontend-Backend Interactions)** – Slow performance leads to frustration and system abandonment, making performance a core necessity.  
- **US-025 (99.9% Uptime)** – Since the booking system is business-critical, downtime directly affects revenue and customer satisfaction.  

#### **Should-have (Enhances Performance, Maintainability, and Scalability)**  
These requirements are valuable but not immediately necessary. The system can function without them in the initial release, but they provide long-term benefits in terms of growth, efficiency, and automation.  
- **US-017 (API Documentation)** – While essential for long-term development, Agile methodologies emphasize iterative documentation, so initial releases can function without complete API documentation.  
- **US-019 (Concurrent Users Support)** – Scalability is important but not an immediate blocker for launch, as traffic will grow over time.  
- **US-020 (Horizontal Scaling)** – Future-proofing the system is crucial, but initial usage may not require extensive scaling from the start.  
- **US-022 (User Activity Logging)** – While valuable for **security auditing**, it’s not required in the MVP (Minimum Viable Product) phase. Logs can be expanded iteratively.  
- **US-026 (CI/CD Automation)** – Automating updates improves stability, but manual deployments can suffice in early stages.  

#### **Won’t-have**  
-Every listed requirement directly impacts.

---

# 3. **Sprint: Core Booking Functionality**  

## 🎯 **Sprint Goal Statement**  
This sprint focuses on developing the **core booking features**, forming the foundation of the **Minimum Viable Product (MVP)**. By the end of this sprint, users should be able to:  
- **View available services**  
- **Book an appointment**  
- **Receive a confirmation email**  

These essential functionalities ensure a **seamless booking experience**, setting the stage for the other functionality like user authentication and scheduling flexibility.  

---

## 📌 **Sprint Backlog**  

| Task ID  | Task Description                                | Assigned To          | Estimated Hours | Status  |
|----------|----------------------------------------------|----------------------|----------------|---------|
| **T-001** | Develop appointment booking API              | Full Stack Developer | 8              | To Do   | 
| **T-002** | Design UI for appointment booking page       | UI/UX Designer       | 6              | To Do   | 
| **T-003** | Implement database schema for bookings       | Full Stack Developer | 5              | To Do   | 
| **T-004** | Develop email confirmation functionality     | Full Stack Developer | 7              | To Do   | 
| **T-005** | Implement service listing functionality      | Full Stack Developer | 5              | To Do   | 
| **T-006** | Test booking flow and fix UI issues          | Full Stack Developer | 6              | To Do   | 
| **T-007** | Integrate API with front-end booking page    | Full Stack Developer | 6              | To Do   | 
| **T-008** | Deploy and test email notifications in staging | Full Stack Developer | 5              | To Do   | 
| **T-009** | Conduct final sprint review                  | Full Stack Developer | 4              | To Do   |

---

## 🛠️ **Sprint Success Criteria**  
✅ **Users can view available services** on the system.  
✅ **Users can successfully book an appointment** through the system.  
✅ **Users receive a confirmation email** immediately after booking.  
✅ **Booking functionality is fully tested, integrated, and bug-free** before moving to the next sprint.  

---
## 📌 **Sprint Adjustments for Feasibility**  
- The **total estimated workload is 47 hours**, making it **manageable within a 2-week sprint**.  
- **Week 1 Focus:** Database setup (T-003), API development (T-001), and UI design (T-002).  
- **Week 2 Focus:** Email integration (T-004), testing & UI fixes (T-006), API integration (T-007), and final review (T-009).  

This structured approach ensures that the **core booking process is functional and user-friendly.** 🚀

--- 
# 📝 Reflection: Challenges in Prioritization, Estimation, and Agile Alignment  

## 📌 Overview  
Working on the **PolishPro: Nail Salon Booking System** solo has been an insightful experience. Without a team to delegate tasks or provide feedback, I had to tackle challenges in **prioritization, estimation, and aligning Agile** with my workflow on my own.  

## 🔥 Challenges Faced  

### 1️⃣ **Prioritization Struggles**  
One of the biggest hurdles was balancing **business value, technical feasibility, and user expectations**. While some features, like **appointment booking**, were clearly top priority, others—such as **viewing client preferences**—required deeper consideration.  

At first, I thought client preferences might be a **Should-have**, but after revisiting the business needs, I realized it plays a **critical role** in improving customer satisfaction and service quality. Nail technicians need quick access to client history, preferred services, and past appointments to provide **personalized experiences**. Without this, the system wouldn't fully support its intended purpose.  

This made me rethink how I prioritize features—not just based on core functionality but also on **real business impact**. It reinforced the importance of validating **initial assumptions** and continuously aligning priorities with business goals.  


Additionally, different stakeholders had conflicting priorities.  
- The **Salon Owner** wanted efficient operations (e.g., managing appointment slots).  
- **Clients** valued ease of use (e.g., a simple booking UI).  
- The **IT Administrator** emphasized security and system reliability.  

Aligning these needs meant making trade-offs—some features had to be **deprioritized** for the MVP.  

**What Comes First?**  
One major struggle was deciding **what to focus on in Sprint 1**. Since the system required multiple key features—booking management, user authentication, email notifications, and more—it was tempting to start everything at once. But that goes against **Agile principles**, which emphasize **incremental value delivery**.  

At first, I considered building **user authentication** first, but I realized that without a booking system, the app wouldn’t serve its core purpose. I ultimately decided to **focus Sprint 1 on booking functionality**, ensuring users could schedule appointments and receive confirmations.  

📝 **Lesson Learned:** Prioritization isn’t just about importance—it’s about **what provides early value**.  

---

### 2️⃣ **Challenges in Estimation**  
Estimating effort for user stories was trickier than expected.  

**Uncertainty in Complexity:** Some features seemed simple but had hidden complexities. For example, password reset required email validation and security measures, adding unexpected effort.  

**Dependencies Between Features:** Booking an appointment depended on having available services and registered users. If one part was delayed, it affected everything else.  

**Balancing Scope vs. Development Time:** Features like email reminders were valuable but weren’t essential for launch. Estimating their effort helped decide whether to **include them in Phase 1 or postpone them**.  

Since I was handling both **development and testing**, I had to determine realistic timelines. Some tasks, like setting up the **database schema**, became more complex than expected due to data relationships and optimization needs.  

---

### 3️⃣ **Aligning Agile**  
Agile typically involves team collaboration, stand-ups, and retrospectives. As a **solo developer**, I had to **adapt Agile to my workflow**:  

- Used **GitHub Issues** to track tasks.  
- Created **Milestones** to define sprint goals.  
- Conducted **self-reviews** at the end of each sprint to evaluate progress.  

However, without external feedback, it was easy to **overlook mistakes** or spend too much time on one area. To counter this, I started **reviewing the system from a user’s perspective** at regular checkpoints.  

**Aligning Stakeholder Needs:**  
- **Iterative Feedback:** Clients and technicians provided feedback, sometimes requiring **mid-sprint changes**. While Agile allows flexibility, **too many changes** disrupted sprint planning.  
- **Non-Functional Requirements (NFRs):** Stakeholders focused on **features**, but **security, scalability, and performance** needed attention too. Tackling NFRs early prevented **technical debt later**.  

---
## 🎯 **Final Thoughts**  
- **Trade-offs are necessary**—not everything can be delivered in the first release.  
- **Estimations improve over time**—initial guesses may be off, but experience refines accuracy.  
- **Prioritization should align with business impact**—delivering **early value** ensures stakeholders see results faster.  

 Reflecting on this experience, I realize that **structured planning and adaptability** are essential. While challenging, this process has strengthened my ability to balance priorities, make realistic effort estimations, and integrate Agile principles into my workflow. This project will also support my professional growth by enhancing how I approach future projects. 🚀
