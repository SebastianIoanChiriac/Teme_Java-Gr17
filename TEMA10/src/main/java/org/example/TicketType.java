package org.example;

import java.util.Random;

enum TicketType {
    FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP;

    private static final TicketType[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static TicketType getRandomTicketType() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}