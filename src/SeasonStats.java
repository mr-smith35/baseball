import java.io.*;

public class SeasonStats {
	int atBats;
	
	int hits;
	int singles;
	int doubles;
	int triples;
	int homeRuns;
	
	int walks;
	int runs;
	int runsBattedIn;
	
	double battingAverage;
	double obp;
	double sluggingAverage;
	double ops;

	public SeasonStats() {
		
	}
	

	public SeasonStats(int atBats, int hits, int singles, int doubles, int triples, int hrs, int bbs, int rbis,
			int runs) {
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
	
	
	
}
