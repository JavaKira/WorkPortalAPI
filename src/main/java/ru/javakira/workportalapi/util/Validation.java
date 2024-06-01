package ru.javakira.workportalapi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean phoneNumber(String str) {
        Pattern pattern = Pattern.compile("(^8|7|\\+7)((\\d{10})|(\\s\\(\\d{3}\\)\\s\\d{3}\\s\\d{2}\\s\\d{2}))");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean email(String str) {
        Pattern pattern = Pattern.compile("([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
