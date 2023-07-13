package org.example;

enum ShootingResult {
    HIT('x', 0),
    MISS('o', 10);

    private char symbol;
    private int penaltySeconds;

    ShootingResult(char symbol, int penaltySeconds) {
        this.symbol = symbol;
        this.penaltySeconds = penaltySeconds;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getPenaltySeconds() {
        return penaltySeconds;
    }
}
