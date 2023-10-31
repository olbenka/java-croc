package seven;

import java.time.LocalDateTime;

public interface Pickup {
    boolean isAvailable() throws OrderException;
    void assemblyOrder(LocalDateTime date);
    void closedOrder(LocalDateTime date);
    void updateStatus();
}
