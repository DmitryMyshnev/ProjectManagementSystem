package ua.goIt.services;

import java.util.regex.Pattern;

public class ValidatePattern {
    public static final Pattern developerSavePattern = Pattern.compile("^(\\w+),\\s*(\\w+),\\s*(\\w+),\\s*(\\w+)\\s*$");
    public static final Pattern developerUpdatePattern = Pattern.compile("^(\\w+),\\s*(\\w+),\\s*(\\w+),\\s*(\\w+),\\s*(\\w+)\\s*$");
    public static final Pattern projectSavePattern = Pattern.compile("^(\\w+),\\s*(\\w+),\\s*(\\w+)\\s*$");
    public static final Pattern projectUpdatePattern = Pattern.compile("^(\\w+),\\s*(\\w+),\\s*(\\w+),\\s*(\\w+)\\s*$");
    public static final Pattern customerSavePattern = Pattern.compile("^(\\w+),\\s*(\\w+)\\s*$");
    public static final Pattern customerUpdatePattern = Pattern.compile("^(\\w+),\\s*(\\w+),\\s*(\\w+)\\s*$");
    public static final Pattern companySavePattern = Pattern.compile("^(\\w+),\\s*(\\w+)\\s*$");
    public static final Pattern companyUpdatePattern = Pattern.compile("^(\\w+),\\s*(\\w+),\\s*(\\w+)\\s*$");

    public static final Pattern namePattern = Pattern.compile("^([a-zA-Z]+)$");
    public static final Pattern agePattern = Pattern.compile("(\\d{1,2})");
    public static final Pattern genderPattern = Pattern.compile("(male|female)");
    public static final Pattern digitalPattern = Pattern.compile("^(\\d+)$");

}
