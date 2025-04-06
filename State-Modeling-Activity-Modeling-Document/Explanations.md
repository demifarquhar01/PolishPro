# Explanation 
This section provides detailed explanations of the **State Transition Diagrams** and  **Activity Diagrams** designed for the PolishPro: Nail Salon Booking System. 

## 1. 🧾 User Account
### 📝 Explanation
**Key States:**
- Registered
- LoggedIn
- LoggedOut
- ResettingPassword
- PasswordError

**Key Transitions:**
- Registered → LoggedIn : Successful login after password validation.
- Registered → PasswordError : Triggered when the password doesn’t meet the strong password policy.
- PasswordError → Registered : User goes back to correct their password.

**Mapping to Functional Requirements:**
- **FR-001**: Ensures secure user login and registration.
- **FR-003**: Supports password reset.
- **FR-004**: Enforces strong password policies during registration (minimum length, special characters, etc.).
  
---
## 2. 📆 Appointment
### 📝 Explanation
### Key States:
- **ViewingServices**: The user is browsing the list of available services. 
- **SelectingService**: The user selects a service they wish to book.
- **ChoosingTechnician**: The user selects a nail technician for the appointment.
- **PickingDateTime**: The user selects the date and time for their appointment.
- **CheckingAvailability**: The system checks if the selected time slot is available.
- **BookingConfirmation**: The system presents a confirmation screen showing the details of the appointment.
- **Booked**:The appointment is successfully booked, and the process is completed.

### Key Transitions:
- ViewingServices  →  SelectingService : Occurs when the user selects a service from the list.
- SelectingService  →  ChoosingTechnician : Happens when the user selects a technician for the chosen service.
- ChoosingTechnician  →  PickingDateTime : Occurs when the user selects a date and time for the appointment.
- PickingDateTime  → CheckingAvailability : Happens when the user submits their selected date and time for availability checking.
- CheckingAvailability  → BookingConfirmation : Occurs when the system finds the selected time slot available.
- CheckingAvailability  →  PickingDateTime : Happens when the selected time slot is unavailable, prompting the user to choose a new time.
- BookingConfirmation  →  Booked : Occurs when the user confirms their appointment after reviewing the booking details.
- BookingConfirmation  →  PickingDateTime : Happens when the user cancels the confirmation and goes back to select a new date and time.
- Booked  →  [*] : The process reaches the end state after the appointment is successfully booked.

## Functional Requirements
### FR-006: Service Display 💅
- The "ViewingServices" state allows users to browse the list of available services, which aligns with this requirement.

### FR-008: Appointment Booking 📅
- The "SelectingService," "ChoosingTechnician," "PickingDateTime," and "CheckingAvailability" states all represent the process of booking an appointment, from selecting a service to checking the availability and picking a date and time.

### FR-009: Booking Confirmation ✅
- The "BookingConfirmation" state corresponds to the requirement where users confirm their appointment, and the "Booked" state shows that the appointment has been successfully booked after confirmation.

---

## 3️. Appointment Rescheduling & Cancellation ❌
### 📝 Explanation
### Key States:
- **AppointmentBooked**: Client has a confirmed appointment.
- **Rescheduling**: Client initiates a reschedule.
- **CheckingAvailability**: System verifies if the new time slot is available.
- **Rescheduled**: Appointment successfully updated.
- **CancellationRequested**: Client initiates cancellation.
- **Canceled**: Appointment canceled if 24-hour policy is met.

### Key Transitions:
- AppointmentBooked → Rescheduling : Client initiates a reschedule request.
- Rescheduling → CheckingAvailability : System verifies available slots.
- AppointmentBooked → CancellationRequested : Client initiates a cancellation.
- CancellationRequested → Canceled : Allowed if within cancellation policy.
- CancellationRequested → AppointmentBooked : Rejected if policy not met.

## 📌 Functional Requirements Mapping
The diagram maps to **FR-005:  Appointment Rescheduling & Cancellation** as ensures Clients **must have an appointment already booked** to reschedule or cancel. The system **enforces a 24-hour cancellation policy**.

---

