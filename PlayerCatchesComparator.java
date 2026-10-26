package JDBC_IPL_Oct23;

import java.util.Comparator;

public class PlayerCatchesComparator implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		return Integer.compare(o2.getCatches(), o1.getCatches());
	}

}
