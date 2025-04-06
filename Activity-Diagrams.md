# Activity Diagrams

This document presents Activity Diagrams for key workflows in the **PolishPro: Nail Salon Booking System**. These diagrams visualize critical processes such as **User Registration**, **Appointment Booking**, and **Email Notifications**, aligning with the system's functional requirements. 
The following workflows are covered:

1. **User Registration, Login, and Password Reset**
2. **User Role-Based Login & Access Control**
3. **Appointment Booking**
4. **Appointment Rescheduling or Cancellation**
5. **Client Management by Nail Technicians**
6. **Service Management by Salon Owner/Admin**
7. **Client Preferences Management**
8. **Email Notifications**

Each diagram includes **start/end nodes**, **actions**, **decisions**, and **parallel actions** with **swimlanes** to indicate roles/actors responsible for each step. Markdown explanations describe how these workflows address stakeholder concerns, ensuring the system is secure, efficient, and user-friendly.


# 1.  User Registration, Login, and Password Reset

```mermaid
flowchart TD
    Start([Start]) --> A[User enters registration details]
    A --> B[Check if email is unique]
    B -- No --> C[Show email error]
    B -- Yes --> D[Validate password]
    D --> E{Is password strong?}
    E -- No --> F[Show password error]
    E -- Yes --> G[Send verification email]
    G --> H[Email confirmed]
    H --> I[Account activated]
    I --> J[User logs in]
    J --> K[Login successful]
    K --> L[User can reset password]
    L --> M[User requests reset]
    M --> N[Send reset link]
    N --> O[User resets password]
    O --> P[Validate password strength]
    P --> Q{Is password strong?}
    Q -- No --> R[Show password error]
    Q -- Yes --> S[Password reset successful]
    S --> End([End])
    F --> D
    C --> A
    R --> O

    classDef user fill:#FFEEEE,stroke:#D33,stroke-width:2px;
    classDef system fill:#EEFFEE,stroke:#3D3,stroke-width:2px;

    class A,F,C,H,I,J,K,L,M,O,S user;
    class B,D,E,G,Q system;
```

---

# 2.  User Role-Based Login & Access Control
```mermaid
flowchart TD
    Start([Start]) --> A[User enters login credentials]
    A --> B{Are credentials valid?}
    B -- No --> C[Show error message]
    C --> End([End])
    B -- Yes --> D[Determine user role]
    D --> E{Role type?}
    E -- Client --> F[Redirect to client dashboard]
    E -- Nail Technician --> G[Redirect to technician dashboard]
    E -- Admin --> H[Redirect to admin dashboard]
    F --> End
    G --> End
    H --> End

    classDef user fill:#FFEEEE,stroke:#D33,stroke-width:2px;
    classDef system fill:#EEFFEE,stroke:#3D3,stroke-width:2px;

    class A,C,F,G,H user;
    class B,D,E system;
```

---
# 3. Appointment Booking
```mermaid
flowchart TD
    Start([Start]) --> A[User selects service]
    A --> B[Check technician availability]
    B --> C{Is technician available?}
    C -- No --> D[Show availability error]
    C -- Yes --> E[Confirm booking details]
    E --> F[User confirms booking]
    F --> G[Send confirmation email]
    G --> End([End])
    D --> A

    classDef user fill:#FFEEEE,stroke:#D33,stroke-width:2px;
    classDef system fill:#EEFFEE,stroke:#3D3,stroke-width:2px;

    class A,C,D,F,G user;
    class B,E system;
```

---

# 4. Appointment Rescheduling or Cancellation
```mermaid
flowchart TD
    Start([Start]) --> A[User selects reschedule or cancel]
    A --> B[Check if appointment is within 24-hour policy]
    B -- No --> C[Show error message]
    B -- Yes --> D[Check technician availability for reschedule]
    D --> E{Is technician available?}
    E -- No --> F[Show availability error]
    E -- Yes --> G[Confirm reschedule or cancellation]
    G --> H[Send confirmation email]
    H --> End([End])
    F --> A
    C --> A

    classDef user fill:#FFEEEE,stroke:#D33,stroke-width:2px;
    classDef system fill:#EEFFEE,stroke:#3D3,stroke-width:2px;

    class A,C,D,F,G,H user;
    class B,E system;
```
---

## 5. Client Management by Nail Technicians

```mermaid
flowchart TD
    Start([Start]) --> A[View schedule]
    A --> B[View upcoming appointments with client details]
    B --> C{Appointment needs to change?}
    C -->|Yes| D[Modify/reschedule appointment]
    D --> E[Request client approval]
    E --> F{Client approved?}
    F -->|Yes| G[Update appointment in system]
    F -->|No| H[Keep original schedule]
    G --> I[Send confirmation and alert]
    H --> I
    C -->|No| J[Continue preparing for appointments]
    I --> J
    J --> K{Schedule update needed?}
    K -->|Yes| L[Technician updates schedule]
    L --> M[System reflects updated schedule in real-time]
    K -->|No| M
    M --> End([End])

    classDef user fill:#FFEEEE,stroke:#D33,stroke-width:2px;
    classDef system fill:#EEFFEE,stroke:#3D3,stroke-width:2px;

    class A,B,C,D,E,F,G,H,J,K,L user;
    class I,M system;
```
---
## 6. Service Management by Salon Owner/Admin
```mermaid
flowchart TD
    Start([Start]) --> A[Admin selects to modify services]
    A --> B[Select service to modify]
    B --> C[Modify service name, description, or price]
    C --> D[Save changes]
    D --> E[Update service on booking page]
    E --> F[Notify users about service change]
    F --> End([End])

    classDef user fill:#FFEEEE,stroke:#D33,stroke-width:2px;
    classDef system fill:#EEFFEE,stroke:#3D3,stroke-width:2px;

    class A,B,C,D,F user;
    class E system;
```
---

## 7. Client Preferences Management
```mermaid
flowchart TD
    Start([Start]) --> A[Client books an appointment]
    A --> B[Save client preferences]
    B --> C[Technician views client preferences]
    C --> D{Does technician update preferences?}
    D -- Yes --> E[Save updated preferences]
    D -- No --> F[End]
    E --> F
    F --> End([End])

    classDef user fill:#FFEEEE,stroke:#D33,stroke-width:2px;
    classDef system fill:#EEFFEE,stroke:#3D3,stroke-width:2px;

    class A,B,C,D,E,F user;
    class F system;

 ```
---

## 8.  Email Notifications

```mermaid
flowchart TD
    Start([Start]) --> A[Booking or modification occurs]
    A --> B{Is action successful?}
    B -- Yes --> C[Send success email notification]
    C --> End([End])
    B -- No --> D[Send failure notification to IT admin]
    D --> End

    classDef user fill:#FFEEEE,stroke:#D33,stroke-width:2px;
    classDef system fill:#EEFFEE,stroke:#3D3,stroke-width:2px;

    class A,C user;
    class B,D system;
```
