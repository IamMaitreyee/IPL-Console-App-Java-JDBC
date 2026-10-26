package JDBC_IPL_Oct23;

import java.util.Comparator;

public class PlayerBatsmanComaparator implements Comparator<Player> {

	@Override
	public int compare(Player p1, Player p2) {
        return Integer.compare(p2.getRuns(), p1.getRuns());
	}

}
