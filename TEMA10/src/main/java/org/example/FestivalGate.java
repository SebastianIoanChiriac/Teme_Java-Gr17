package org.example;

import java.util.LinkedList;
import java.util.Queue;

class FestivalGate {
    private Queue<TicketType> ticketQueue = new LinkedList<>();

    public synchronized void addTicket(TicketType ticketType) {
        ticketQueue.add(ticketType);
    }

    public synchronized TicketType pollTicket() {
        return ticketQueue.poll();
    }
}
