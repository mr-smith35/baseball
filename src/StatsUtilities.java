import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class StatsUtilities {
	public static void readSeasonStats(Team home, Team away) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(home.teamName));
			
			String statLine;
			for(int i = 0; i < home.hitters.length; i++) {
				statLine = br.readLine();

				SeasonStats s = parseStats(statLine);
				home.hitters[i].setSeasonStats(s);
			} 

		} catch (Exception e) {
			System.out.println("##### No season file detected, starting new season file for " + home.teamName);
			//e.printStackTrace();
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(away.teamName));
			
			String statLine;
			for(int i = 0; i < away.hitters.length; i++) {
				statLine = br.readLine();

				SeasonStats s = parseStats(statLine);
				away.hitters[i].setSeasonStats(s);
			} 

		} catch (Exception e) {
			System.out.println("##### No season file detected, starting new season file for " + away.teamName);
			//e.printStackTrace();
		}
		
		// Read in League-wide stats (games, w-l)
		
	}


	public static SeasonStats parseStats(String s) {
		//AB   Runs Hits 1B   2B   3B   HR   RBIs 
		int comma = s.indexOf(',');
		String name = s.substring(0, comma);
		//System.out.println("***name " + name);
		s = s.substring(comma + 1);
		
		comma = s.indexOf(',');
		int ab = Integer.parseInt(s.substring(0, comma));
		//System.out.println("***ab " + ab);
		s = s.substring(comma + 1);
		
		comma = s.indexOf(',');
		int runs = Integer.parseInt(s.substring(0, comma));
		//System.out.println("***runs " + runs);
		s = s.substring(comma + 1);
		
		comma = s.indexOf(',');
		int hits = Integer.parseInt(s.substring(0, comma));
		//System.out.println("***hits " + hits);
		s = s.substring(comma + 1);
		
		comma = s.indexOf(',');
		int singles = Integer.parseInt(s.substring(0, comma));
		//System.out.println("***singles " + singles);
		s = s.substring(comma + 1);
		
		comma = s.indexOf(',');
		int doubles = Integer.parseInt(s.substring(0, comma));
		//System.out.println("***doubles " + doubles);
		s = s.substring(comma + 1);
		
		comma = s.indexOf(',');
		int triples = Integer.parseInt(s.substring(0, comma));
		//System.out.println("***triples " + triples);
		s = s.substring(comma + 1);
		
		comma = s.indexOf(',');
		int hrs = Integer.parseInt(s.substring(0, comma));
		//System.out.println("***hrs " + hrs);
		s = s.substring(comma + 1);
		
		comma = s.indexOf(',');
		int walks = Integer.parseInt(s.substring(0, comma));
		//System.out.println("***walks " + rbis);
		s = s.substring(comma + 1);
		
		comma = s.indexOf(',');
		int rbis = Integer.parseInt(s.substring(0));
		//System.out.println("***rbis " + rbis);
		s = s.substring(comma + 1);
		 
		//int atBats, int hits, int singles, int doubles, int triples, int hrs, int bbs, int rbis,int runs  ***?? order
		return new SeasonStats(ab, hits, singles, doubles, triples, hrs, walks, rbis, runs);
	}
	
	public static void printSeasonStats(Team home, Team away) {
		
	}
	
	public static void updateSeasonStats(Team home, Team away) {

		
		try {
			
			File file = new File(home.teamName);
	        if (file.delete()) {
	            System.out.println("File " + home.teamName +  " deleted successfully");
	        }
	        else {
	            System.out.println("Failed to delete the file");
	        }
            System.out.println("Creating new Season stats file...");

			BufferedWriter bw = new BufferedWriter(new FileWriter(home.teamName, true));
			for(Hitter h : home.hitters) {
				h.seasonStats.atBats = h.seasonStats.atBats + h.stats.atBats;
				h.seasonStats.runs = h.seasonStats.runs + h.stats.runs;
				h.seasonStats.hits = h.seasonStats.hits + h.stats.hits;

				h.seasonStats.singles = h.seasonStats.singles + h.stats.singles;
				h.seasonStats.doubles = h.seasonStats.doubles + h.stats.doubles;
				h.seasonStats.triples = h.seasonStats.triples + h.stats.triples;
				
				h.seasonStats.homeRuns = h.seasonStats.homeRuns + h.stats.homeRuns;
				
				h.seasonStats.walks = h.seasonStats.walks + h.stats.walks;
				
				h.seasonStats.runsBattedIn = h.seasonStats.runsBattedIn + h.stats.runsBattedIn;
				
				String s = h.name + "," + h.seasonStats.atBats + "," + h.seasonStats.runs + "," + h.seasonStats.hits + "," 
						+ h.seasonStats.singles + "," + h.seasonStats.doubles + "," + h.seasonStats.triples + "," + h.seasonStats.homeRuns + 
						"," + h.seasonStats.walks +  "," + h.seasonStats.runsBattedIn;
				System.out.println(s);
				bw.write(s);
				bw.newLine();
			}				        
			bw.flush();
			bw.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			File file = new File(away.teamName);
	        if (file.delete()) {
	            System.out.println("File " + away.teamName +  " deleted successfully");
	        }
	        else {
	            System.out.println("Failed to delete the file");
	        }
            System.out.println("Creating new Season stats file...");
            
			BufferedWriter bw = new BufferedWriter(new FileWriter(away.teamName, true));
			for(Hitter h : away.hitters) {
				h.seasonStats.atBats = h.seasonStats.atBats + h.stats.atBats;
				h.seasonStats.runs = h.seasonStats.runs + h.stats.runs;
				h.seasonStats.hits = h.seasonStats.hits + h.stats.hits;

				h.seasonStats.singles = h.seasonStats.singles + h.stats.singles;
				h.seasonStats.doubles = h.seasonStats.doubles + h.stats.doubles;
				h.seasonStats.triples = h.seasonStats.triples + h.stats.triples;
				
				h.seasonStats.homeRuns = h.seasonStats.homeRuns + h.stats.homeRuns;
				
				h.seasonStats.walks = h.seasonStats.walks + h.stats.walks;

				h.seasonStats.runsBattedIn = h.seasonStats.runsBattedIn + h.stats.runsBattedIn;
				
				
				String s = h.name + "," + h.seasonStats.atBats + "," + h.seasonStats.runs + "," + h.seasonStats.hits + "," 
						+ h.seasonStats.singles + "," + h.seasonStats.doubles + "," + h.seasonStats.triples + "," + h.seasonStats.homeRuns + 
						"," + h.seasonStats.walks +  "," + h.seasonStats.runsBattedIn;
				System.out.println(s);
				bw.write(s);
				bw.newLine();
			}			
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public static void readLeagueStats(Team home, Team away) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(home.teamName + "LeagueData.txt"));
			
			String statLine;
			for(int i = 0; i < home.hitters.length; i++) {
				statLine = br.readLine();

				SeasonStats s = parseLeagueStats(statLine);
				// Do something with League Stats here, set them? 
			} 

		} catch (Exception e) {
			System.out.println("##### No league file detected, starting new league file for " + home.teamName);
			//e.printStackTrace();
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(away.teamName));
			
			String statLine;
			for(int i = 0; i < away.hitters.length; i++) {
				statLine = br.readLine();

				SeasonStats s = parseStats(statLine);
				away.hitters[i].setSeasonStats(s);
			} 

		} catch (Exception e) {
			System.out.println("##### No season file detected, starting new season file for " + away.teamName);
			//e.printStackTrace();
		}
		
		// Read in League-wide stats (games, w-l)
		
		
	}


	private static LeagueStats parseLeagueStats(String statLine) {
		/*Games:270
		Wins:42
		L10:[l,l,l,l,l,l,l,l,l,w]
		Streak:L9
		Last3:[Slowball Sue, Quad Strikey, Strikey]*/
		// TODO Auto-generated method stub
		
		comma = s.indexOf(',');
		int walks = Integer.parseInt(s.substring(0, comma));
		//System.out.println("***walks " + rbis);
		s = s.substring(comma + 1);
		
		comma = s.indexOf(',');
		int rbis = Integer.parseInt(s.substring(0));
		//System.out.println("***rbis " + rbis);
		s = s.substring(comma + 1);
		 
		//int atBats, int hits, int singles, int doubles, int triples, int hrs, int bbs, int rbis,int runs  ***?? order
		return new LeagueStatss(games, wins, last10Wins, String streak, String[] last3GamePitchers);
	}

	
}
