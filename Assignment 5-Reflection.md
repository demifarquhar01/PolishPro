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

### ⚠️ Overall
Both functional and non-functional requirements posed challenges in defining clear, testable criteria. Refinements were necessary to ensure alignment with real-world business operations, improve system usability, and enhance security and performance. 🚀

