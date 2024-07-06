package KedelidzeKrutyakov.deal.api.DTO;

import KedelidzeKrutyakov.deal.enums.ApplicationStatus;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ApplicationStatusHistoryDTO implements Serializable {
    private ApplicationStatus status;
    private LocalDateTime time;
    private ApplicationStatus changeType;
}
