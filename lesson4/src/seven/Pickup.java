package seven;

import java.time.LocalDateTime;

public interface Pickup {
    boolean isAvailable() throws ExceedsMaximumArraySizeExeption, OrderExceededStoragePeriodExeption;
    void assemblyAnOrder(LocalDateTime date);
    void issuingAnOrder(LocalDateTime date);
    void expireAnOrder();
}

