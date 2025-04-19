package demifarquhar01;

import java.time.LocalDateTime;

public class Cancel {
    private final String cancelId;
    private final String cancellationReason;
    private final LocalDateTime cancelDateTime;

    public Cancel(String cancelId, String cancellationReason, LocalDateTime cancelDateTime) {
        this.cancelId = cancelId;
        this.cancellationReason = cancellationReason;
        this.cancelDateTime = cancelDateTime;
    }

    public void confirmCancellation() {
        System.out.println("Cancellation confirmed for ID: " + cancelId +
                           ". Reason: " + cancellationReason +
                           " at " + cancelDateTime);
    }

    // Optional getter if you need it elsewhere
    public String getCancelId() {
        return cancelId;
    }
}
