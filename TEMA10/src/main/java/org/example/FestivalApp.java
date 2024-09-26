package org.example;

public class FestivalApp {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();

        // Generate and start at least 100 attendee threads
        for (int i = 0; i < 100; i++) {
            TicketType ticketType = TicketType.getRandomTicketType();
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);
            attendee.start();
        }

        // Wait for 30 seconds and then stop the statistics thread
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        statisticsThread.stopThread();
    }
}
