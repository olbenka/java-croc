package thirteen;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        // допустим, аукцион заканчивается через 10 секунд:
        LocalDateTime endAuction = LocalDateTime.now().plusSeconds(10);

        // цена
        BigDecimal startPrice;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/thirteen/lot.txt"))) {
            String line = reader.readLine();
            line = reader.readLine();
            startPrice = BigDecimal.valueOf(Long.parseLong(line.trim()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        AuctionLot lot = new AuctionLot("", startPrice, endAuction);

        // участники
        List<String> participants = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/thirteen/participants.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                participants.add(line.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int minParticipantsNumber = 10;
        int maxParticipantsNumber = participants.size();
        Random random1 = new Random();
        int randomParticipantsNumber = random1.nextInt(maxParticipantsNumber - minParticipantsNumber + 1) + minParticipantsNumber;

        List<Thread> participantThreads = new ArrayList<>();
        for (int i = 0; i < randomParticipantsNumber; ++i) {
            Thread participantThread = getParticipantThread(participants, i, lot);
            participantThreads.add(participantThread);
            participantThread.start();
        }

        for (Thread thread : participantThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Количество участников: " + randomParticipantsNumber);
        System.out.println("Победитель: " + lot.getWinner());
    }

    private static Thread getParticipantThread(List<String> participants, int i, AuctionLot lot) {
        String participantName = participants.get(i % participants.size());

        return new Thread(new Runnable() {
            @Override
            public void run() {
                Random random2 = new Random();
                for (int j = 0; j < 100; j++) {
                    BigDecimal bidPrice = lot.getCurrentPrice().add(BigDecimal.valueOf(random2.nextDouble() * 1000));
                    //System.out.println("Поток номер: " + i);
                    lot.placeBet(participantName, bidPrice);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }



}
