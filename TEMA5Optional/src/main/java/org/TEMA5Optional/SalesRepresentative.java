package org.TEMA5Optional;

class SalesRepresentative {
    private int sales;
    private int quota;

    public SalesRepresentative(int sales, int quota){
        this.sales = sales;
        this.quota = quota;
    }

    public int getSales() {
        return sales;
    }

    public int getQuota() {
        return quota;
    }
    public int getRevenue(){
        return sales*quota;
    }
}
