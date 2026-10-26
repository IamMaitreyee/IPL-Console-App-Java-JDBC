package com.ipl.console;

public class Player {
    private final int id;
    private final String name;
    private final String team;
    private final String role;
    private final int runs;
    private final int wickets;
    private final int catches;

    public Player(int id, String name, String team, String role, int runs, int wickets, int catches) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.role = role;
        this.runs = runs;
        this.wickets = wickets;
        this.catches = catches;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getRole() {
        return role;
    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public int getCatches() {
        return catches;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %d | Name: %s | Team: %s | Role: %s | Runs: %d | Wickets: %d | Catches: %d",
            id, name, team, role, runs, wickets, catches
        );
    }
}
