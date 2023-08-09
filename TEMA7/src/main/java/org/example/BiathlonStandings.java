package org.example;

import java.util.Collections;
import java.util.List;

class BiathlonStandings {
    private static final int PENALTY_SECONDS = 10;

    public static List<BiathlonAthlete> calculateStandings(List<BiathlonAthlete> athletes) {
        for (BiathlonAthlete athlete : athletes) {
            int penalty = countPenaltySeconds(athlete.getFirstShootingRange())
                    + countPenaltySeconds(athlete.getSecondShootingRange())
                    + countPenaltySeconds(athlete.getThirdShootingRange());

            String updatedTimeResult = addPenaltyToTimeResult(athlete.getSkiTimeResult(), penalty);
            athlete.setSkiTimeResult(updatedTimeResult);
        }

        Collections.sort(athletes);
        return athletes;
    }

    private static int countPenaltySeconds(String shootingRange) {
        int missedShots = countMissedShots(shootingRange);
        return missedShots * PENALTY_SECONDS;
    }

    private static int countMissedShots(String shootingRange) {
        int missedShots = 0;
        for (char c : shootingRange.toCharArray()) {
            if (c == ShootingResult.MISS.getSymbol()) {
                missedShots++;
            }
        }
        return missedShots;
    }

    private static String addPenaltyToTimeResult(String timeResult, int penalty) {
        String[] timeParts = timeResult.split(":");
        int minutes = Integer.parseInt(timeParts[0]);
        int seconds = Integer.parseInt(timeParts[1]);
        seconds += penalty;
        minutes += seconds / 60;
        seconds %= 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
