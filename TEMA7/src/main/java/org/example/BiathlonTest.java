package org.example;

import java.util.ArrayList;
import java.util.List;

public class BiathlonTest {
    public static void main(String[] args) {
        String csvData = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";

        List<BiathlonAthlete> athletes = parseCSV(csvData);

        List<BiathlonAthlete> standings = BiathlonStandings.calculateStandings(athletes);

        System.out.println("RESULTS:");
        System.out.println("Winner - " + standings.get(0).getAthleteName() + " " + standings.get(0).getSkiTimeResult());
        System.out.println("Runner-up - " + standings.get(1).getAthleteName() + " " + standings.get(1).getSkiTimeResult());
        System.out.println("Third Place - " + standings.get(2).getAthleteName() + " " + standings.get(2).getSkiTimeResult());
    }

    public static List<BiathlonAthlete> parseCSV(String csvData) {
        List<BiathlonAthlete> athletes = new ArrayList<>();

        String[] lines = csvData.split("\n");
        for (String line : lines) {
            String[] parts = line.split(",");
            int athleteNumber = Integer.parseInt(parts[0].trim());
            String athleteName = parts[1].trim();
            String countryCode = parts[2].trim();
            String skiTimeResult = parts[3].trim();
            String firstShootingRange = parts[4].trim();
            String secondShootingRange = parts[5].trim();
            String thirdShootingRange = parts[6].trim();

            BiathlonAthlete athlete = new BiathlonAthlete(athleteNumber, athleteName, countryCode, skiTimeResult,
                    firstShootingRange, secondShootingRange, thirdShootingRange);
            athletes.add(athlete);
        }

        return athletes;
    }
}
