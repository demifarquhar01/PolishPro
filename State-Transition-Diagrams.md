# 📊 Object State Modeling with State Transition Diagrams

This section presents **7 critical objects** in the PolishPro: Nail Salon Booking System, with corresponding **state transition diagrams** created using UML standards in **Mermaid.js**. Each diagram includes:
- States
- Transitions
- Guard conditions (where applicable)

---

## 1. 🧾 User Account
### State Transition Diagram
```mermaid
stateDiagram-v2
  [*] --> Registered
  Registered --> LoggedIn : [Login successful] 
  LoggedIn --> LoggedOut : [User logs out]
  LoggedOut --> LoggedIn : [Login successful]
  LoggedIn --> ResettingPassword : [User requests password reset]
  ResettingPassword --> LoggedIn : [Password reset successful]
  ResettingPassword --> Registered : [Password reset failed]
  LoggedOut --> Registered : [User registers account]
  Registered --> PasswordError : [Password doesn't meet strong password policy]
  PasswordError --> Registered : [User corrects password]
```
---

# 2. 📆 Appointment
### State Transition Diagram
```mermaid
stateDiagram-v2
    [*] --> ViewingServices
    ViewingServices --> SelectingService: User selects a service
    SelectingService --> ChoosingTechnician: User picks a nail technician
    ChoosingTechnician --> PickingDateTime: User selects date & time
    PickingDateTime --> CheckingAvailability: System checks availability
    CheckingAvailability --> BookingConfirmation: Slot available
    CheckingAvailability --> PickingDateTime: Slot unavailable
    BookingConfirmation --> Booked: User confirms appointment
    BookingConfirmation --> PickingDateTime: User cancels confirmation
    Booked --> [*]
```
---

# 3️. Appointment Rescheduling & Cancellation ❌
### State Transition Diagram
```mermaid
stateDiagram-v2
    [*] --> AppointmentBooked
    AppointmentBooked --> Rescheduling : Client requests reschedule
    AppointmentBooked --> CancellationRequested : Client requests cancellation
    Rescheduling --> CheckingAvailability : System checks availability
    CheckingAvailability --> Rescheduled : Slot available
    CheckingAvailability --> Rescheduling : Slot unavailable
    CancellationRequested --> Canceled : 24-hour rule met
    CancellationRequested --> AppointmentBooked : 24-hour rule not met
    Rescheduled --> [*]
    Canceled --> [*]
```
---

## 4️. Technician Schedule Management 📅

### State Transition Diagram
```mermaid
stateDiagram-v2
    [*] --> Unavailable
    Unavailable --> SettingSchedule: Technician sets availability
    SettingSchedule --> Available: Schedule is saved
    Available --> ViewingSchedule: Technician views schedule
    ViewingSchedule --> Available: Technician returns to available state
    Available --> UpdatingSchedule: Technician modifies schedule
    UpdatingSchedule --> Available: Changes saved
    Available --> Unavailable: Technician marks unavailable
    Available --> AssignedToAppointment: Appointment booked
    AssignedToAppointment --> Available: Appointment completed

```

---

## 5️. Service Management ⚙
### State Transition Diagram
```mermaid
stateDiagram-v2
    [*] --> NoServices
    NoServices --> AddingService: Owner adds service
    AddingService --> ActiveService: Service published
    ActiveService --> ModifyingService: Owner updates details
    ModifyingService --> ActiveService: Changes saved
    ActiveService --> RemovingService: Owner removes service
    RemovingService --> NoServices: Service deleted
```
---

## 6️. Email Notifications 📩
### State Transition Diagram
```mermaid
stateDiagram-v2
    [*] --> PendingNotification
    PendingNotification --> Sending: System attempts to send
    Sending --> Sent: Delivered
    Sending --> Failed: Error occurred
    Failed --> Retrying: Retry triggered
    Retrying --> Sent: Delivered after retry
    Retrying --> Failed: Retry failed
```

  ---

## 7️. Client Preferences 🎯
### State Transition Diagram
```mermaid
stateDiagram-v2
  [*] --> PreferencesNotSet
  PreferencesNotSet --> PreferencesSet : [Client sets preferences]
  PreferencesSet --> PreferencesUpdated : [Client modifies preferences]
  PreferencesUpdated --> PreferencesNotSet : [Client clears preferences]
```
---
## Explanation of diagrams 
- [Explanations](https://github.com/demifarquhar01/PolishPro/blob/2e9b097dca5eecf7b775e149e64a8ffc1fad5724/Explanations.md)
