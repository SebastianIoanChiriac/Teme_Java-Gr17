package org.TEMA5Optional;

public class Main {
    public static void main(String[] args) {
        SalesRepresentative[] representatives = {
                new SalesRepresentative(10, 500),
                new SalesRepresentative(7,800),
                new SalesRepresentative(11,400),
                new SalesRepresentative(8,600),
                new SalesRepresentative(10,350)
        };
        SalesRepresentativeSorter sorter = new SalesRepresentativeSorter();
        SalesRepresentative[] sortedRepresentatives = sorter.sort(representatives);

        for(SalesRepresentative representative : sortedRepresentatives){
            System.out.println("Revenue:" + representative.getRevenue());
        }
    }

}