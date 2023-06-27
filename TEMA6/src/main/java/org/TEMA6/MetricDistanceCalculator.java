package org.TEMA6;

import java.util.HashMap;
import java.util.Map;

public class MetricDistanceCalculator {
    private static final Map<String, Integer> UNIT_CONVERSIONS = new HashMap<>();
    static {
        UNIT_CONVERSIONS.put("mm", 1);
        UNIT_CONVERSIONS.put("cm", 10);
        UNIT_CONVERSIONS.put("dm", 100);
        UNIT_CONVERSIONS.put("m", 1000);
        UNIT_CONVERSIONS.put("km", 1000000);
    }

    public static int calculateDistance(String expression) {
        int totalDistance = 0;
        String[] tokens = expression.split("\\s+");

        int value = 0;
        int sign = 1; // 1 for addition, -1 for subtraction
        String unit = "";

        for (String token : tokens) {
            if (isNumeric(token)) {
                value = Integer.parseInt(token);
            } else if (isValidUnit(token)) {
                unit = token;
                int conversionFactor = UNIT_CONVERSIONS.get(unit);
                int distance = value * conversionFactor * sign;
                totalDistance += distance;
            } else if (token.equals("+")) {
                sign = 1;
            } else if (token.equals("-")) {
                sign = -1;
            }
        }

        return totalDistance;
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    private static boolean isValidUnit(String str) {
        return UNIT_CONVERSIONS.containsKey(str);
    }
}