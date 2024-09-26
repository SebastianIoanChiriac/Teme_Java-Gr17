package org.example;

import java.util.HashMap;
import java.util.Map;

class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;
    private volatile boolean shouldStop = false;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    public void stopThread() {
        shouldStop = true;
    }

    @Override
    public void run() {
        while (!shouldStop) {
            try {
                Thread.sleep(5000); // Wait for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Map<TicketType, Integer> ticketCounts = new HashMap<>();
            TicketType ticketType = gate.pollTicket();
            while (ticketType != null) {
                ticketCounts.put(ticketType, ticketCounts.getOrDefault(ticketType, 0) + 1);
                ticketType = gate.pollTicket();
            }

            if (!ticketCounts.isEmpty()) {
                System.out.println("\n--- Festival Statistics ---");
                int totalAttendees = ticketCounts.values().stream().mapToInt(Integer::intValue).sum();
                System.out.println(totalAttendees + " people entered");
                for (TicketType type : TicketType.values()) {
                    int count = ticketCounts.getOrDefault(type, 0);
                    System.out.println(count + " have " + type + " passes");
                }
                System.out.println("--- End of Statistics ---\n");
            }
        }
    }
}
