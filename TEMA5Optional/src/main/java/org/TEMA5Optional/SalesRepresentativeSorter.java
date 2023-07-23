package org.TEMA5Optional;

class SalesRepresentativeSorter {
    public SalesRepresentative[] sort(SalesRepresentative[] representatives) {
        int n = representatives.length;
        SalesRepresentative temp;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (representatives[j].getRevenue() < representatives[j + 1].getRevenue()) {
                    temp = representatives[j];
                    representatives[j] = representatives[j + 1];
                    representatives[j + 1] = temp;
                }
            }
        }

        return representatives;
    }
}
