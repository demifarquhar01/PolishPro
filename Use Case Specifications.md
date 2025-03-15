# 📌 Use Case Specifications  

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

