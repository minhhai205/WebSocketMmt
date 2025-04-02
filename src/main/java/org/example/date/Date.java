package org.example.date;

import java.io.Serializable;

public class Date implements Serializable {
    private static final long serialVersionUID = 1L;
    public int day;
    public int month;
    public int year;

    @Override
    public String toString() {
        return "Date [" + day + "/" + month + "/" + year + "]";
    }

}