package com.ipl.console;

public class Main {
    public static void main(String[] args) {
        ConsoleApp app = new ConsoleApp(new PlayerRepository());
        app.start();
    }
}
