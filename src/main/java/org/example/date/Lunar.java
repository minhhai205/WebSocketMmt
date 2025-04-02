package org.example.date;

public class Lunar extends Date {
    private static final long serialVersionUID = 1L;
    public boolean isleap;

    public Lunar(boolean isleap, int lunarDay, int lunarMonth, int lunarYear) {
        super();
        this.isleap = isleap;
        this.day = lunarDay;
        this.month = lunarMonth;
        this.year = lunarYear;
    }

    public Lunar() {
        super();
    }

    @Override
    public String toString() {
        return "Lunar " + super.toString();
    }
}