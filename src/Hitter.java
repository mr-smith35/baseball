
public class Hitter {
	String name;
	int extraBasePower;
	int homeRunPower;
	int average;
	int speed;
	
	GameStats stats = new GameStats();
	SeasonStats seasonStats = new SeasonStats();
	
	public Hitter(String name, int extraBasePower, int hrPower, int average, int speed) {
		this.name = name;
		this.extraBasePower = extraBasePower;
		homeRunPower = hrPower;
		this.average = average;
		this.speed = speed;
	}
	
	public void setSeasonStats(SeasonStats s) {
		// TODO Auto-generated method stub
		this.seasonStats = s;
	}

	

	
}
