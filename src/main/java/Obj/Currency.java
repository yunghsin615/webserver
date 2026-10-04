package Obj;

public class Currency {
    double JPN = 4.4382;
    double USD = 0.0345;
    double CNY = 0.2300;
    private int amount;

    public Currency(int amount) {
        this.amount = amount;
    }

    public double getJPN() {
        return this.amount * JPN;
    }

    public double getUSD() {
        return this.amount * USD;
    }

    public double getCNY() {
        return this.amount * CNY;
    }
}
