package com.ipl.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private final PlayerRepository repository;

    public ConsoleApp(PlayerRepository repository) {
        this.repository = repository;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                printMenu();
                String choice = scanner.nextLine().trim();
                if ("0".equals(choice)) {
                    System.out.println("Exiting IPL Player Management System.");
                    return;
                }
                handleChoice(choice, scanner);
            }
        }
    }

    private void printMenu() {
        System.out.println("\n==== IPL Team Player Management System ====");
        System.out.println("1. Show team-wise player details");
        System.out.println("2. Search player by ID");
        System.out.println("3. Search player by name");
        System.out.println("4. Sort players by runs");
        System.out.println("5. Sort players by wickets");
        System.out.println("6. Sort players by catches");
        System.out.println("7. Show top batsmen");
        System.out.println("8. Show top bowlers");
        System.out.println("9. Show top all-rounders");
        System.out.println("10. Show top wicket-keepers");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void handleChoice(String choice, Scanner scanner) {
        try {
            switch (choice) {
                case "1":
                    System.out.print("Enter team name: ");
                    printPlayers(repository.getPlayersByTeam(scanner.nextLine().trim()));
                    break;
                case "2":
                    System.out.print("Enter player ID: ");
                    int id = Integer.parseInt(scanner.nextLine().trim());
                    Player player = repository.findPlayerById(id);
                    if (player == null) {
                        System.out.println("No player found for ID: " + id);
                    } else {
                        System.out.println(player);
                    }
                    break;
                case "3":
                    System.out.print("Enter player name keyword: ");
                    printPlayers(repository.findPlayersByName(scanner.nextLine().trim()));
                    break;
                case "4":
                    printPlayers(repository.getPlayersSortedBy("runs"));
                    break;
                case "5":
                    printPlayers(repository.getPlayersSortedBy("wickets"));
                    break;
                case "6":
                    printPlayers(repository.getPlayersSortedBy("catches"));
                    break;
                case "7":
                    printTopPlayers("batsmen", repository.getTopBatsmen(readLimit(scanner)));
                    break;
                case "8":
                    printTopPlayers("bowlers", repository.getTopBowlers(readLimit(scanner)));
                    break;
                case "9":
                    printTopPlayers("all-rounders", repository.getTopAllRounders(readLimit(scanner)));
                    break;
                case "10":
                    printTopPlayers("wicket-keepers", repository.getTopWicketKeepers(readLimit(scanner)));
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Invalid number input. Please try again.");
        } catch (SQLException ex) {
            System.out.println("Database operation failed: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private int readLimit(Scanner scanner) {
        System.out.print("How many top players to show? ");
        int limit = Integer.parseInt(scanner.nextLine().trim());
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than zero.");
        }
        return limit;
    }

    private void printTopPlayers(String category, List<Player> players) {
        System.out.println("Top " + category + ":");
        printPlayers(players);
    }

    private void printPlayers(List<Player> players) {
        if (players.isEmpty()) {
            System.out.println("No players found.");
            return;
        }
        for (Player player : players) {
            System.out.println(player);
        }
    }
}
