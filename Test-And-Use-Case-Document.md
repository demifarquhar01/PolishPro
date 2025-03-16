## PolishPro: Test and Use Case Development

## Use Case as an image in marmaid js:

 ```mermaid
%%{init: {'theme': 'default'}}%%
graph LR

%% System Boundary
subgraph "📌 PolishPro: Booking Nail System"
  
  %% Authentication Section
  RegisterAccount["📝 Register Account"]
  Login["🔑 Login"]
  ResetPassword["🔄 Reset Password"]
  ValidateAuth["✔️ Validates User Authentication"]

  %% Booking Section
  UpdateSchedule["📅 Update Personal Schedule"]
  ViewServices["👀 View Services"]
  ViewAppointments["📄 View Assigned Appointments"]
  BookAppointment["📆 Book Appointment"]
  CancelAppointment["❌ Cancel/Reschedule Appointment"]

  %% Management Section
  ModifyServices["⚙️ Modify Display of Services"]
  ManageTimeSlots["⏳ Manage Time Slots and Days"]
  HandleEmailFailures["📨 Handle Email Failures"]

  %% Notifications Section
  EmailNotifications["📩 Email Notification and Reminders"]
  ConfirmAppointment["✅ Appointment Confirmation Message"]
  CheckClientPreferences["📌 Check Client Preferences"]

end 

%% Actors
Client(["👤 Client"]) 
SalonOwner(["👤 Salon Owner/Manager"]) 
ITAdmin(["👤 IT Administrator"]) 
AuthService(["🔒 Authentication Service"])
EmailService(["📧 Email Service"])
NailTech(["💅 Nail Technician"])

%% Relationships
Client -->RegisterAccount
Client -->Login
Client -->ViewServices
Client -->BookAppointment
Client -->CancelAppointment

SalonOwner -->ModifyServices
SalonOwner --> ManageTimeSlots

ITAdmin -->HandleEmailFailures

AuthService -->|Handles| ValidateAuth

EmailService -->|Sends| EmailNotifications

NailTech-->Login
NailTech -->CheckClientPreferences
NailTech-->ViewAppointments
NailTech--> UpdateSchedule

%% Workaround for UML "Includes" and "Extends"
RegisterAccount -.->|Includes| ValidateAuth
Login-.->|Includes| ValidateAuth
Login -.->|Extends| ResetPassword
BookAppointment -.->|Includes| ConfirmAppointment
BookAppointment -.->|Includes| EmailNotifications
CancelAppointment -.->|Includes| EmailNotifications
BookAppointment -.->|Includes| CheckClientPreferences
```

 ## Use Case Diagram:
 ![image_alt](https://github.com/demifarquhar01/PolishPro/blob/f0b5683fbcaa0dff583fc59b8d42ce44a9055a39/usecase.drawio%20(2).png)

## Key Actor And Their Roles 
1. **Client 🧑 :** A user who registers for an account, views services, books appointments, reschedules/cancels appointments, and receives email notifications about appointments.
2. **Nail Technician 💅:** Manages their personal schedule, views assigned appointments, and checks client preferences for a personalized experience.
3. **Salon Owner/ Manager 👩‍💼:** Manages the salon’s service offerings, modifies available services, and schedules time slots for appointments.
4. **User Authentication Service🔒:** Validates user credentials for login and handles password reset requests.
5. **Email Notification Service📧:** Sends appointment confirmations and reminders to clients.
6. **IT Administrator 👨‍💻:** Manages and troubleshoots email failures.

## Relationships Between Actors and Use Cases
- The Client actor can register an account with Register Account use case, which includes user authentication validation use case to ensure secure access and accurate client information.
- The Client actor can log in to the system with Login use case, which includes user authentication validation use case to ensure secure access to personal information and bookings.
- The Client actor can reset their password if forgotten, which extends the login process to help recover access and maintain usability.
- The Client actor can view available services use case, allowing them to make informed decisions and reducing the need for direct inquiries, addressing convenience concerns.
- The Client actor can initiate the Book Appointment use case, which includes the Appointment Confirmation Message and Email Notification and Reminders use cases. This supports the Salon Owner/Manager’s concern for ensuring efficient booking management and reducing client no-shows through automated reminders.
- The Client actor can initiate the Cancel/Reschedule Appointment use case, which includes an email notification and reminder system. This supports the Salon Owner/Manager’s concern for reducing no-shows and scheduling conflicts.
- A Nail Technician actor can initiate the Update Personal Schedule use case to manage their availability, ensuring efficient time management and preventing overbooking. This supports the concern of maintaining smooth salon operations and improving customer satisfaction.
- A Nail Technician actor can initiate the View Assigned Appointments use case and Check Client Preferences use cases, which helps them manage their schedule efficiently and stay prepared for upcoming appointments. This addresses concerns about time management, service organization, and the ability to view schedules and client preferences for better appointment management and service quality.
- The Salon Owner/ Manager can initiate the Modify Display of Services use case to update the services offered, ensuring accurate and appealing options for customers. This addresses concerns about service clarity and enhances customer experience. 
- The Salon Owner/ Manager can initiate the Manage Time Slots and Days for Appointments use case to optimize scheduling, prevent double bookings, and reduce administrative workload.
- The Email Service supports the Appointment Confirmation Message use case, ensuring clients receive booking confirmations, which enhances communication and reduces scheduling confusion. It also handles the Cancel/Reschedule Appointment use case by sending updates to clients and staff, improving coordination.
- The Authentication Service supports the Register Account use case by securely handling new client registrations and the Validate User Authentication use case by ensuring only authorized users can log in. This addresses security concerns by preventing unauthorized access and protecting user data.
- The IT Administrator actor can initiate the Handle Email Failures use case, ensuring failed appointment notifications are managed properly. This supports system uptime and security by maintaining reliable communication and preventing missed notifications.

---

- # 📌 Use Case Specifications  

## 📝 1. Register Account  
**Actor:** Client  
**Precondition:** Client is not registered.  
**Postcondition:** Client's account is created and stored in the system.  

### 🔹 Basic Flow:  
1️⃣ Client enters registration details (name, email, password).  
2️⃣ System validates the input.  
3️⃣ System registers the client.  
4️⃣ System sends a confirmation email.  
5️⃣ Client receives confirmation email and verifies the account.  

### 🔹 Alternative Flows:  
⚠️ If details are invalid, the system prompts for correction.  
⚠️ If email sending fails, system notifies IT Administrator.  

---  

## 🔑 2. Login  
**Actors:** Client, Nail Technician  
**Precondition:** User has an account.  
**Postcondition:** User is logged into the system.  

### 🔹 Basic Flow:  
1️⃣ User enters email and password.  
2️⃣ System validates credentials.  
3️⃣ System grants access.  

### 🔹 Alternative Flows:  
⚠️ If credentials are incorrect, display an error message to retry or provide the option to reset the password.  

---  

## 🔐 3. Reset Password  
**Actors:** Client, Nail Technician  
**Precondition:** User has forgotten their password.  
**Postcondition:** User can log in with a new password.  

### 🔹 Basic Flow:  
1️⃣ User requests a password reset.  
2️⃣ System sends a password reset link via email.  
3️⃣ User sets a new password.  
4️⃣ System updates the password.  

### 🔹 Alternative Flows:  
⚠️ If email fails to send, system retries and logs failure.  
⚠️ If password does not meet security criteria, prompt for a stronger password.  

---  

## 🔍 4. Validate User Authentication  
**Actor:** Authentication Service  
**Precondition:** User attempts login or registration.  
**Postcondition:** User is authenticated or denied access.  

### 🔹 Basic Flow:  
1️⃣ User submits credentials (email & password for login, or registration details for signup).  
2️⃣ System validates input against stored records.  
3️⃣ If valid, system grants access or completes registration.  
4️⃣ If invalid, system denies access and displays an error message.  

### 🔹 Alternative Flows:  
⚠️ If input data is invalid (e.g., incorrect password, already registered email), system prompts for correction.  
⚠️ If authentication fails multiple times, system may temporarily lock the account.  

---  

## 💅 5. View Services  
**Actor:** Client  
**Precondition:** The user must be authenticated and logged in.  
**Postcondition:** List of available services is displayed.  

### 🔹 Basic Flow:  
1️⃣ Client navigates to the services page.  
2️⃣ System retrieves and displays services.  

### 🔹 Alternative Flows:  
⚠️ If service list fails to load, display an error message.  

---  

## 📅 6. Book Appointment  
**Actor:** Client  
**Precondition:** Client is logged in.  
**Postcondition:** Appointment is booked and confirmation is sent.  

### 🔹 Basic Flow:  
1️⃣ Client navigates to the booking page.  
2️⃣ Client selects a service.  
3️⃣ Client selects a date and time.  
4️⃣ System checks the availability of Nail Technicians.  
5️⃣ System books the appointment.  
6️⃣ System displays a confirmation message.  
7️⃣ System sends a confirmation email.  

### 🔹 Alternative Flows:  
⚠️ System notifies the client that the slot is unavailable and prompts them to choose another date/time.  
⚠️ System displays available dates/times for the selected Nail Technician.  

---  

## 📩 7. Appointment Confirmation  
**Actor:** System  
**Precondition:** Appointment is successfully booked.  
**Postcondition:** Client receives confirmation.  

### 🔹 Basic Flow:  
1️⃣ System generates a confirmation message.  
2️⃣ System sends the confirmation via email.  

### 🔹 Alternative Flows:  
⚠️ If email fails, system retries and logs the issue.  

---  

## ❌ 8. Cancel/Reschedule Appointment  
**Actor:** Client  
**Precondition:** The client is logged in, has an existing appointment, and the appointment is more than 48 hours away.  
**Postcondition:** Appointment is canceled or rescheduled.  

### 🔹 Basic Flow:  
1️⃣ Client views their booked appointments.  
2️⃣ Client selects an appointment.  
3️⃣ Client selects either "Cancel" or "Reschedule."  
4️⃣ System checks if the appointment is within 24 hours away:  
   - ✅ If yes, proceed to Step 5.  
   - ❌ If no, display an error message preventing changes.  
5️⃣ If rescheduling, client selects a new date and time.  
6️⃣ System updates the appointment.  
7️⃣ System sends an email confirmation of the change.  

### 🔹 Alternative Flows:  
⚠️ If the time slot is unavailable, suggest alternatives.  
⚠️ If email fails, display a confirmation message on the screen instead.  

---  

## 📢 9. Email Notifications and Reminders  
**Actor:** Email Service  
**Precondition:** Appointment is scheduled.  
**Postcondition:** Client receives reminders.  

### 🔹 Basic Flow:  
1️⃣ System sends a confirmation email notification of appointment details.  
2️⃣ System sends rescheduling and cancellation emails of appointment details.  
3️⃣ System schedules reminder notifications.  
4️⃣ System sends reminders at the set time.  

### 🔹 Alternative Flows:  
⚠️ If email fails, system retries and logs failure.  

---  

## 📋 10. View Client Preferences  
**Actor:** Nail Technician  
**Precondition:** Nail Technician is logged in with a specific role.  
**Postcondition:** Only client preferences are displayed.  

### 🔹 Basic Flow:  
1️⃣ Nail Technician navigates to the client profile.  
2️⃣ System retrieves and displays preferences according to their bookings.  

### 🔹 Alternative Flows:  
⚠️ If data is unavailable, system displays an error message.  

---  

## 📆 11. View Assigned Appointments  
**Actor:** Nail Technician  
**Precondition:** Nail Technician is logged in with a specific role.  
**Postcondition:** Assigned appointments are displayed for the signed-in Nail Technician.  

### 🔹 Basic Flow:  
1️⃣ Nail Technician logs in.  
2️⃣ Selects ‘View Assigned Appointments.’  
3️⃣ System retrieves and displays assigned appointments.  

### 🔹 Alternative Flows:  
⚠️ No appointments found. Display “No appointments available” message.  

---  

## ⚙️ 12. Manage Time Slots & Days  
**Actor:** Salon Owner/Manager  
**Precondition:** Logged in as admin.  
**Postcondition:** Time slots updated.  

### 🔹 Basic Flow:  
1️⃣ Admin user navigates to scheduling settings.  
2️⃣ Updates time slots.  
3️⃣ System saves and applies changes.  

### 🔹 Alternative Flows:  
⚠️ If update fails, display an error message.  
⚠️ Emergency Override: If a technician needs a last-minute change due to a scheduling conflict, the manager can override restrictions (e.g., bypassing the 24-hour cancellation rule).

---  

## ✏️ 13. Modify Services  
**Actor:** Salon Owner/Manager  
**Precondition:** Logged in as admin.  
**Postcondition:** Services list is updated.  

### 🔹 Basic Flow:  
1️⃣ Admin user navigates to the service settings page.  
2️⃣ Updates service details.  
3️⃣ System applies changes.  

### 🔹 Alternative Flows:  
⚠️ If changes fail, display an error message.  

---  

## 📧 14. Manage Email Failure  
**Actor:** IT Administrator  
**Precondition:** Email failure detected.  
**Postcondition:** Email issue resolved or logged.  

### 🔹 Basic Flow:  
1️⃣ System detects failed email.  
2️⃣ Attempts auto-resend.  
3️⃣ If still failing, alerts IT Admin.  
4️⃣ IT Admin investigates the issue.  

### 🔹 Alternative Flows:  
⚠️ If the issue persists, escalate for manual intervention.  

---

# Test Case Development

| Test Case ID | Requirement ID | Description | Steps | Expected Result | Actual Result | Status (Pass/Fail) |
|-------------|---------------|-------------|-------|-----------------|---------------|--------------------|
| TC-001 | FR-001 | User registers an account | 1. Enter details. 2. Click "Register" | Account is created successfully | | |
| TC-002 | FR-002 | User logs in with valid credentials | 1. Enter username & password. 2. Click "Login" | User is logged in successfully | | |
| TC-003 | FR-003 | User resets password | 1. Go to login page. 2. Click "Forgot Password" 3. Enter email 4. Click "Reset Password" | Password reset email is sent | | |
| TC-004 | FR-004 | User views available services | 1. Log in to the system. 2. Navigate to "Services" page | System retrieves and displays available services  | | |
| TC-005 | FR-005 | User books an appointment |  1. Log in to the system. 2. Navigate to the "Book Appointment" section. 3. Select a service from the list. 4. Choose a preferred date from the available calendar. 5. Choose an available time slot based on the selected date. 6. Select a nail technician from the list. 7. The system prompts a confirmation message: "Do you want to confirm this booking?" with "Yes" or "No" options. | Appointment is successfully booked, and a confirmation email is sent to the user.  | | |
| TC-006 | FR-006 | User cancels an appointment | 1. Log in to the system. 2. Go to "My Appointments," 3. Select an appointment, 4. Click "Cancel," 5. If more than 24 hours away, proceed; otherwise, show restriction message, 6. Confirm or cancel.| Appointment is successfully canceled, and a cancel notification is sent via email.| | |
| TC-007 | FR-007 | User reschedules an appointment | 1. Log in to the system. 2. Go to "My Appointments," 3. Select an appointment, 4. Click "Reschedule," 5. If more than 24 hours away, proceed; otherwise, show restriction message, 6. Choose a new date and time. 7. Confirm or cancel. | Appointment is successfully rescheduled, and email sent out of reschedule date. | | |
| TC-008 | FR-008 | Nail technician updates schedule |1. Log in to the system. 2. Navigate to the "My Schedule" section. 3. Select a date to update the schedule. 4. Modify existing time slots or insert new availability. 5. Click "Save" and confirm changes by selecting "Yes."| Updated schedule is successfully saved and reflected in the system | |
| TC-009 | FR-009 | Nail technician views assigned appointments |1. Log in to the system. 2. Navigate to the "Appointments" section. 3. The system retrieves and displays a list of assigned appointments. 4. Each appointment entry includes details such as client name, service type, date, and time.| Assigned appointments are successfully displayed, showing relevant details.  | | |
| TC-010 | FR-010 | Salon owner modifies displayed services | 1. Navigate to the "Manage Services" section. 2. Click on "Add Service" and enter service details (name, description, price, duration). 3. Click "Save" to add the service. 4. Click on an existing service and modify details (edit name, price, duration, description). 5. Click "Save" to update the service. 6. Click "Delete" on an existing service and confirm the deletion. |  Changes are reflected in the system, with new, updated, or removed services displayed correctly. | | |
| TC-011 | FR-011 | Salon owner manages time slots | 1. Navigate to the "Manage Time Slots" section. 2. Click "Add Time Slot" and select a date, start time, and end time. 3. Click "Save" to add the new time slot. 4. Click on an existing time slot to modify details (adjust time, change availability, or assign a technician). 5. Click "Save" to update the changes. 6. Click "Delete" on an existing time slot and confirm deletion. | Changes are updated in the booking system, ensuring new, modified, or removed time slots appear correctly. | | |

# Non-Functional Requirements Test Cases

### Usability  
- **Usability Test:** Ensures the system meets **WCAG 2.1 compliance** by allowing full navigation via keyboard shortcuts and ensuring compatibility with screen readers.  
- **Responsive Design Test:** Confirms the system adjusts dynamically across **desktop, tablet, and mobile screens** for optimal usability.  
- **Cross-Platform Deployment Test:** Verifies the system runs smoothly on **Windows, Linux, and iOS-based devices** without OS-specific issues.  
- **UI Consistency & Readability Test:** Ensures **font readability, contrast levels, and hover effects** provide an intuitive and visually consistent user experience.  
- **Language Support Test:** Confirms the system supports only **English** and does not allow switching to other languages.  

### Maintainability  
- **Maintainability Test:** Ensures the code follows a **modular structure**, allowing for **easy updates and component reusability**.  
- **API Documentation Test:** Verifies **API endpoints and responses** align with the documentation for accuracy and completeness.  

### Scalability  
- **Scalability Test:** Simulates **1,500 concurrent users** booking appointments to ensure the system handles high traffic without performance degradation.  
- **Horizontal Scaling Test:** Adds additional **servers or database instances** to confirm the system scales efficiently under increased load.  

### Security  
- **Security Test:** Ensures **AES-256 encryption** is applied to sensitive data and verifies secure transmission over **HTTPS**.  
- **User Activity Logs Test:** Confirms that **user actions, timestamps, and access control details** are logged securely and accessible only to authorized users.  

### Performance  
- **Performance Test:** Simulates **peak traffic loads** to monitor CPU and memory usage, ensuring the system remains responsive.  
- **Search Response Time Test:** Simulates **1,000 concurrent users** to verify that search results return within **3 seconds**.  

### Availability  
- **System Uptime Test:** Tracks uptime over **30 days** to ensure system availability remains above **99.9%**.  
- **Data Backup & Recovery Test:** Triggers a **full system backup** and simulates data loss to confirm recovery within **24 hours**.  

---

# 🚀 Challenges in Translating Requirements to Use Cases & Test Cases  

Developing **use cases and test cases** for the **PolishPro Nail Salon Booking System** presented several challenges in ensuring system functionality aligned with real-world business operations. While functional requirements outlined **appointment booking, cancellations, and rescheduling**, translating them into **detailed use cases and test cases** exposed gaps that required refinement.
## ⚡ Key Challenges  
### 📌 Defining Functional Boundaries  
- The initial requirements broadly mentioned **cancellations and rescheduling** under appointment booking but did not define them as **standalone features**.
- When creating test cases, this led to **unclear validation criteria**, making it difficult to test edge cases like last-minute cancellations.
- To address this, **cancellation and rescheduling** were explicitly documented as functional requirements, ensuring the test cases reflected business needs.  

### 📅 Managing Scheduling Constraints  
- Initially, test cases allowed **unrestricted cancellations and reschedules**, which could disrupt salon operations.
- To **align with business needs**, a **24-hour restriction** was introduced, preventing last-minute changes while allowing flexibility.
- The test cases were adjusted to check:  
  ✅ If cancellations within **24 hours** were blocked.  
  ✅ If the system **displayed an appropriate message** to user.  

### 🔔 Email Notification 
- The **original requirements** focused primarily on **clients** cancel/reschedules appointments, but **nail technicians and salon managers** also needed visibility.  
- To ensure operational efficiency, test cases were revised to validate:  
  ✅ **Technicians receive notifications** about cancellations or reschedules.  
  ✅ **Managers can override restrictions** in emergencies, which falls under the use case of the **Manage time slots and days for appointments**

### 🛠️ Writing Effective Test Cases  
- Early test cases only checked if a **cancellation request was successful**, without verifying system constraints.  
- Improvements included:  
  ✅ Ensuring cancellations **within the restricted period** were blocked.  
  ✅ Checking whether the **system logged changes** for accountability.  
  ✅ Confirming users received **confirmation emails or reminders**.  
---  
# 🔍 Challenges in Defining Non-Functional Requirements  
Defining **non-functional requirements** was difficult because they often lacked clear, measurable criteria and required careful consideration of real-world scenarios.  

### 🎨 Usability  
✅ Establishing a **quantifiable success metric** (e.g., “90% of users should book an appointment within three clicks”) was challenging since usability depends on subjective user experience.  
✅ Translating **user expectations** into specific, testable requirements required iterative feedback and refinement.  

### 🚀 Performance & Scalability  
✅ Defining realistic **performance benchmarks** (e.g., response time under three seconds) required research into industry standards and simulated load testing scenarios.  
✅ Predicting **scalability needs** was complex, as future growth and varying traffic loads were uncertain.  

### 🔐 Security  
✅ Specifying security requirements went beyond functional access controls, requiring input from security specialists to define **penetration testing parameters** and **risk mitigation measures**.  
✅ Determining **acceptable risk levels** for threats like brute-force attacks and data breaches was subjective and required balancing security with usability.  
### 🛠️ Maintainability  
✅ Writing **clear, enforceable requirements** for code maintainability was difficult since it involved subjective factors like **code readability and modularity**.  
✅ Ensuring automated tests covered all critical scenarios without becoming overly complex required careful test design.  

### Overall
Both functional and non-functional requirements posed challenges in defining clear, testable criteria. Refinements were necessary to ensure alignment with real-world business operations, improve system usability, and enhance security and performance. 