## 4️. Technician Schedule Management 📅
### 📝 Explanation
### Key States:
- **Unavailable**: The technician is not available for appointments.
- **SettingSchedule**: The technician is setting their availability.
- **Available**: The technician is available for appointments.
- **ViewingSchedule**: The technician is viewing their schedule.
- **UpdatingSchedule**: The technician is modifying their availability or schedule.
- **AssignedToAppointment**: The technician is assigned to a booked appointment.

### 🔁 Transitions:
- Unavailable  →  SettingSchedule : The technician starts setting their availability.
- SettingSchedule  →  Available : The technician's availability is saved, and they become available.
- Available  →  ViewingSchedule : The technician views their current schedule.
- ViewingSchedule  → Available : The technician returns to the available state after viewing their schedule.
- Available  →  UpdatingSchedule : The technician modifies their schedule.
- UpdatingSchedule  → Available : The changes to the schedule are saved, and the technician returns to available.
- Available  → Unavailable : The technician marks themselves as unavailable.
- Available  → AssignedToAppointment : The technician is assigned to a booked appointment.
- AssignedToAppointment  →  Available : The appointment is completed, and the technician returns to available.

### 📌 Functional Requirements Mapping
The diagram maps to **FR-011: Client Management 📋** as follows:
  - **ViewingSchedule:** Technicians can view their upcoming appointments, including client details, service type, date, and time, which aligns with the requirement to have access to a calendar or schedule view.
  - **UpdatingSchedule:** Technicians can modify their schedule, ensuring real-time updates to reflect any changes in bookings.
  - **AssignedToAppointment:** This state shows when an appointment is booked, helping technicians manage their upcoming appointments.
  - **Available and Unavailable:** These states ensure that technicians can set their availability and mark themselves as unavailable when needed, preventing double bookings and offering visibility into their schedule.
  - **Alerts:** While not explicitly represented, technicians would receive alerts when their schedule is updated or an appointment is modified, as part of real-time updates.
---

## 5️. Service Management ⚙
### 📝 Explanation
**Key States:**
- **NoServices**: No active services in the system.
- **AddingService**: Owner is adding a service.
- **ActiveService**: Service is live and bookable.
- **ModifyingService**: Owner is editing service details.
- **RemovingService**: Service is being removed.

### 🔁 Transitions 
- NoServices → AddingService : Owner begins adding a new service.
- AddingService → ActiveService : Service is published.
- ActiveService → ModifyingService : Owner updates service info.
- ModifyingService → ActiveService : Updates are saved.
- ActiveService → RemovingService : Owner deletes the service.
- RemovingService → NoServices : Service is removed from the system.

### 📌 Functional Requirements Mapping
The diagram maps to **FR-007: Service Management 💼** as follows:
  - **AddingService:** The admin (owner) can add a new service, which aligns with the ability to modify the service list.
  - **ModifyingService:** The admin can update service details (name, description, price, duration, and technicians), fulfilling the requirement to modify service information.
  - **ActiveService:** The service is live and available for booking, ensuring that any changes made by the admin are immediately visible on the booking page.
  - **RemovingService:** The admin can remove services, ensuring the service list is up to date.

---

## 6️. Email Notifications 📩
### 📝 Explanation
**Key States:**
- **PendingNotification**: Notification is queued for delivery.
- **Sending**: Notification is being sent.
- **Sent**: Notification successfully sent.
- **Failed**: Sending failed.
- **Retrying**: System is retrying to send.

### 🔁 Transitions
- PendingNotification → Sending : Triggered by an appointment or system update.
- Sending → Sent : Email delivered successfully.
- Sending → Failed : Sending attempt failed.
- Failed → Retrying : System triggers retry for failed attempt.
- Retrying → Sent : Retry successful.
- Retrying → Failed : Retry failed permanently.

### 📌 Functional Requirements Mapping
The diagram maps to **FR-010: Email Notifications 📧** as follows:
- The **"PendingNotification"** state addresses the process of preparing to send confirmation or reminder emails.
- The **"Sending"** state aligns with the system attempting to send notifications, such as appointment confirmations.
- The **"Sent"** state maps to successfully delivered success notifications.
- The **"Failed"** state represents email delivery failures, triggering a failure notification to the IT administrator.
- The **"Retrying"** state covers the retry process for failed emails and ensures notification delivery or failure logging.

