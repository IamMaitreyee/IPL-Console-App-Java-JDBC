package JDBC_IPL_Oct23;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayersDao {

	public List<Player> getAllPlayers() {

		List<Player> allPlayers = new ArrayList<>();

		try {
			Connection con = MyDbCong.getSqlConnection();
			Statement st = con.createStatement();
			String query = "Select * from Player";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Player p = new Player();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setTeamName(rs.getString(3));
				p.setCategory(rs.getString(4));
				p.setRuns(rs.getInt(5));
				p.setWickets(rs.getInt(6));
				p.setCatches(rs.getInt(7));

				allPlayers.add(p);
			}

			return allPlayers;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
