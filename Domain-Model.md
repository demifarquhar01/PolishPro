# Domain Model

## 1. User

| **Entity**  | **Attributes**                       | **Methods**                                    | **Relationships**                         |
|-------------|--------------------------------------|------------------------------------------------|------------------------------------------|
| User        | userId, name, email, password       | register(), login(), logout(), resetPassword() | Inherited by Client, NailTechnician, SalonOwner, ITAdministrator |

### Business Rules:
- A user must have a unique email address.
- A user must have a valid password.

---

## 2. Client

| **Entity**  | **Attributes**                   | **Methods**                                    | **Relationships**                         |
|-------------|----------------------------------|------------------------------------------------|------------------------------------------|
| Client      | (inherits from User)    | bookAppointment(), cancelAppointment(), rescheduleAppointment() | Belongs to User, can book/cancel/reschedule Appointment, views Schedule |

### Business Rules:
- A client can only book one appointment at a time.
- A client must have a valid email for appointment notifications.

---

## 3. Nail Technician

| **Entity**  | **Attributes**                     | **Methods**                                     | **Relationships**                         |
|-------------|------------------------------------|-------------------------------------------------|------------------------------------------|
| NailTechnician | (inherits from User)   | viewSchedule(), updateSchedule()                | Inherited from User, manages Schedule, views ClientPreference |

### Business Rules:
- A nail technician can only manage their own schedule.
- A nail technician can view client preferences associated with their appointments.

---

## 4. Appointment

| **Entity**   | **Attributes**                           | **Methods**                                      | **Relationships**                          |
|--------------|------------------------------------------|--------------------------------------------------|--------------------------------------------|
| Appointment  | appointmentId, dateTime, status          | book(), cancel(), reschedule(), confirm()         | Associated with Client, NailTechnician, Service, EmailNotification, Reschedule, Cancel |

### Business Rules:
- An appointment must be linked to one service.
- An appointment cannot overlap with another appointment for the same client.
- Appointment status must be confirmed before being scheduled.

---

## 5. Service

| **Entity**   | **Attributes**                            | **Methods**                                      | **Relationships**                          |
|--------------|-------------------------------------------|--------------------------------------------------|--------------------------------------------|
| Service      | serviceId, name, description, duration, price, isActive | modifyService(), viewService()                   | Belongs to SalonOwner, linked to Appointment |

### Business Rules:
- A service must have a name and price.
- A service must be active before being offered to clients.

---

## 6. Schedule

| **Entity**  | **Attributes**                             | **Methods**                                       | **Relationships**                             |
|-------------|--------------------------------------------|---------------------------------------------------|----------------------------------------------|
| Schedule    | scheduleId, availableSlots (List<DateTime>) | updateSchedule(), viewAssignedAppointments        | Associated with NailTechnician, Appointment |

### Business Rules:
- A schedule can only contain available slots for a specific technician.
- Schedule changes must be communicated to the client if an appointment is affected.

---

## 7. Email Notification

| **Entity**      | **Attributes**                             | **Methods**                                   | **Relationships**                          |
|-----------------|--------------------------------------------|-----------------------------------------------|--------------------------------------------|
| EmailNotification | notificationId, recipientEmail, subject, message, status, type | sendNotification(), scheduleReminder(), handleFailure() | Associated with Appointment, reported to ITAdministrator |

### Business Rules:
- An email must be sent for every appointment booking, reschedule, and cancellation.
- Email delivery failures must be escalated to the ITAdministrator.

---

## 8. IT Administrator

| **Entity**      | **Attributes**                             | **Methods**                                   | **Relationships**                          |
|-----------------|--------------------------------------------|-----------------------------------------------|--------------------------------------------|
| ITAdministrator | (inherits from User)                   | handleEmailFailure()                          | Inherited from User, oversees EmailNotification failures |

### Business Rules:
- IT Administrator is responsible for managing email failures.
- IT Administrator handles critical issues with system notifications, especially failures in sending email alerts.

---

## 9. Reschedule

| **Entity**   | **Attributes**                           | **Methods**                                      | **Relationships**                          |
|--------------|------------------------------------------|--------------------------------------------------|--------------------------------------------|
| Reschedule   | rescheduleId, oldDateTime, newDateTime, reason | confirmReschedule()                            | Linked to Appointment |

### Business Rules:
- A reschedule request must include the old and new appointment date/time.
- The reason for the reschedule must be provided.
- Rescheduling must be confirmed before changes are made to the appointment.

---

## 10. Cancel

| **Entity**   | **Attributes**                           | **Methods**                                      | **Relationships**                          |
|--------------|------------------------------------------|--------------------------------------------------|--------------------------------------------|
| Cancel       | cancelId, cancellationReason, cancelDateTime | confirmCancellation()                           | Linked to Appointment |

### Business Rules:
- A cancellation request must include the reason for cancellation.
- The cancellation must be confirmed before the appointment is removed from the schedule.
- Cancellations must be logged for reporting purposes.

---

## Relationships Summary:
- **Client** can **book**, **cancel**, or **reschedule** an **Appointment**.
- **NailTechnician** manages their **Schedule** and views **Client Preferences**.
- **SalonOwner** modifies **Service** offerings.
- **Appointment** is linked to **Service** and is associated with **Client** and **Nail Technician**.
- **EmailNotification** is triggered by actions on **Appointments** and escalated to the **IT Administrator** in case of failure.
- **ITAdministrator** oversees the failure reports generated by **Email Notification** and handles escalations.
- **Reschedule** and **Cancel** are associated with **Appointments** to track changes in the appointment status.

---

## Business Rules:
- **Clients** can only book one appointment at a time.
- **Appointments** cannot overlap for a client.
- **NailTechnicians** must manage their own schedules and view client preferences.
- **SalonOwner** has the power to add or remove services from the system.
- **Appointments** must be confirmed before they can be scheduled.
- **Email notifications** must be sent for every change in appointment status (booking, rescheduling, cancellation).
- **IT Administrator** must manage email notification failures and escalate unresolved issues.
- **Reschedules** and **Cancellations** must be confirmed and appropriately logged.
