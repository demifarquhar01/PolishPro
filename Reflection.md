# Reflection

**Challenges in Choosing Granularity for States/Actions:**  
When I started working on the activity diagrams, one of the first challenges I faced was deciding how detailed each step should be. At first, I found myself going too deep—breaking down every tiny action like “Click Submit” or “Load Page”—which made the diagrams feel overwhelming and hard to follow. On the flip side, when I tried simplifying the diagrams too much, it felt like I was skipping important steps that mattered to the actual functionality. 

What really helped me strike a balance was constantly referring back to the functional requirements. These requirements clearly outlined what needed to happen in each feature, and that made it easier to decide which steps were essential to include and which ones could be left out. For example, the password reset flow had a strong password enforcement requirement, so it made sense to include that as a distinct action. Without these requirements, I probably would have either overcomplicated the diagrams or missed critical system behaviour.

**Aligning Diagrams with Agile User Stories:**  
Another challenge was making sure the diagrams actually reflected what the Agile user stories were asking for. Since user stories are often written in plain language from the user’s perspective, they don’t always spell out the logic behind the scenes. I had to spend time interpreting each story—like “As a client, I want to reschedule my appointment so I can choose a more convenient time”—and then map that to actual decisions and processes within the system.

Again, the functional requirements were super helpful here. They acted like a bridge between the user stories and the diagrams. They made it clear that, for example, appointments can’t be rescheduled within 24 hours, and that a confirmation email has to be sent. With this guidance, I could confidently model each activity flow to match what users need and what the system should enforce. It also helped me stay focused and avoid adding features or flows that weren’t actually part of the current sprint.

**Comparison: State Diagrams vs. Activity Diagrams:**  
At first, I found it a bit confusing when I tried to understand the difference between state diagrams and activity diagrams, since they both deal with system behaviour. But as I got deeper into the project, the differences became clearer. State diagrams are more about tracking how an object changes over time—like how an appointment moves from "Pending" to "Confirmed" to "Completed." They’re great for understanding object lifecycles but don’t show how users and systems interact with those objects in detail.

On the other hand, activity diagrams are all about the process—the sequence of steps, decisions, and responsibilities. They helped me model things like "Service Management by Admin" and "Appointment Booking" much better because I could include swimlanes for different roles and show how actions flow from one actor to another. Since my system involves different types of users (clients, nail technicians, salon owners), activity diagrams gave me the flexibility to show these interactions clearly.

Overall, working on these activity diagrams has helped me better understand how functional requirements and user stories translate into actual workflows. It also made me more thoughtful about how to communicate system behaviour clearly—something I know will be really useful in both academic and real-world projects.
