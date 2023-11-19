package thirteen;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AuctionLot {
    private String participantName;
    private BigDecimal currentPrice;
    private final LocalDateTime endTime;

    public AuctionLot(String participantName, BigDecimal currentPrice, LocalDateTime endTime) {
        this.participantName = participantName;
        this.currentPrice = currentPrice;
        this.endTime = endTime;
    }

    public synchronized void placeBet(String bidderName, BigDecimal betPrice) {
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isBefore(endTime) && (betPrice.compareTo(currentPrice) > 0)) {
            currentPrice = betPrice;
            participantName = bidderName;
            System.out.println(participantName + " сделал(а) ставку: " + betPrice);
        }
    }

    public synchronized BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public synchronized String getWinner() {
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isAfter(endTime)) {
            return participantName;
        } else {
            return " ";
        }
    }
}
