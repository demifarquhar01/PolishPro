# 📌 User Stories for PolishPro: Nail Salon Booking System
## 🎯 Overview  
This document contains user stories derived from functional requirements and use cases for the **PolishPro: Nail Salon Booking System**.

## 📝 User Stories  

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

# 📌 PolishPro: Nail Salon Booking System - Product Backlog

## 📋 Overview
This **Product Backlog** is structured using the **MoSCoW prioritization** method:
- **Must-have**: Essential features required for the system to function.
- **Should-have**: Important but not immediately critical features.
- **Could-have**: Nice-to-have features that enhance usability.
- **Won’t-have**: Features excluded from the current scope.

Each user story includes an **effort estimate (1-5 story points)** and **dependencies** where applicable.

## 📑 Product Backlog Table

| Story ID | User Story | Priority (MoSCoW) | Effort Estimate | Dependencies |
|----------|-----------|-------------------|----------------|--------------|
| US001 | As a **client**, I want to **register an account** so that I can **book appointments online**. | Must-have | 3 | None |
| US002 | As a **client**, I want to **log into my account** so that I can **access my booking history and schedule new appointments**. | Must-have | 2 | US001 |
| US003 | As a **client**, I want to **reset my password** so that I can **regain access to my account if I forget it**. | Should-have | 3 | US001 |
| US004 | As a **client**, I want to **view available services** so that I can **choose the right treatment for my needs**. | Must-have | 2 | None |
| US005 | As a **client**, I want to **book an appointment** so that I can **schedule a nail treatment at a convenient time**. | Must-have | 5 | US001, US004 |
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
| **US-001** | As a UI/UX designer, I want to ensure WCAG 2.1 compliance so that users with accessibility needs can navigate the system easily. | Must-have | 4 | None |
| **US-002** | As a user, I want the system to be accessible on desktops, tablets, and mobile devices so that I can book appointments seamlessly regardless of my device.| Must-have | 3 | None |
| **US-003** | As a client, I want a simple and intuitive UI so that I can navigate and book appointments easily. | Must-have | 3 | None |
| **US-004** | As a developer, I want a well-documented API so that I can easily integrate new features and third-party services. | Should-have | 3 | None |
| **US-005** | As an IT administrator, I want logs to capture failed email notifications so that I can troubleshoot and resolve issues efficiently. | Must-have | 2 | Email notification system implementation |
| **US-006** | As an IT admin, I want the system to support up to 1,500 concurrent users so that performance is maintained during peak usage. | Should-have | 4 | Performance testing tools |
| **US-007** | As an IT admin, I want the system to scale horizontally so that it can accommodate future business growth. | Should-have | 5 | Initial architecture design |
| **US-008** | As an IT admin, I want user data encrypted with AES-256 so that security compliance is met. | Must-have | 4 | None |
| **US-009** | As an IT admin, I want all user activities to be logged so that security monitoring and auditing can be performed. | Should-have | 3 | Logging infrastructure |
| **US-010** | As an IT admin, I want role-based access control (RBAC) so that only authorized users can perform admin functions. | Must-have | 4 | Authentication system implementation |
| **US-011** | As a user, I want seamless interactions between the front-end and back-end so that my actions are processed within 2 seconds. | Must-have | 3 | Optimized database queries, API performance |
| **US-012** | As a Salon owner, I want the system to maintain an uptime of at least 99.9% so that appointment bookings and management are always available. | Must-have | 5 | Server infrastructure & monitoring setup |
| **US-013** | As an IT admin, I want automated system updates via CI/CD so that system stability and security are maintained with minimal downtime. | Should-have | 4 | CI/CD pipeline setup |
 
 ### Justifications for Prioritization  
The prioritization follows the **MoSCoW (Must-have, Should-have, Could-have, Won’t-have) framework**, ensuring that critical system functionalities are prioritized while allowing flexibility for future enhancements.  

#### **Must-have (Critical for System Functionality, Security, and User Experience)**  
These requirements are essential for the system to function as intended, ensuring usability, accessibility, security, and system stability. Without them, the system would fail to meet stakeholder expectations or legal/compliance standards.  
- **US-001 (WCAG 2.1 Compliance)** – Ensuring accessibility is a **legal and ethical requirement**, making it critical for users with disabilities.  
- **US-002 (Cross-Device Compatibility)** – Given that users will access the system from various devices, responsiveness is essential for usability.  
- **US-003 (Intuitive UI for Clients)** – A poor user experience would lead to low adoption rates, directly impacting business success.  
- **US-005 (Failed Email Logging)** – Essential for troubleshooting and ensuring important communications (e.g., appointment confirmations) are not lost.  
- **US-008 (AES-256 Encryption)** – Required for **data security and compliance** with industry standards. Any breach could lead to legal liabilities and reputational damage.  
- **US-010 (Role-Based Access Control - RBAC)** – Ensures proper access management, preventing unauthorized actions that could compromise the system.  
- **US-011 (Fast Frontend-Backend Interactions)** – Slow performance leads to frustration and system abandonment, making performance a core necessity.  
- **US-012 (99.9% Uptime)** – Since the booking system is business-critical, downtime directly affects revenue and customer satisfaction.  

