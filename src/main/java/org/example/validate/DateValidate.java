package org.example.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidate {
    // Regular expression to check date in dd/MM/yyyy format
    public static String REGEX_PATTERN = "^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/(\\d{4})$";

    public static Boolean inValid(String date) {
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
