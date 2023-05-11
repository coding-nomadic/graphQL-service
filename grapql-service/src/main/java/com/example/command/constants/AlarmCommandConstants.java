package com.example.command.constants;

public class AlarmCommandConstants {

    public static final String BASE_PATH = "/alarms";
    public static final String SEVERITY = "/severity";
    public static final String CREATE = "/create";
    public static final String UPDATE = "/update/{id}";

    public static final String DELETE = "/delete/{id}";
    public static final String ID = "/{id}";
    public static final String PROFILE_DEFAULT = "default";
    public static final String DATABASE_NAME = "${dbname}";
    public static final String DATABASE_URL = "${database.url}";
    public static final String DATABASE_DRIVER = "${database.driverClassName}";
    public static final String PROPOSITION_NOT = "Proposition does not exist";
    public static final String PRODUCT_NOT = "Product Type doesnt exists";
    public static final String SEVERITY_NOT = "Unknown Severity";
    public static final String BASE_PACKAGE = "com.example.command";

    public static final String NOT_FOUND = "Alarm Not found for this ID ";
}
