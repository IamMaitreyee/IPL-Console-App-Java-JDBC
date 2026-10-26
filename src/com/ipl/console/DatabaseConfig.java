package com.ipl.console;

public final class DatabaseConfig {
    private DatabaseConfig() {
    }

    public static String getUrl() {
        return System.getenv().getOrDefault("IPL_DB_URL", "jdbc:mysql://localhost:3306/ipl");
    }

    public static String getUsername() {
        return System.getenv().getOrDefault("IPL_DB_USER", "root");
    }

    public static String getPassword() {
        return System.getenv().getOrDefault("IPL_DB_PASSWORD", "root");
    }
}
