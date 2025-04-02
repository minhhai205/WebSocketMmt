package org.example.date;

public class Solar extends Date {
    private static final long serialVersionUID = 1L;

    public Solar() {
        super();
    }

    public Solar(int solarDay, int solarMonth, int solarYear) {
        this.day = solarDay;
        this.month = solarMonth;
        this.year = solarYear;
    }

    @Override
    public String toString() {
        return "Solar " + super.toString();
    }

}
