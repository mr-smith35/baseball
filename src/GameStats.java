
public class GameStats {
	int atBats;
	
	int hits;
	int singles;
	int doubles;
	int triples;
	int homeRuns;
	
	int walks;
	int runs;
	int runsBattedIn;
	
	
	public GameStats(int atBats, int hits, int singles, int doubles, int triples, int hrs, int bbs, int rbis,
			int runs) {
		super();
		this.atBats = atBats;
		this.hits = hits;
		this.singles = singles;
		this.doubles = doubles;
		this.triples = triples;
		this.homeRuns = hrs;
		this.walks = bbs;
		this.runsBattedIn = rbis;
		this.runs = runs;
	}
	
	public GameStats() {
		
	}
	

	
}
