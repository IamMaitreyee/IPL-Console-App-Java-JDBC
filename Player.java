package JDBC_IPL_Oct23;

public class Player {

	private int id;
	private String name;
	private String teamName;
	private String category;
	private int runs;
	private int wickets;
	private int catches;
	
	public Player() {

	}

	public Player(int id, String name, String teamName, String category, int runs, int wickets, int catches) {
		super();
		this.id = id;
		this.name = name;
		this.teamName = teamName;
		this.category = category;
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

	public String getTeamName() {
		return teamName;
	}

	public String getCategory() {
		return category;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public void setCatches(int catches) {
		this.catches = catches;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", teamName=" + teamName + ", category=" + category + ", runs="
				+ runs + ", wickets=" + wickets + ", catches=" + catches + "]";
	}
	
	
	
	
	
	
}
