package org.example;

class BiathlonAthlete implements Comparable<BiathlonAthlete> {
    @CSVColumn(index = 0)
    private int athleteNumber;

    @CSVColumn(index = 1)
    private String athleteName;

    @CSVColumn(index = 2)
    private String countryCode;

    @CSVColumn(index = 3)
    private String skiTimeResult;

    @CSVColumn(index = 4)
    private String firstShootingRange;

    @CSVColumn(index = 5)
    private String secondShootingRange;

    @CSVColumn(index = 6)
    private String thirdShootingRange;

    public BiathlonAthlete(int athleteNumber, String athleteName, String countryCode, String skiTimeResult,
                           String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public void setSkiTimeResult(String skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public String getSecondShootingRange() {
        return secondShootingRange;
    }

    public String getThirdShootingRange() {
        return thirdShootingRange;
    }

    public int compareTo(BiathlonAthlete other) {
        return this.skiTimeResult.compareTo(other.skiTimeResult);
    }
}
