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
			System.out.println("##### Error while reading stats for " + home.teamName);
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
			System.out.println("##### Error while reading stats for " + away.teamName);
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
		int rbis = Integer.parseInt(s.substring(0));
		//System.out.println("***rbis " + rbis);
		s = s.substring(comma + 1);
		
		//int atBats, int hits, int singles, int doubles, int triples, int hrs, int bbs, int rbis,int runs
		return new SeasonStats(ab, hits, singles, doubles, triples, hrs, 0, rbis, runs);
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
				// Don't need to search array for match.
				// the season stats and game stats are both set
				// Just update season stats
				
				//AB   Runs Hits 1B   2B   3B   HR   RBIs 

				h.seasonStats.atBats = h.seasonStats.atBats + h.stats.atBats;
				h.seasonStats.runs = h.seasonStats.runs + h.stats.runs;
				h.seasonStats.hits = h.seasonStats.hits + h.stats.hits;

				h.seasonStats.singles = h.seasonStats.singles + h.stats.singles;
				h.seasonStats.doubles = h.seasonStats.doubles + h.stats.doubles;
				h.seasonStats.triples = h.seasonStats.triples + h.stats.triples;
				
				h.seasonStats.homeRuns = h.seasonStats.homeRuns + h.stats.homeRuns;
				h.seasonStats.runsBattedIn = h.seasonStats.runsBattedIn + h.stats.runsBattedIn;
				
				String s = h.name + "," + h.seasonStats.atBats + "," + h.seasonStats.runs + "," + h.seasonStats.hits + "," 
						+ h.seasonStats.singles + "," + h.seasonStats.doubles + "," + h.seasonStats.triples + "," + h.seasonStats.homeRuns + 
						"," + h.seasonStats.runsBattedIn;
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
				h.seasonStats.runsBattedIn = h.seasonStats.runsBattedIn + h.stats.runsBattedIn;
				
				
				String s = h.name + "," + h.seasonStats.atBats + "," + h.seasonStats.runs + "," + h.seasonStats.hits + "," 
						+ h.seasonStats.singles + "," + h.seasonStats.doubles + "," + h.seasonStats.triples + "," + h.seasonStats.homeRuns + 
						"," + h.seasonStats.runsBattedIn;
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

	
}