---

## 7️. Client Preferences 🎯
### 📝 Explanation
### Key States:
- **PreferencesNotSet**: Client has not added any preferences yet.
- **PreferencesSet**: Initial preferences have been saved.
- **PreferencesUpdated**: Client has modified existing preferences.

### 🔁 Transitions Triggered by Events

- PreferencesNotSet → PreferencesSet : Client sets preferences.
- PreferencesSet → PreferencesUpdated : Client updates their preferences.
- PreferencesUpdated → PreferencesNotSet : Client clears all preferences.

### 📌 Functional Requirements Mapping
- **FR-012**: Nail technicians can view and check client preferences before providing services to tailor the experience.

---

# Activity Diagrams Explantion 

## 1.  User Registration, Login, and Password Reset
### 📝 Explanation
- **Covers:** Account creation, strong password enforcement, email verification, login attempts, and password reset via email.
- **Stakeholder Concern:** The system enforces strong passwords, ensures unique email addresses, and provides email verification to ensure security and ease of access for users.
- **System Logic:** The system validates user inputs, sends confirmation emails, handles login attempts, and allows password resets with strong password enforcement.

## 2.  User Role-Based Login & Access Control
### 📝 Explanation
- **Covers:** Role recognition and access control (Salon Owner, Nail Technician, Client).
- **Stakeholder Concern:** Ensures that each user has access to appropriate areas of the system based on their role, protecting sensitive data and ensuring a smooth user experience.
- **System Logic:** The system verifies the user's credentials, determines their role, and redirects them to the corresponding dashboard.

## 3. Appointment Booking
### 📝 Explanation
- **Covers:** Service selection, technician availability check, booking confirmation, real-time updates, and double-booking prevention.
- **Stakeholder Concern:** Ensures clients can easily book available services while preventing double-booking and keeping clients informed with confirmation emails.
- **System Logic:** The system checks technician availability, confirms booking details with the user, and sends a confirmation email upon successful booking.

## 4. Appointment Rescheduling or Cancellation
### 📝 Explanation
- **Covers:** 24-hour cancellation policy enforcement, availability checks for rescheduling, confirmation prompts, and email notifications.
- **Stakeholder Concern:** Ensures appointments are rescheduled or canceled within policy limits, and that clients receive email confirmation for any changes made.
- **System Logic:** The system checks for policy compliance, verifies technician availability for rescheduling, and sends confirmation emails after successful rescheduling or cancellation.

## 5. Client Management by Nail Technicians
### 📝 Explanation
- **Covers:** The system enables technicians to view appointments with client details, reschedule with client approval, receive alerts and confirmations for changes, update their availability or shifts, and see all updates reflected in real-time.
- **Stakeholder Concern:** Nail technicians can efficiently view and manage their upcoming appointments, reschedule bookings with client approval, and make updates to their availability. The system supports daily and weekly views and sends alerts if any appointment is changed or canceled.
- **System Logic:** Displays real-time schedules, allows rescheduling with client approval, updates technician availability, and sends alerts for any changes.

## 6. Service Management by Salon Owner/Admin
### 📝 Explanation
- **Covers:** Modify service name, description, price, duration, technician assignment, and real-time reflection on the booking page.
- **Stakeholder Concern:** Salon owners/admins can easily manage services, ensuring updates are reflected immediately for users and technicians.
- **System Logic:** The system allows admins to modify services, update them in real-time on the booking page, and notify users about any changes.
  
## 7. Client Preferences Management
### 📝 Explanation
- **Covers:** Saving preferences during booking, updating after appointments, and visibility for technicians.
- **Stakeholder Concern:** Ensures client preferences are captured, updated, and accessible for technicians to provide a personalized service.
- **System Logic:** The system saves client preferences during the booking process, displays them to the technician, and allows updates after appointments.

## 8.  Email Notifications
### 📝 Explanation
- **Covers:** Success/failure notifications for booking, rescheduling, cancellation, reminders, and failure logs to IT Admin.
- **Stakeholder Concern:** Ensures that both clients and administrators are notified of important actions, ensuring transparency and communication.
- **System Logic:** The system sends notifications based on the outcome of booking or modification actions, and logs failures to the IT admin for further investigation.