#### **Should-have (Enhances Performance, Maintainability, and Scalability)**  
These requirements are valuable but not immediately necessary. The system can function without them in the initial release, but they provide long-term benefits in terms of growth, efficiency, and automation.  
- **US-004 (API Documentation)** – While essential for long-term development, Agile methodologies emphasize iterative documentation, so initial releases can function without complete API documentation.  
- **US-006 (Concurrent Users Support)** – Scalability is important but not an immediate blocker for launch, as traffic will grow over time.  
- **US-007 (Horizontal Scaling)** – Future-proofing the system is crucial, but initial usage may not require extensive scaling from the start.  
- **US-009 (User Activity Logging)** – While valuable for **security auditing**, it’s not required in the MVP (Minimum Viable Product) phase. Logs can be expanded iteratively.  
- **US-013 (CI/CD Automation)** – Automating updates improves stability, but manual deployments can suffice in early stages.  

#### **Won’t-have**  
-Every listed requirement directly impacts.

---

# 🚀 **Sprint: Core Booking Functionality**  

## 🎯 **Sprint Goal Statement**  
This sprint focuses on developing the **core booking features**, forming the foundation of the **Minimum Viable Product (MVP)**. By the end of this sprint, users should be able to:  
- **View available services**  
- **Book an appointment**  
- **Receive a confirmation email**  

These essential functionalities ensure a **seamless booking experience**, setting the stage for future enhancements like user authentication and scheduling flexibility.  

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

This structured approach ensures that the **core booking process is functional, user-friendly, and ready for future enhancements.** 🚀

--- 
# 📝 Sprint Reflection: Challenges in Prioritization, Estimation, and Agile Alignment  

## 📌 Overview  
Developing the **PolishPro: Nail Salon Booking System** alone has been a unique experience. Without a team to provide feedback or distribute tasks, I found myself facing internal struggles in **prioritization, estimation, and aligning Agile** to my workflow. Agile thrives in team environments where collaboration helps refine requirements, but as a solo developer, I had to adjust the framework to fit my needs.  

This reflection explores the biggest challenges I faced in this sprint and how I overcame them.  

## 🔥 Challenges Faced  

### 1️⃣ **Prioritization Struggles: What Comes First?**  
One of the toughest challenges was **deciding what to prioritize** in the first sprint. Since the system requires multiple key features—booking management, user authentication, email notifications, and more—I found myself tempted to work on everything at once. However, that approach **contradicts Agile principles**, which emphasize delivering incremental value.  

Initially, I considered starting with **user accounts** since authentication is important, but I realized that without a booking system, the application wouldn’t serve its core purpose. Ultimately, I decided to **focus Sprint 1 on core booking functionality**—allowing users to select services, schedule appointments, and receive confirmation emails.  

- **Lesson Learned:** Prioritization isn’t just about importance; it’s about delivering **early value** to the end users. The MVP mindset helped me make this decision.  

### 2️⃣ **Time Estimation & Task Breakdown**  
Estimating effort was another major challenge. Since I was handling both **development and testing**, I had to determine how much time each task would take. Some tasks, like setting up the database schema, seemed simple at first but became more complex when I had to optimize relationships between tables and ensure data integrity.  

Another unexpected delay came from **email confirmation functionality**. I assumed it would take only a few hours, but setting up an email service, handling API errors, and formatting the email properly took much longer.  

- **Lesson Learned:** Task estimation should include **buffer time** for debugging, especially for features that involve third-party integration. I now realize that **technical tasks are rarely as straightforward as they seem** on paper.  

## 3️⃣ **Aligning Agile to a Solo Workflow**  
Agile methodologies typically involve **team collaboration**, stand-ups, and retrospectives. Since I don’t have a project manager or a development team, I had to **adapt Agile principles to a solo workflow**.  

- I track all my tasks using **GitHub Issues**, ensuring each sprint has a structured task breakdown.  
- I use **GitHub Milestones** to define sprint goals and track overall progress.  
- Instead of team stand-ups, I conduct **self-reviews** at the end of each sprint, reflecting on what went well and what needs improvement.  

However, without external feedback, it was easy to **overlook mistakes** or focus too much on a single aspect of the project. To counter this, I started reviewing the system **from a user’s perspective** at regular checkpoints.  

✅ **Lesson Learned:** Solo Agile development requires **self-discipline** and a **structured review process** to ensure steady progress. I now incorporate **mini-retrospectives** to evaluate what’s working.  

## 4️⃣ **Managing Motivation and Focus**  
Working alone means **there’s no external accountability**, making it challenging to stay motivated.  

- Some tasks, like writing documentation, felt tedious, while others, like coding, were more engaging.  
- To stay focused, I set **clear sprint goals**, track progress using **GitHub Milestones**, and celebrate small wins after completing major features.  

✅ **Lesson Learned:** Breaking work into **small, achievable tasks** and tracking them with **GitHub Issues and Milestones** keeps motivation high and ensures steady progress.  

## 🎯 **Final Thoughts**  
Adapting Agile to a solo project required **prioritization, structured tracking, and self-review mechanisms**. While challenging, using **GitHub Issues and Milestones for sprint tracking** and **conducting personal retrospectives** has helped me stay organized and accountable. Moving forward, I plan to refine my **task estimation skills** and **improve system testing strategies** to enhance project efficiency. 🚀  
## 🎯 Moving Forward  
1. **Improve Estimation Accuracy** – I will compare actual vs. estimated time to refine future estimates.  
2. **Maintain a Clear Sprint Focus** – Each sprint will have a well-defined goal to avoid distractions.  
3. **Implement Self-Reviews** – Reviewing the system from a fresh perspective will help catch usability issues.  

🚀**Despite these challenges, the sprint has been a valuable learning experience. Adapting Agile as a solo developer requires structure, but with continuous reflection, I can refine my approach and deliver a well-organized system.**  


