package JDBC_IPL_Oct23;

import java.util.Comparator;

public class PlayerBowlerComaparator implements Comparator<Player> {

	@Override
	public int compare(Player p1, Player p2) {
		return Integer.compare(p2.getWickets(), p1.getWickets());
	}

}
