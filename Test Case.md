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

| Test Case ID | Requirement ID | Description | Steps | Expected Result | Actual Result | Status (Pass/Fail) |
|-------------|---------------|-------------|-------|-----------------|---------------|--------------------|
| **Usability & Accessibility** |
| TC-NF-001 | NFR-001 | WCAG 2.1 Compliance | 1. Navigate the system using keyboard shortcuts. 2. Test screen reader compatibility. | System fully navigable using keyboard and screen readers function correctly. | | |
| TC-NF-002 | NFR-002 | Responsive Design | 1. Open the system on desktop, tablet, and mobile. 2. Check UI elements for proper scaling. | Layout adjusts dynamically, ensuring usability across devices. | | |
| **Cross-Platform Deployment** |
| TC-NF-003 | NFR-003 | Multi-OS Compatibility | 1. Deploy system on Windows, Linux, and iOS-based devices. | System runs smoothly without OS-specific issues. | | |
| **User Interface** |
| TC-NF-004 | NFR-004 | UI Consistency & Readability | 1. Verify navigation ease. 2. Check font readability, contrast, and hover effects. | Interface is intuitive, readable, and visually consistent. | | |
| **Language Support** |
| TC-NF-005 | NFR-005 | English Language Only | 1. Review UI content. 2. Attempt to change language settings. | System only supports English; no option for other languages. | | |
| **Maintainability** |
| TC-NF-006 | NFR-006 | Modular Codebase | 1. Inspect code for modular structure. 2. Review component reusability. | Code is structured into reusable modules with documentation. | | |
| TC-NF-007 | NFR-007 | API Documentation | 1. Review API documentation for completeness. 2. Test API responses against documentation. | API documentation is clear, with correct endpoints and response formats. | | |
| **Scalability** |
| TC-NF-008 | NFR-008 | Concurrent Users (1,500) | 1. Simulate 1,500 users booking appointments. 2. Measure response time. | System handles 1,500 users without performance degradation. | | |
| TC-NF-009 | NFR-009 | Horizontal Scaling | 1. Add additional servers or database instances. 2. Check system stability under increased load. | System scales horizontally without issues. | | |
| **Security** |
| TC-NF-010 | NFR-010 | Data Encryption (AES-256) | 1. Inspect encryption of sensitive data. 2. Verify secure HTTPS transmission. | All sensitive data is encrypted and transmitted securely. | | |
| TC-NF-011 | NFR-011 | User Activity Logs | 1. Check logs for user actions, timestamps, and access control. | Logs contain necessary security details and are restricted to authorized users. | | |
| **Performance** |
| TC-NF-012 | NFR-012 | Fast Booking & Interactions | 1. Book, cancel, and modify appointments. | Actions complete within ≤2 seconds. | | |
| TC-NF-013 | NFR-013 | Search Response Time | 1. Search for services and bookings. | Results return within ≤3 seconds. | | |
| TC-NF-014 | NFR-014 | Server Resource Optimization | 1. Simulate peak traffic. 2. Monitor CPU and memory usage. | System remains responsive under load. | | |
| **Availability** |
| TC-NF-015 | NFR-015 | System Uptime (99.9%) | 1. Track uptime over 30 days. | Uptime remains above 99.9%. | | |
| TC-NF-016 | NFR-016 | Data Backup & Recovery | 1. Trigger backup. 2. Simulate data loss and restore from backup. | Data is fully restored within 24 hours. | | |
| **Integration & Deployment** |
| TC-NF-017 | NFR-017 | Front-End & Back-End Integration | 1. Send requests from front-end. 2. Verify responses from back-end. | Responses are processed within ≤2 seconds. | | |
| TC-NF-018 | NFR-018 | Automated Updates | 1. Deploy an update via CI/CD pipeline. 2. Measure downtime. | Updates complete in ≤30 minutes with minimal disruption. | | |
| **Bug-Free Functionality** |
| TC-NF-019 | NFR-019 | Critical Bug Management | 1. Identify high-priority bugs. 2. Track resolution times. | Critical failures are fixed within 24-48 hours; system maintains 95% defect-free rate. | | |
| **Clear Communication** |
| TC-NF-020 | NFR-020 | Sprint Requirement Documentation | 1. Review sprint documentation. 2. Check requirement updates. | Requirements are clearly defined with minimal mid-sprint changes. | | |
