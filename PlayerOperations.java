package JDBC_IPL_Oct23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerOperations {

	List<Player> playerlist = new ArrayList<>();
	PlayersDao playerdao = new PlayersDao();

	public List<Player> getAllPlayers() {

		playerlist = playerdao.getAllPlayers();
		return playerlist;
	}

	public Set<String> getAllTeams() {
		playerlist = playerdao.getAllPlayers();

		Set<String> allTeams = new HashSet<>();
		for (Player p : playerlist) {
			allTeams.add(p.getTeamName());
		}

		return allTeams;
	}

	public List<Player> getAllPlayersGivenTeam(String teamName) {
		playerlist = playerdao.getAllPlayers();

		List<Player> teamPlayer = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getTeamName().equalsIgnoreCase(teamName))
				teamPlayer.add(p);
		}

		return teamPlayer;
	}

	public List<Player> getAllBatter() {
		playerlist = playerdao.getAllPlayers();
		List<Player> allBatter = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("Batsman"))
				allBatter.add(p);
		}

		return allBatter;
	}

	public List<Player> getAllBatter(String teamName) {
		playerlist = playerdao.getAllPlayers();

		List<Player> allBatter = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("Batsman") && p.getTeamName().equalsIgnoreCase(teamName))
				allBatter.add(p);
		}

		return allBatter;
	}

	public List<Player> getAllBowler() {
		playerlist = playerdao.getAllPlayers();

		List<Player> allBowler = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("Bowler"))
				allBowler.add(p);
		}

		return allBowler;
	}

	public List<Player> getAllBowler(String teamName) {
		playerlist = playerdao.getAllPlayers();

		List<Player> allBowler = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("Bowler") && p.getTeamName().equalsIgnoreCase(teamName))
				allBowler.add(p);
		}

		return allBowler;
	}

	public List<Player> getAllRounder() {
		playerlist = playerdao.getAllPlayers();

		List<Player> allRounder = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("All-Rounder"))
				allRounder.add(p);
		}

		return allRounder;
	}

	public List<Player> getAllRounder(String tname) {
		playerlist = playerdao.getAllPlayers();

		List<Player> allRounder = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("All-Rounder") && p.getTeamName().equalsIgnoreCase(tname))
				allRounder.add(p);
		}

		return allRounder;
	}

	public List<Player> getAllWicketKeeper() {
		playerlist = playerdao.getAllPlayers();

		List<Player> allWicketKeeper = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("Wicket-Keeper"))
				allWicketKeeper.add(p);
		}

		return allWicketKeeper;
	}

	public List<Player> getAllWicketKeeper(String tname) {
		playerlist = playerdao.getAllPlayers();

		List<Player> allWicketKeeper = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("Wicket-Keeper") && p.getTeamName().equalsIgnoreCase(tname))
				allWicketKeeper.add(p);
		}

		return allWicketKeeper;
	}

	public List<Player> getTop5Batsman() {
		playerlist = playerdao.getAllPlayers();

		List<Player> allBatter = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("Batsman"))
				allBatter.add(p);
		}

		Comparator<Player> topBatsman = new PlayerBatsmanComaparator();
		Collections.sort(allBatter, topBatsman);

		List<Player> top5Batsman = new ArrayList<>();

		for (int i = 0; i < allBatter.size() && i < 5; i++) {
			top5Batsman.add(allBatter.get(i));
		}

		return top5Batsman;
	}

	public List<Player> getTop5Batsman(String teamName1) {

		playerlist = playerdao.getAllPlayers();

		List<Player> allBatter = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("Batsman") && p.getTeamName().equalsIgnoreCase(teamName1))
				allBatter.add(p);
		}

		Comparator<Player> topBatsman = new PlayerBatsmanComaparator();
		Collections.sort(allBatter, topBatsman);

		List<Player> top5Batsman = new ArrayList<>();

		for (int i = 0; i < allBatter.size() && i < 5; i++) {
			top5Batsman.add(allBatter.get(i));
		}

		return top5Batsman;
	}

	public List<Player> getTop5Bowler() {
		playerlist = playerdao.getAllPlayers();

		List<Player> allBowler = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("Bowler"))
				allBowler.add(p);
		}

		Comparator<Player> topBowler = new PlayerBowlerComaparator();
		Collections.sort(allBowler, topBowler);

		List<Player> top5Bowler = new ArrayList<>();

		for (int i = 0; i < allBowler.size() && i < 5; i++) {
			top5Bowler.add(allBowler.get(i));
		}

		return top5Bowler;
	}

	public List<Player> getTop5Bowler(String teamName1) {
		playerlist = playerdao.getAllPlayers();

		List<Player> allBowler = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("Bowler") && p.getTeamName().equalsIgnoreCase(teamName1))
				allBowler.add(p);
		}
		Comparator<Player> topBowler = new PlayerBowlerComaparator();
		Collections.sort(allBowler, topBowler);

		List<Player> top5Bowler = new ArrayList<>();

		for (int i = 0; i < allBowler.size() && i < 5; i++) {
			top5Bowler.add(allBowler.get(i));
		}

		return top5Bowler;
	}

	public List<Player> getTop5Catches() {

		playerlist = playerdao.getAllPlayers();

		List<Player> allCatcher = new ArrayList<>();

		for (Player p : playerlist) {
			allCatcher.add(p);
		}

		Comparator<Player> topCatches = new PlayerCatchesComparator();

		Collections.sort(allCatcher, topCatches);

		List<Player> top5Catches = new ArrayList<>();

		for (int i = 0; i < allCatcher.size() && i < 5; i++) {
			top5Catches.add(allCatcher.get(i));
		}

		return top5Catches;
	}

	public List<Player> getTop5Catches(String teamName1) {

		playerlist = playerdao.getAllPlayers();

		List<Player> allCatcher = new ArrayList<>();

		for (Player p : playerlist) {
			if (p.getTeamName().equalsIgnoreCase(teamName1)) {
				allCatcher.add(p);
			}
		}

		Comparator<Player> topCatches = new PlayerCatchesComparator();

		Collections.sort(allCatcher, topCatches);

		List<Player> top5Catches = new ArrayList<>();

		for (int i = 0; i < allCatcher.size() && i < 5; i++) {
			top5Catches.add(allCatcher.get(i));
		}

		return top5Catches;
	}

	public List<Player> getTop5AllRounders() {

		playerlist = playerdao.getAllPlayers();

		List<Player> allRounders = new ArrayList<>();

		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("All-Rounder")) {
				allRounders.add(p);
			}
		}

		Comparator<Player> topAllRounders = new PlayerAllRounderComparator();

		Collections.sort(allRounders, topAllRounders);

		List<Player> top5AllRounders = new ArrayList<>();

		for (int i = 0; i < allRounders.size() && i < 5; i++) {
			top5AllRounders.add(allRounders.get(i));
		}

		return top5AllRounders;
	}

	public List<Player> getTop5AllRounders(String teamName1) {
		playerlist = playerdao.getAllPlayers();

		List<Player> allRounders = new ArrayList<>();

		for (Player p : playerlist) {
			if (p.getCategory().equalsIgnoreCase("All-Rounder") && p.getTeamName().equalsIgnoreCase(teamName1)) {
				allRounders.add(p);
			}
		}

		Comparator<Player> topAllRounders = new PlayerAllRounderComparator();

		Collections.sort(allRounders, topAllRounders);

		List<Player> top5AllRounders = new ArrayList<>();

		for (int i = 0; i < allRounders.size() && i < 5; i++) {
			top5AllRounders.add(allRounders.get(i));
		}

		return top5AllRounders;
	}

	public List<Player> searchPlayerByName(String playerName) {
		playerlist = playerdao.getAllPlayers();

		List<Player> searchPlayer = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getName().equalsIgnoreCase(playerName))
				searchPlayer.add(p);
		}
		return searchPlayer;
	}

	public List<Player> searchPlayerByID(int playerId) {
		playerlist = playerdao.getAllPlayers();

		List<Player> searchId = new ArrayList<>();
		for (Player p : playerlist) {
			if (p.getId() == playerId)
				searchId.add(p);
		}
		return searchId;
	}

	public List<Player> getSortedRun() {

		playerlist = playerdao.getAllPlayers();

		Comparator<Player> runSorted = new PlayerBatsmanComaparator();

		Collections.sort(playerlist, runSorted);

		return playerlist;
	}

	public List<Player> getSortedWicket() {
		playerlist = playerdao.getAllPlayers();

		Comparator<Player> wicketSorted = new PlayerBowlerComaparator();
		Collections.sort(playerlist, wicketSorted);

		return playerlist;
	}

	public List<Player> getSortedByCatches() {
		playerlist = playerdao.getAllPlayers();

		Comparator<Player> sortByCatches = new PlayerCatchesComparator();
		Collections.sort(playerlist, sortByCatches);

		return playerlist;
	}

	public List<Player> getTop3Player() {

		List<Player> runSort = this.getSortedRun();

		List<Player> top3Player = new ArrayList<>();

		for (int i = 0; i < runSort.size() && i < 3; i++) {
			top3Player.add(runSort.get(i));
		}

		return top3Player;
	}

}
