# Use Case Specifications

## 1. Use Case: Register Account
**Actor:** Client  
**Precondition:** Client is not registered.  
**Postcondition:** Client's account is created and stored in the system.  

### Basic Flow:
1. Client enters registration details (name, email, password).
2. System validates the input.
3. System registers the client.
4. System sends a confirmation email.
5. Client receives confirmation email and verifies the account.

### Alternative Flows:
- If details are invalid, the system prompts for correction.
- If email sending fails, system notifies IT Administrator.

---

## 2. Use Case: Login
**Actors:** Client, Nail Technician  
**Precondition:** User has an account.  
**Postcondition:** User is logged into the system.  

### Basic Flow:
1. User enters email and password.
2. System validates credentials.
3. System grants access.

### Alternative Flows:
- If credentials are incorrect, display an error message to retry or provide the option to reset the password.

---

## 3. Use Case: Reset Password
**Actors:** Client, Nail Technician  
**Precondition:** User has forgotten their password.  
**Postcondition:** User can log in with a new password.  

### Basic Flow:
1. User requests a password reset.
2. System sends a password reset link via email.
3. User sets a new password.
4. System updates the password.

### Alternative Flows:
- If email fails to send, system retries and logs failure.
- If password does not meet security criteria, prompt for a stronger password.
---

## 4. Use Case: Validate User Authentication
**Actor:** Authentication Service  
**Precondition:** User attempts login or registration.  
**Postcondition:** User is authenticated or denied access.  

### Basic Flow:
1. User submits credentials (email & password for login, or registration details for signup).
2. System validates input against stored records.
3. If valid, system grants access or completes registration.
4. If invalid, system denies access and displays an error message.

### Alternative Flows:
- If input data is invalid (e.g., incorrect password, already registered email), system prompts for correction.
- If authentication fails multiple times, system may temporarily lock the account.


---

## 5. Use Case: View Services
**Actor:** Client  
**Precondition:** The user must be authenticated and logged in.  
**Postcondition:** List of available services is displayed.  

### Basic Flow:
1. Client navigates to the services page.
2. System retrieves and displays services.

### Alternative Flows:
- If service list fails to load, display error message.

---

## 6. Use Case: Book Appointment
**Actor:** Client  
**Precondition:** Client is logged in.  
**Postcondition:** Appointment is booked and confirmation is sent.  

### Basic Flow:
1. Client navigates to the booking page.
2. Client selects a service.
3. Client selects a date and time.
4. System checks the availability of Nail Technicians.
5. System books the appointment.
6. System displays a confirmation message.
7. System sends a confirmation email of the booked appointment.

### Alternative Flows:
- System notifies the client that the slot is unavailable and prompts them to choose another date/time.
- System displays available dates/times for the selected Nail Technician.

---

## 7. Use Case: Appointment Confirmation
**Actor:** System  
**Precondition:** Appointment is successfully booked.  
**Postcondition:** Client receives confirmation.  

### Basic Flow:
1. System generates a confirmation message.
2. System sends the confirmation via email.

### Alternative Flows:
- If email fails, system retries and logs the issue.

---

## 8. Use Case: Cancel/Reschedule Appointment
**Actor:** Client  
**Precondition:** Client is logged in and has an existing appointment.  
**Postcondition:** Appointment is canceled or rescheduled.  

### Basic Flow:
1. Client views booked appointments.
2. Client selects an appointment.
3. Client selects either "Cancel" or "Reschedule."
4. If rescheduling, client selects a new date and time.
5. System updates the appointment.
6. System sends an email confirmation.

### Alternative Flows:
- If the time slot is unavailable, suggest alternatives.
- If email fails, display a confirmation message on the screen instead.

---

## 9. Use Case: Email Notifications and Reminders
**Actor:** Email Service  
**Precondition:** Appointment is scheduled.  
**Postcondition:** Client receives reminders.  

### Basic Flow:
1. System sends a confirmation email notification of appointment details.
2. System sends rescheduling and cancellation emails of appointment details.
3. System schedules reminder notifications.
4. System sends reminders at the set time.

### Alternative Flows:
- If email fails, system retries and logs failure.

---

## 10. Use Case: View Client Preferences
**Actor:** Nail Technician  
**Precondition:** Nail Technician is logged in with a specific role.  
**Postcondition:** Only client preferences are displayed.  

### Basic Flow:
1. Nail Technician navigates to the client profile.
2. System retrieves and displays preferences according to their bookings.

### Alternative Flows:
- If data is unavailable, system displays an error message.

---

## 11. Use Case: View Assigned Appointments
**Actor:** Nail Technician  
**Precondition:** Nail Technician is logged in with a specific role.  
**Postcondition:** Assigned appointments are displayed for the signed-in Nail Technician.  

### Basic Flow:
1. Nail Technician logs in.
2. Selects ‘View Assigned Appointments.’
3. System retrieves and displays assigned appointments.

### Alternative Flows:
- No appointments found.
- Display “No appointments available” message.

---

## 12. Use Case: Manage Time Slots & Days
**Actor:** Salon Owner/Manager  
**Precondition:** Logged in as admin.  
**Postcondition:** Time slots updated.  

### Basic Flow:
1. Admin user navigates to scheduling settings.
2. Updates time slots.
3. System saves and applies changes.

### Alternative Flows:
- If update fails, display an error message.

---

## 13. Use Case: Modify Services
**Actor:** Salon Owner/Manager  
**Precondition:** Logged in as admin.  
**Postcondition:** Services list is updated.  

### Basic Flow:
1. Admin user navigates to the service settings page.
2. Updates service details.
3. System applies changes.

### Alternative Flows:
- If changes fail, display an error message.

---

## 14. Use Case: Manage Email Failure
**Actor:** IT Administrator  
**Precondition:** Email failure detected.  
**Postcondition:** Email issue resolved or logged.  

### Basic Flow:
1. System detects failed email.
2. Attempts auto-resend.
3. If still failing, alerts IT Admin.
4. IT Admin investigates the issue.

### Alternative Flows:
- If the issue persists, escalate for manual intervention.
