package org.example;

import java.util.Random;

class FestivalAttendeeThread extends Thread {
    private final TicketType ticketType;
    private final FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000)); // Simulate attendee arriving at different times
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gate.addTicket(ticketType);
        System.out.println(Thread.currentThread().getName() + ": Entered with " + ticketType);
    }
}
