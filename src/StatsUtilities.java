import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class StatsUtilities {

	final static int NUM_OF_LEAGUE_STATS_PER_TEAM = 4;  //games, wins, last10, (streak can be derived), last 3 pitchers


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


	public static void readTeamStats(Team home, Team away) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(home.teamName + "LeagueData.txt"));

			String statLine;
			statLine = br.readLine();
			// don't need to call subroutine here, b/c only one stat per line
			int colon = statLine.indexOf(':');
			int games = Integer.parseInt(statLine.substring(colon+1));
			System.out.println("***games " + games);

			statLine = br.readLine();
			// just set the stats, don't need to return anything
			colon = statLine.indexOf(':');
			int wins = Integer.parseInt(statLine.substring(colon+1));
			System.out.println("***wins " + wins);

			statLine = br.readLine();
			colon = statLine.indexOf(':');
			String[] last10 = getLast10(statLine.substring(colon+1));
			System.out.println("***last10 " + java.util.Arrays.toString(last10));

			statLine = br.readLine();
			colon = statLine.indexOf(':');
			String[] last3Pitchers = getLast3(statLine.substring(colon+1));
			System.out.println("***last3Pitchers " + java.util.Arrays.toString(last3Pitchers));

			//return new TeamStats(games, wins, last10, last3Pitchers); 
			// just set the Team Stats in the two Team objects
			home.wins = wins;
			home.last10 = last10;
			home.last3Pitchers = last3Pitchers;

		} catch (Exception e) {
			System.out.println("##### No team file detected, starting new team file for " + home.teamName);
			//e.printStackTrace();
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(away.teamName + "LeagueData.txt"));

			String statLine;
			statLine = br.readLine();
			// don't need to call subroutine here, b/c only one stat per line
			int colon = statLine.indexOf(':');
			int games = Integer.parseInt(statLine.substring(colon+1));
			System.out.println("***games " + games);

			statLine = br.readLine();
			// just set the stats, don't need to return anything
			colon = statLine.indexOf(':');
			int wins = Integer.parseInt(statLine.substring(colon+1));
			System.out.println("***wins " + wins);

			statLine = br.readLine();
			colon = statLine.indexOf(':');
			String[] last10 = getLast10(statLine.substring(colon+1));
			System.out.println("***last10 " + java.util.Arrays.toString(last10));

			statLine = br.readLine();
			colon = statLine.indexOf(':');
			String[] last3Pitchers = getLast3(statLine.substring(colon+1));
			System.out.println("***last3Pitchers " + java.util.Arrays.toString(last3Pitchers));

			//return new TeamStats(games, wins, last10, last3Pitchers); 
			// just set the Team Stats in the two Team objects
			away.wins = wins;
			away.last10 = last10;
			away.last3Pitchers = last3Pitchers;

		} catch (Exception e) {
			System.out.println("##### No league file detected, starting new league file for " + home.teamName);
			//e.printStackTrace();
		}

		// Read in League-wide stats (games, w-l)


	}


	private static String[] getLast3(String s) {
		// "[Slowball Sue, Quad Strikey, Strikey]"
		int comma = s.indexOf(',');
		String p1 = s.substring(1, comma).trim();
		s = s.substring(comma + 1);

		// " Quad Strikey, Strikey]"
		comma = s.indexOf(',');
		String p2 = s.substring(0, comma).trim();
		s = s.substring(comma + 1);

		// ", Strikey]"
		String p3 = s.substring(0, s.length() - 1).trim(); // -1 to eliminate the ]

		return new String[] {p1,p2,p3};

	}


	private static String[] getLast10(String s) {
		// "[l,l,l,l,l,l,l,l,l,w]"
		//  01234567
		String[] last10 = new String[10];
		for(int i = 0; i < last10.length; i++) {
			last10[i] = (s.substring(i*2 + 1,i*2 + 2).equals("w")) ? "w" : "l";
		}
		//		last10[0] = (s.substring(1,2).equals("w")) ? "w" : "l";
		//		last10[1] = (s.substring(3,4).equals("w")) ? "w" : "l";
		//		last10[2] = (s.substring(5,6).equals("w")) ? "w" : "l";
		//		last10[3] = (s.substring(7,8).equals("w")) ? "w" : "l";
		//		last10[4] = (s.substring(9,10).equals("w")) ? "w" : "l";
		//		last10[5] = (s.substring(11,12).equals("w")) ? "w" : "l";
		//		last10[6] = (s.substring(13,14).equals("w")) ? "w" : "l";
		//		last10[7] = (s.substring(15,16).equals("w")) ? "w" : "l";
		//		last10[8] = (s.substring(17,18).equals("w")) ? "w" : "l";
		//		last10[9] = (s.substring(19,20).equals("w")) ? "w" : "l";

		return last10;
	}


	public static void updateTeamStatsAfterGame(Team homeTeam, Team awayTeam, Pitcher homeTeamPitcher, Pitcher awayTeamPitcher, boolean homeTeamVictory) {
		if(homeTeamVictory) {
			homeTeam.wins++;
			// update last 10
		}
		else {
			awayTeam.wins++;
			// update last 10
		}
		homeTeam.games++;
		homeTeam.last3Pitchers[0] = homeTeamPitcher.name;
		homeTeam.last3Pitchers[1] = homeTeam.last3Pitchers[0];
		homeTeam.last3Pitchers[2] = homeTeam.last3Pitchers[1];

		awayTeam.games++;
		awayTeam.last3Pitchers[0] = awayTeamPitcher.name;
		awayTeam.last3Pitchers[1] = awayTeam.last3Pitchers[0];
		awayTeam.last3Pitchers[2] = awayTeam.last3Pitchers[1];
	}

	/** 
	 * This deletes the old Team stats, and then re-writes with the new data
	 */
	public static void writeTeamStats(Team home, Team away) {
		try {

			File file = new File(home.teamName + "LeagueData.txt");
			if (file.delete()) {
				System.out.println("###File " + home.teamName + "LeagueData.txt" +  " deleted successfully");
			}
			else {
				System.out.println("###Failed to delete the file");
			}
			System.out.println("###Creating new Team stats file...");

			BufferedWriter bw = new BufferedWriter(new FileWriter(home.teamName + "LeagueData.txt", true));


			String s1 = "Games:" + home.games;
			String s2 = "Wins:" + home.wins;
			String s3 = "L10:" + java.util.Arrays.toString(home.last10);
			String s4 = "Last3:" + java.util.Arrays.toString(home.last3Pitchers);
			//System.out.println(s);
			bw.write(s1);
			bw.newLine();
			bw.write(s2);
			bw.newLine();
			bw.write(s3);
			bw.newLine();
			bw.write(s4);
			bw.newLine();

			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			File file = new File(away.teamName + "LeagueData.txt");
			if (file.delete()) {
				System.out.println("###File " + away.teamName + "LeagueData.txt" +  " deleted successfully");
			}
			else {
				System.out.println("###Failed to delete the file");
			}
			System.out.println("###Creating new Team stats file...");

			BufferedWriter bw = new BufferedWriter(new FileWriter(away.teamName + "LeagueData.txt", true));


			String s1 = "Games:" + away.games;
			String s2 = "Wins:" + away.wins;
			String s3 = "L10:" + java.util.Arrays.toString(away.last10);
			String s4 = "Last3:" + java.util.Arrays.toString(away.last3Pitchers);
			//System.out.println(s);
			bw.write(s1);
			bw.newLine();
			bw.write(s2);
			bw.newLine();
			bw.write(s3);
			bw.newLine();
			bw.write(s4);
			bw.newLine();

			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




}
