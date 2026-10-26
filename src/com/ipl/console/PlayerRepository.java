package com.ipl.console;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PlayerRepository {
    private static final String BASE_SELECT =
        "SELECT id, name, team, role, runs, wickets, catches FROM players";

    public List<Player> getPlayersByTeam(String team) throws SQLException {
        String sql = BASE_SELECT + " WHERE team = ? ORDER BY name";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, team);
            return readPlayers(statement);
        }
    }

    public Player findPlayerById(int id) throws SQLException {
        String sql = BASE_SELECT + " WHERE id = ?";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapPlayer(resultSet);
                }
                return null;
            }
        }
    }

    public List<Player> findPlayersByName(String nameLike) throws SQLException {
        String sql = BASE_SELECT + " WHERE LOWER(name) LIKE LOWER(?) ORDER BY name";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + nameLike + "%");
            return readPlayers(statement);
        }
    }

    public List<Player> getPlayersSortedBy(String metric) throws SQLException {
        String column = mapSortMetric(metric);
        String sql = BASE_SELECT + " ORDER BY " + column + " DESC, name ASC";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            return readPlayers(statement);
        }
    }

    public List<Player> getTopBatsmen(int limit) throws SQLException {
        return getTopByRoleAndMetric("Batsman", "runs", limit);
    }

    public List<Player> getTopBowlers(int limit) throws SQLException {
        return getTopByRoleAndMetric("Bowler", "wickets", limit);
    }

    public List<Player> getTopAllRounders(int limit) throws SQLException {
        String sql = BASE_SELECT + " WHERE role = ? ORDER BY (runs + wickets * 20 + catches * 10) DESC, name ASC LIMIT ?";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "All-Rounder");
            statement.setInt(2, limit);
            return readPlayers(statement);
        }
    }

    public List<Player> getTopWicketKeepers(int limit) throws SQLException {
        return getTopByRoleAndMetric("Wicket-Keeper", "catches", limit);
    }

    private List<Player> getTopByRoleAndMetric(String role, String metric, int limit) throws SQLException {
        String column = mapSortMetric(metric);
        String sql = BASE_SELECT + " WHERE role = ? ORDER BY " + column + " DESC, name ASC LIMIT ?";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, role);
            statement.setInt(2, limit);
            return readPlayers(statement);
        }
    }

    private List<Player> readPlayers(PreparedStatement statement) throws SQLException {
        List<Player> players = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                players.add(mapPlayer(resultSet));
            }
        }
        return players;
    }

    private Player mapPlayer(ResultSet resultSet) throws SQLException {
        return new Player(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("team"),
            resultSet.getString("role"),
            resultSet.getInt("runs"),
            resultSet.getInt("wickets"),
            resultSet.getInt("catches")
        );
    }

    private String mapSortMetric(String metric) {
        String normalized = metric == null ? "" : metric.toLowerCase(Locale.ROOT).trim();
        switch (normalized) {
            case "runs":
                return "runs";
            case "wickets":
                return "wickets";
            case "catches":
                return "catches";
            default:
                throw new IllegalArgumentException("Unsupported sorting metric: " + metric);
        }
    }
}
