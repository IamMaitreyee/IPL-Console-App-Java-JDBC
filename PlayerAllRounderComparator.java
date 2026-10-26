package JDBC_IPL_Oct23;

import java.util.Comparator;

public class PlayerAllRounderComparator implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {

		int runcompare = Integer.compare(o2.getRuns(), o1.getRuns());

		if (runcompare == 0) {
			return Integer.compare(o2.getWickets(), o1.getWickets());
		}

		return runcompare;
	}

}
