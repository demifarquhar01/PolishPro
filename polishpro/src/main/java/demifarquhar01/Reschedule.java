package demifarquhar01;
import java.time.LocalDateTime;

  
 public class Reschedule {
            private final String rescheduleId;
            private final LocalDateTime oldDateTime;
            private final LocalDateTime newDateTime;
            private final String reason;
        
            public Reschedule(String rescheduleId, LocalDateTime oldDateTime, LocalDateTime newDateTime, String reason) {
                this.rescheduleId = rescheduleId;
                this.oldDateTime = oldDateTime;
                this.newDateTime = newDateTime;
                this.reason = reason;
            }
        
            public LocalDateTime getNewDateTime() {
                return newDateTime;
            }
        
            public void confirmReschedule() {
                System.out.println("Reschedule confirmed from " + oldDateTime + " to " + newDateTime);
            }
        
            // Optionally, add getter methods for other fields
            public String getRescheduleId() {
                return rescheduleId;
            }
        
            public LocalDateTime getOldDateTime() {
                return oldDateTime;
            }
        
            public String getReason() {
                return reason;
            }
        }
        

      

