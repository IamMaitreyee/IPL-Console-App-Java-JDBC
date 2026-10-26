package JDBC_IPL_Oct23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class IplMainApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PlayerOperations playersOps = new PlayerOperations();
		System.out.println("Welcome to IPL.com");
		int choice = 0;

		while (choice != 15) {

			System.out.println("========================================");
			System.out.println("1.  Display All Teams");
			System.out.println("2.  Display All Players");
			System.out.println("3.  Display All Players by Team");
			System.out.println("4.  Display All Batsmen");
			System.out.println("5.  Display All Bowlers");
			System.out.println("6.  Display All All-Rounders");
			System.out.println("7.  Display All Wicket-Keepers");
			System.out.println("8.  Display Top Performing Player");
			System.out.println("9.  Search Player by Name");
			System.out.println("10. Search Player by ID");
			System.out.println("11. Sort Players by Runs");
			System.out.println("12. Sort Players by Wickets");
			System.out.println("13. Sort Players by Catches");
			System.out.println("14. Display Top 3 Players");
			System.out.println("15. Exit");

			System.out.println("\n=======================================");
			System.out.println("Enter your choice: ");

			choice = sc.nextInt();

			switch (choice) {

			case 1:
				Set<String> allTeams = playersOps.getAllTeams();
				allTeams.forEach(System.out::println);

				break;

			case 2:
				List<Player> allPlayersList = playersOps.getAllPlayers();
				allPlayersList.forEach(System.out::println);

				break;

			case 3:
				String choice01;
				do {
					System.out.println("Enter Team Name: ");
					String teamName = sc.next();

					List<Player> allPlayersGivenTeam = playersOps.getAllPlayersGivenTeam(teamName);
					if (allPlayersGivenTeam.isEmpty())
						System.out.println("No players found for team: " + teamName);
					else
						allPlayersGivenTeam.forEach(System.out::println);

					System.out.println("\nDo you want to enter another team? (yes/no): ");
					choice01 = sc.next();

				} while (choice01.equalsIgnoreCase("yes"));

				break;

			case 4:
				List<Player> allBatter = playersOps.getAllBatter();
				allBatter.forEach(System.out::println);

				System.out.println("\nDisplay Batsmen by Team");

				String choice1;

				do {
					System.out.print("Enter Team Name: ");
					String teamName1 = sc.next();

					List<Player> allTeamBatter = playersOps.getAllBatter(teamName1);

					if (allTeamBatter.isEmpty()) {
						System.out.println("No batsmen found for team: " + teamName1);
					} else {
						allTeamBatter.forEach(System.out::println);
					}

					System.out.print("\nDo you want to enter another team? (yes/no): ");
					choice1 = sc.next();

				} while (choice1.equalsIgnoreCase("yes"));

				break;

			case 5:
				List<Player> allBowler = playersOps.getAllBowler();
				allBowler.forEach(System.out::println);

				System.out.println("\nDisplay All Bowler by Team");

				String choice2;

				do {
					System.out.println("Enter Team Name: ");
					String teamName2 = sc.next();

					List<Player> allTeamBowler = playersOps.getAllBowler(teamName2);

					if (allTeamBowler.isEmpty()) {
						System.out.println("No players found for team: " + teamName2);
					} else {
						allTeamBowler.forEach(System.out::println);
					}

					System.out.print("\nDo you want to enter another team? (yes/no): ");
					choice2 = sc.next();

				} while (choice2.equalsIgnoreCase("yes"));

				break;

			case 6:
				List<Player> allRounder = playersOps.getAllRounder();
				allRounder.forEach(System.out::println);

				System.out.println("\nDisplay All All-Rounder by Team");

				String choice3;

				do {
					System.out.println("Enter Team Name: ");
					String tname = sc.next();

					List<Player> allAllRounder = playersOps.getAllRounder(tname);
					if (allAllRounder.isEmpty()) {
						System.out.println("No players found for team: " + tname);
					} else {
						allAllRounder.forEach(System.out::println);
					}

					System.out.print("\nDo you want to enter another team? (yes/no): ");
					choice3 = sc.next();

				} while (choice3.equalsIgnoreCase("yes"));

				break;

			case 7:
				List<Player> allWicketKeeper = playersOps.getAllWicketKeeper();
				allWicketKeeper.forEach(System.out::println);

				System.out.println("\nDisplay All Wicket-Keeper by Team");

				String choice4;
				do {
					System.out.println("Enter Team Name: ");
					String tName = sc.next();

					List<Player> allWicKeeper = playersOps.getAllWicketKeeper(tName);
					if (allWicKeeper.isEmpty()) {
						System.out.println("No players found for team: " + tName);
					} else {
						allWicKeeper.forEach(System.out::println);
					}

					System.out.print("\nDo you want to enter another team? (yes/no): ");
					choice4 = sc.next();

				} while (choice4.equalsIgnoreCase("yes"));

				break;

			case 8:
				int choice5 = 0;

				while (choice5 != 5) {

					System.out.println("\n===== TOP PERFORMING PLAYERS =====");
					System.out.println("1. Top 5 Batsmen (Highest Runs)");
					System.out.println("2. Top 5 Bowlers (Highest Wickets)");
					System.out.println("3. Top 5 Players (Most Catches)");
					System.out.println("4. Top 5 All-Rounders");
					System.out.println("5. Back to Main Menu");
					System.out.println("-------------------------------------");

					System.out.print("\nEnter your choice: ");
					choice5 = sc.nextInt();

					switch (choice5) {

					case 1:
						System.out.println("\n===== TOP 5 BATSMEN =====");
						List<Player> topBatsman = playersOps.getTop5Batsman();
						topBatsman.forEach(System.out::println);

						System.out.println("\nDisplay Top 5 Batsmen by Team");

						String choice6;

						do {
							System.out.print("Enter Team Name: ");
							String teamName1 = sc.next();

							List<Player> top5Batsman = playersOps.getTop5Batsman(teamName1);

							if (top5Batsman.isEmpty()) {
								System.out.println("No batsmen found for team: " + teamName1);
							} else {
								top5Batsman.forEach(System.out::println);
							}

							System.out.print("\nDo you want to enter another team? (yes/no): ");
							choice6 = sc.next();

						} while (choice6.equalsIgnoreCase("yes"));

						break;

					case 2:
						System.out.println("\n===== TOP 5 BOWLER =====");
						List<Player> topBowler = playersOps.getTop5Bowler();
						topBowler.forEach(System.out::println);

						System.out.println("\nDisplay Top 5 Bowler by Team");

						String choice7;

						do {
							System.out.print("Enter Team Name: ");
							String teamName1 = sc.next();

							List<Player> top5Bowler = playersOps.getTop5Bowler(teamName1);

							if (top5Bowler.isEmpty()) {
								System.out.println("No bowler found for team: " + teamName1);
							} else {
								top5Bowler.forEach(System.out::println);
							}

							System.out.print("\nDo you want to enter another team? (yes/no): ");
							choice7 = sc.next();

						} while (choice7.equalsIgnoreCase("yes"));

						break;

					case 3:
						System.out.println("\n===== TOP 5 PLAYERS BY CATCHES =====");

						List<Player> topCatches = playersOps.getTop5Catches();
						topCatches.forEach(System.out::println);

						System.out.println("\nDisplay Top 5 Players by Catches by Team");

						String choice8;

						do {
							System.out.print("Enter Team Name: ");
							String teamName1 = sc.next();

							List<Player> top5Catches = playersOps.getTop5Catches(teamName1);

							if (top5Catches.isEmpty()) {
								System.out.println("No players found for team: " + teamName1);
							} else {
								top5Catches.forEach(System.out::println);
							}

							System.out.print("\nDo you want to enter another team? (yes/no): ");
							choice8 = sc.next();

						} while (choice8.equalsIgnoreCase("yes"));

						break;

					case 4:
						System.out.println("\n===== TOP 5 ALL-ROUNDERS =====");

						List<Player> topAllRounders = playersOps.getTop5AllRounders();
						topAllRounders.forEach(System.out::println);

						System.out.println("\nDisplay Top 5 All-Rounders by Team");

						String choice9;

						do {
							System.out.print("Enter Team Name: ");
							String teamName1 = sc.next();

							List<Player> top5AllRounders = playersOps.getTop5AllRounders(teamName1);

							if (top5AllRounders.isEmpty()) {
								System.out.println("No all-rounders found for team: " + teamName1);
							} else {
								top5AllRounders.forEach(System.out::println);
							}

							System.out.print("\nDo you want to enter another team? (yes/no): ");
							choice9 = sc.next();

						} while (choice9.equalsIgnoreCase("yes"));

						break;

					case 5:
						System.out.println("\nReturning to Main Menu...");
						break;

					default:
						System.out.println("\nInvalid choice! Please enter 1 to 6.");
					}
				}
				break;

			case 9:
				try {
					System.out.print("Enter Player Name: ");
					sc.nextLine(); // Consume leftover newline
					String playerName = sc.nextLine().trim();

					List<Player> searchPlayer = playersOps.searchPlayerByName(playerName);

					if (searchPlayer.isEmpty()) {
						System.out.println("Player not found: " + playerName);
					} else {
						searchPlayer.forEach(System.out::println);
					}

				} catch (Exception e) {
					System.out.println("Error while searching player: " + e.getMessage());
				}
				break;

			case 10:
				try {
					System.out.print("Enter Player ID: ");
					int playerId = sc.nextInt();

					List<Player> searchID = playersOps.searchPlayerByID(playerId);

					if (searchID.isEmpty()) {
						System.out.println("Player not found with ID: " + playerId);
					} else {
						searchID.forEach(System.out::println);
					}

				} catch (java.util.InputMismatchException e) {
					System.out.println("Invalid input! Please enter a numeric Player ID.");
					sc.nextLine(); // Clear invalid input
				} catch (Exception e) {
					System.out.println("Error while searching player: " + e.getMessage());
				}
				break;

			case 11:
				System.out.println("\n===== PLAYERS SORTED BY RUNS =====");

				List<Player> playersByRuns = playersOps.getSortedRun();

				playersByRuns.forEach(System.out::println);
				break;

			case 12:
				System.out.println("\n===== PLAYERS SORTED BY WICKETS =====");

				List<Player> playersByWickets = playersOps.getSortedWicket();

				playersByWickets.forEach(System.out::println);
				break;

			case 13:
				System.out.println("\n===== PLAYERS SORTED BY CATCHES =====");

				List<Player> playersByCatches = playersOps.getSortedByCatches();

				playersByCatches.forEach(System.out::println);
				break;

			case 14:
				System.out.println("\n===== TOP 3 PLAYERS ======");

				List<Player> topPlayer = playersOps.getTop3Player();
				topPlayer.forEach(System.out::println);
			case 15:
				System.out.println("\nThank you for using IPL.com!");
				break;

			default:
				System.out.println("Invalid choice! Please enter 1 to 15.");
			}

		}

	}
}
