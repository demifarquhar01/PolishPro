## PolishPro: Use Case Diagram
 ![image_alt](https://github.com/demifarquhar01/PolishPro/blob/f0b5683fbcaa0dff583fc59b8d42ce44a9055a39/usecase.drawio%20(2).png)

## Key Actor And Their Roles 
1. **Client:** A user who registers for an account, views services, books appointments, reschedules/cancels appointments, and receives email notifications about appointments.
2. **Nail Technician:** Manages their personal schedule, views assigned appointments, and checks client preferences for a personalized experience.
3. **Salon Owner/ Manager:** Manages the salon’s service offerings, modifies available services, and schedules time slots for appointments.
4. **User Authentication System:** Validates user credentials for login and handles password reset requests.
5. **Email Notification System:** Sends appointment confirmations and reminders to clients.
6. **IT Administrator:** Manages and troubleshoots email failures.

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
