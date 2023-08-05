
// Java programming language
public class BaseballGame {

	BaseballData data = new BaseballData();
	Team homeTeam;
	Team awayTeam;

	Pitcher homeTeamPitcher;
	Pitcher awayTeamPitcher;

	int currentBatterHome = 0;
	int currentBatterAway = 0;

	int homeTeamScore = 0;
	int awayTeamScore = 0;

	final int OUT = 0, SINGLE = 1, DOUBLE = 2, TRIPLE = 3, HOME_RUN = 4;
	final int FIRST_BASE = 0, SECOND_BASE = 1, THIRD_BASE = 2;

	public void startGame() {
		System.out.println("Hello, welcome to the baseball game between the Crows and the Cinnamons");
		System.out.println("Today's weather is: " + getRandomWeather());

		// generate a random number (0, 1), then pick the home team based off of that		
		int randNumber = (int)(Math.random()*2); 
		if(randNumber == 0) {
			homeTeam = data.crows;
			awayTeam = data.cinnamons;
		}
		else {
			homeTeam = data.cinnamons;
			awayTeam = data.crows;
		}

		System.out.println("The home team is The " + homeTeam.teamName);
		System.out.println("The visting team is The " + awayTeam.teamName);
		//SeasonStats.updateSeasonStats(homeTeam, awayTeam);
		StatsUtilities.readSeasonStats(homeTeam, awayTeam);

		choosePitchers();

		int inning = 1;
		while(inning <= 19) {
			playInning(false, inning);
			playInning(true, inning);
			if(inning >= 9 && homeTeamScore > awayTeamScore ) {
				System.out.println("*** 2"
						+ "0"
						+ ""
						+ " OVER!!! ***"); // game is over
				System.out.println("*** The " + homeTeam.teamName + " win, "
						+ homeTeamScore + " to " + awayTeamScore + "***"); // game is over
				break;  // exit loop
			}
			else if(inning >= 9 && awayTeamScore > homeTeamScore ) {
				System.out.println("*** GAME OVER!!! ***"); // game is over
				System.out.println("*** The " + awayTeam.teamName + " win, "
						+ awayTeamScore + " to " + homeTeamScore + "***"); // game is over
				break; 
			}
			inning++;
		}
		System.out.println("*** Final Game Box Score ***");
		printScoreboard();
	
		StatsUtilities.updateSeasonStats(homeTeam, awayTeam);
		printSeasonStats();
	}



	private String getInning(int i) {
		if(i == 1) {
			return "first";
		}
		else if(i == 2) {
			return "second";
		}
		else if(i == 3) {
			return "third";
		}
		else if(i == 4) {
			return "fourth";
		}
		else if(i == 5) {
			return "fifth";
		}
		else if(i == 6) {
			return "sixth";
		}
		else if(i == 7) {
			return "seventh";
		}
		else if(i == 8) {
			return "eighth";
		}
		else if(i == 9) {
			return "ninth";
		}
		else if(i == 10) {
			return "tenth";
		}
		else if(i == 11) {
			return "eleventh";
		}
		else if(i == 12) {
			return "twelfth";
		}
		else if(i == 13) {
			return "thirteenth";
		}
		else if(i == 14) {
			return "fourteenth";
		}
		else if(i == 15) {
			return "fifteenth";
		}
		else if(i == 16) {
			return "sixteenth";
		}
		else if(i == 17) {
			return "seventeenth";
		}
		else if(i == 18) {
			return "eighteenth";
		}
		else {
			return "nineteenth";
		}
	}
	
	private void printScoreboard() {
		System.out.printf("%-20s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%-5s\n", homeTeam.teamName, "AB", "Runs", "Hits", "1B", "2B", "3B", "HR", "RBIs");
		for(int i = 0; i < homeTeam.hitters.length; i++) {
			System.out.printf("%-20s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%-5s", (i+1) + ") " + homeTeam.hitters[i].name, homeTeam.hitters[i].stats.atBats,
					homeTeam.hitters[i].stats.runs, homeTeam.hitters[i].stats.hits, homeTeam.hitters[i].stats.singles, homeTeam.hitters[i].stats.doubles,
					homeTeam.hitters[i].stats.triples, homeTeam.hitters[i].stats.homeRuns, homeTeam.hitters[i].stats.runsBattedIn);
			System.out.println();
		}
		
		System.out.println();

		System.out.printf("%-20s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%-5s\n", awayTeam.teamName, "AB", "Runs", "Hits", "1B", "2B", "3B", "HR", "RBIs");
		for(int i = 0; i < awayTeam.hitters.length; i++) {
			System.out.printf("%-20s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%-5s", (i+1) + ") " + awayTeam.hitters[i].name, awayTeam.hitters[i].stats.atBats,
					awayTeam.hitters[i].stats.runs, awayTeam.hitters[i].stats.hits, awayTeam.hitters[i].stats.singles, awayTeam.hitters[i].stats.doubles,
					awayTeam.hitters[i].stats.triples, awayTeam.hitters[i].stats.homeRuns, awayTeam.hitters[i].stats.runsBattedIn);
			System.out.println();

		}
	}
	
	private void printSeasonStats() {
		System.out.println("************************* Season Stats *************************");
		System.out.printf("%-20s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%-5s\n", homeTeam.teamName, "AB", "Runs", "Hits", "1B", "2B", "3B", "HR", "RBIs");
		for(int i = 0; i < homeTeam.hitters.length; i++) {
			System.out.printf("%-20s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%-5s", (i+1) + ") " + homeTeam.hitters[i].name, homeTeam.hitters[i].seasonStats.atBats,
					homeTeam.hitters[i].seasonStats.runs, homeTeam.hitters[i].seasonStats.hits, homeTeam.hitters[i].seasonStats.singles, homeTeam.hitters[i].seasonStats.doubles,
					homeTeam.hitters[i].seasonStats.triples, homeTeam.hitters[i].seasonStats.homeRuns, homeTeam.hitters[i].seasonStats.runsBattedIn);
			System.out.println();
		}
		
		System.out.println();

		System.out.printf("%-20s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%-5s\n", awayTeam.teamName, "AB", "Runs", "Hits", "1B", "2B", "3B", "HR", "RBIs");
		for(int i = 0; i < awayTeam.hitters.length; i++) {
			System.out.printf("%-20s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%-5s", (i+1) + ") " + awayTeam.hitters[i].name, awayTeam.hitters[i].seasonStats.atBats,
					awayTeam.hitters[i].seasonStats.runs, awayTeam.hitters[i].seasonStats.hits, awayTeam.hitters[i].seasonStats.singles, awayTeam.hitters[i].seasonStats.doubles,
					awayTeam.hitters[i].seasonStats.triples, awayTeam.hitters[i].seasonStats.homeRuns, awayTeam.hitters[i].seasonStats.runsBattedIn);
			System.out.println();

		}
		System.out.println("************************* End Season Stats *************************");

	}

	private void playInning(boolean homeTeamAtBat, int inning) {
		if(homeTeamAtBat == false) {
			System.out.println("Welcome to the top of the " + getInning(inning) + " inning.");
		}
		else {
			System.out.println("Welcome to the bottom of the " + getInning(inning) + " inning.");
		}
		System.out.println("*** Current Box Score ***");
		printScoreboard();
		System.out.println("Press enter to continue");
		TextIO.getlnString();

		boolean[] basesOccupied = new boolean[]{false, false, false};
		Hitter[] playersOnBase = new Hitter[] {null, null, null};

		int numberOfOuts = 0;


		while(numberOfOuts < 3) {
			// keep playing inning until 3 outs
			// 2 exceptions:
			// (1): if visiting team is up and they are behind in the 9th and they don't tie/take the lead --> game ends
			// (2): if home team is batting in the bottom 9th inning and goes ahead --> the game ends


			if(homeTeamAtBat) {  // if Home team is up
				//				System.out.println("Batting " + translate(currentBatterHome) + ", for the " +
				//						homeTeam.teamName + ", " + homeTeam.hitters[currentBatterHome].name);

				String diamond = getCurrentBaseRunners(playersOnBase, homeTeam.hitters[currentBatterHome], awayTeamPitcher);
				diamond = diamond + "\n[Score - " + homeTeam.teamName + ": " + homeTeamScore + ", " + awayTeam.teamName + ": " + awayTeamScore + "]\n";
				diamond = diamond + "INNING: " + getInning(inning) + ", OUTS: " + numberOfOuts + ".";
				System.out.println(diamond);

				int result = calculateResult(homeTeam.hitters[currentBatterHome], awayTeamPitcher);
				if(result == OUT) {
					int rand = (int)(Math.random()*3);
					if(rand == 0) {
						System.out.println(homeTeam.hitters[currentBatterHome].name + " grounds out!");
					}
					else if(rand == 1) {
						System.out.println(homeTeam.hitters[currentBatterHome].name + " flies out!");
					}
					else {
						System.out.println(homeTeam.hitters[currentBatterHome].name + " strikes out!!!");
					}
					numberOfOuts++;
				}
				else {
					advanceBaseRunners(result, basesOccupied, playersOnBase, homeTeam.hitters[currentBatterHome], true);
				}
				// check if game is over - home team took lead in bottom of 9th
				if(inning >= 9 && homeTeamScore > awayTeamScore) {
					System.out.println("*** GAME OVER!!! ***"); // game is over
					System.out.println("*** The " + homeTeam.teamName + " win, "
							+ homeTeamScore + " to " + awayTeamScore + "***"); // game is over
					System.out.println("*** Final Game Box Score ***");
					printScoreboard();
				
					StatsUtilities.updateSeasonStats(homeTeam, awayTeam);
					printSeasonStats();
					
					System.exit(0); // stop program
				}

				currentBatterHome = currentBatterHome + 1;
				if(currentBatterHome == 9) {
					currentBatterHome = 0;
				}

			}
			else {    // if Away team is up
				String diamond = getCurrentBaseRunners(playersOnBase, awayTeam.hitters[currentBatterAway], homeTeamPitcher);
				diamond = diamond + "\n[Score - " + homeTeam.teamName + ": " + homeTeamScore + ", " + awayTeam.teamName + ": " + awayTeamScore + "]\n";
				diamond = diamond + "INNING: " + getInning(inning) + ", OUTS: " + numberOfOuts + ".";
				System.out.println(diamond);

				int result = calculateResult(awayTeam.hitters[currentBatterAway], homeTeamPitcher);
				if(result == OUT) {
					int rand = (int)(Math.random()*3);
					if(rand == 0) {
						System.out.println(awayTeam.hitters[currentBatterAway].name + " grounds out!");
					}
					else if(rand == 1) {
						System.out.println(awayTeam.hitters[currentBatterAway].name + " flies out!");
					}
					else {
						System.out.println(awayTeam.hitters[currentBatterAway].name + " strikes out!!!");
					}
					numberOfOuts++;
				}
				else {
					advanceBaseRunners(result, basesOccupied, playersOnBase, awayTeam.hitters[currentBatterAway],  false);
				}
				currentBatterAway = currentBatterAway + 1;
				if(currentBatterAway == 9) {
					currentBatterAway = 0;
				
				}

			}
			System.out.println("....press enter to continue");
			TextIO.getlnString();
		}
		// check if game is over - visiting team got out in the 9th and are losing -- no need for home team to bat
		if(inning >= 9 && homeTeamAtBat == false && homeTeamScore > awayTeamScore) {
			System.out.println("*** GAME OVER!!! ***"); // game is over
			System.out.println("*** The " + homeTeam.teamName + " win, "
					+ homeTeamScore + " to " + awayTeamScore + "***"); // game is over
			System.out.println("*** Final Game Box Score ***");
			printScoreboard();		
			
			StatsUtilities.updateSeasonStats(homeTeam, awayTeam);
			printSeasonStats();

			System.exit(0); // stop program
		}

	}


	private void incrementScore(boolean isHomeTeam) {
		if(isHomeTeam) {
			homeTeamScore = homeTeamScore + 1;
			System.out.println(homeTeam.teamName + " scores!  The score is " + homeTeam.teamName + ": " 
					+ homeTeamScore + ", " + awayTeam.teamName + ": "  + awayTeamScore );
		}
		else {
			awayTeamScore = awayTeamScore + 1;
			System.out.println(awayTeam.teamName + " scores!  The score is " + homeTeam.teamName + ": " 
					+ homeTeamScore + ", " + awayTeam.teamName + ": "  + awayTeamScore );
		}
	}

	private void advanceBaseRunners(int result, boolean[] basesOccupied, Hitter[] playersOnBase, Hitter currentBatter, boolean isHomeTeam) {
		if(result == SINGLE) {  // just move all runners up one base.
			if(basesOccupied[THIRD_BASE]) {
				basesOccupied[THIRD_BASE] = false;
				playersOnBase[THIRD_BASE].stats.runs++; 
				currentBatter.stats.runsBattedIn++;
				playersOnBase[THIRD_BASE] = null;
				if(isHomeTeam) {
					incrementScore(true);
				}
				else {
					incrementScore(false);
				}
			}
			if(basesOccupied[SECOND_BASE] == true) {
				basesOccupied[THIRD_BASE] = true;
				playersOnBase[THIRD_BASE] = playersOnBase[SECOND_BASE]; // guy on 2nd advances to third

				basesOccupied[SECOND_BASE] = false;
				playersOnBase[SECOND_BASE] = null;   // no longer on second
			}
			if(basesOccupied[FIRST_BASE] == true) {
				basesOccupied[SECOND_BASE] = true;
				playersOnBase[SECOND_BASE] = playersOnBase[FIRST_BASE]; // guy on 1st advances to second

				basesOccupied[FIRST_BASE] = false;
				playersOnBase[FIRST_BASE] = null;   // no longer on first

			}
			basesOccupied[FIRST_BASE] = true;
			playersOnBase[FIRST_BASE] = currentBatter;   // guy who hit single is now on first
			//currentBatter.stats.singles++;  // already did this inside calculateResults() function
			return;
		}
		else if(result == DOUBLE) {
			if(basesOccupied[THIRD_BASE]) {
				basesOccupied[THIRD_BASE] = false;
				playersOnBase[THIRD_BASE].stats.runs++; 
				currentBatter.stats.runsBattedIn++;
				playersOnBase[THIRD_BASE] = null;   // guy on third scores, now he is no longer on third
				if(isHomeTeam) {
					incrementScore(true);
				}
				else {
					incrementScore(false);
				}
			}
			if(basesOccupied[SECOND_BASE] == true) {
				basesOccupied[SECOND_BASE] = false;
				playersOnBase[SECOND_BASE].stats.runs++; 
				currentBatter.stats.runsBattedIn++;
				playersOnBase[SECOND_BASE] = null;   // guy on second scores, now he is no longer on second

				if(isHomeTeam) {
					incrementScore(true);
				}
				else {
					incrementScore(false);
				}
			}
			if(basesOccupied[FIRST_BASE] == true) {
				basesOccupied[THIRD_BASE] = true;
				playersOnBase[THIRD_BASE] = playersOnBase[FIRST_BASE]; // for a double, advance guy on 1st to 3rd. 

				basesOccupied[FIRST_BASE] = false;
				playersOnBase[FIRST_BASE] = null;   // no longer on first
			}
			basesOccupied[SECOND_BASE] = true;
			playersOnBase[SECOND_BASE] = currentBatter;  // guy who hit double is now on 2nd
		//	currentBatter.stats.doubles++;
			return;
		}
		else if(result == TRIPLE) {
			if(basesOccupied[THIRD_BASE]) {
				basesOccupied[THIRD_BASE] = false;
				playersOnBase[THIRD_BASE].stats.runs++; 
				currentBatter.stats.runsBattedIn++;
				playersOnBase[THIRD_BASE] = null;   // guy on third scores, now he is no longer on third
			
				if(isHomeTeam) {
					incrementScore(true);
				}
				else {
					incrementScore(false);
				}
				
			}
			if(basesOccupied[SECOND_BASE] == true) {
				basesOccupied[SECOND_BASE] = false;
				playersOnBase[SECOND_BASE].stats.runs++; 
				currentBatter.stats.runsBattedIn++;
				playersOnBase[SECOND_BASE] = null;   // guy on second scores, now he is no longer on second

				if(isHomeTeam) {
					incrementScore(true);
				}
				else {
					incrementScore(false);
				}
			}
			if(basesOccupied[FIRST_BASE] == true) {
				basesOccupied[FIRST_BASE] = false;
				playersOnBase[FIRST_BASE].stats.runs++; 
				currentBatter.stats.runsBattedIn++;
				playersOnBase[FIRST_BASE] = null;   // guy on first scores, now he is no longer on first


				if(isHomeTeam) {
					incrementScore(true);
				}
				else {
					incrementScore(false);
				}
			}
			basesOccupied[THIRD_BASE] = true;
			playersOnBase[THIRD_BASE] = currentBatter;   // guy who tripled now on 3rd
			return;
		}
		else if(result == HOME_RUN) {
			if(basesOccupied[THIRD_BASE]) {
				basesOccupied[THIRD_BASE] = false;
				playersOnBase[THIRD_BASE].stats.runs++; 
				currentBatter.stats.runsBattedIn++;
				playersOnBase[THIRD_BASE] = null;   // guy on third scores, now he is no longer on third

				if(isHomeTeam) {
					incrementScore(true);
				}
				else {
					incrementScore(false);
				}
			}
			if(basesOccupied[SECOND_BASE] == true) {
				basesOccupied[SECOND_BASE] = false;
				playersOnBase[SECOND_BASE].stats.runs++; 
				currentBatter.stats.runsBattedIn++;
				playersOnBase[SECOND_BASE] = null;   // guy on second scores, now he is no longer on second

				if(isHomeTeam) {
					incrementScore(true);
				}
				else {
					incrementScore(false);
				}
			}
			if(basesOccupied[FIRST_BASE] == true) {
				basesOccupied[FIRST_BASE] = false;
				playersOnBase[FIRST_BASE].stats.runs++; 
				currentBatter.stats.runsBattedIn++;
				playersOnBase[FIRST_BASE] = null;   // guy on first scores, now he is no longer on first

				if(isHomeTeam) {
					incrementScore(true);
				}
				else {
					incrementScore(false);
				}
			}
			// for a home run, you get a run and an RBI
			currentBatter.stats.runsBattedIn++;
			currentBatter.stats.runs++;
			if(isHomeTeam) {
				incrementScore(true);
			}
			else {
				incrementScore(false);
			}
			return;
		}

	}




	// calculates the result of the Pitcher versus the hitter.
	// Returns either 0 (out), 1 (single), 2 (double), 3 (triple), or 4 (home run)
	private int calculateResult(Hitter h, Pitcher p) {
		int rand = (int)(Math.random()*1000) + 1;
		//	System.out.println("rand: " + rand);

		int pitcherSkillFactor = (p.control - 50) + (p.speed - 50);
		int adjustedBattingAverage = (h.average - pitcherSkillFactor);

		//System.out.println("pitcherSkillFactor: " + pitcherSkillFactor);3
		//System.out.println("adjustedBattingAverage: " + adjustedBattingAverage);
		
		h.stats.atBats++;  
		
		if(rand < adjustedBattingAverage) { // it's a hit
			h.stats.hits++;
			int rand2 = (int)(Math.random()*1000) + 1;  
			// check if it's a home run
			if(rand2 < h.homeRunPower) {
				System.out.println(h.name + " " + getRandomAdjective() + " a HOME RUN!!!");
				h.stats.homeRuns = h.stats.homeRuns + 1;
				return HOME_RUN;
			}
			else if(rand2 < h.extraBasePower) { //it's a double or triple
				int i = (int)(Math.random()*100);
				if (i < 10) {
					System.out.println(h.name + " " + getRandomAdjective() + " a triple!!");
					h.stats.triples++;
					return TRIPLE; // 10% of triple
				}
				else {
					System.out.println(h.name + " " + getRandomAdjective() + " a double!");
					h.stats.doubles++;
					return DOUBLE;
				}
			}
			System.out.println(h.name + " " + getRandomAdjective() + " a base hit.");
			h.stats.singles++;
			return SINGLE;
		}
		else {  //it's an out
			return OUT;  // return 0
		}
	}
	
	private String getRandomAdjective() {
		int rand = (int)(Math.random()*7);
		switch(rand) {
		case 0:
			return "blasts";
		case 1:
			return "kills";
		case 2:
			return "pounds";
		case 3:
			return "slices";
		case 4:
			return "smashes";
		case 5:
			return "cracks";
		case 6:
			return "hammers";
		default:
			return "belts";
		}
	}

	private void choosePitchers() {
		int userChoice;
		do {
			System.out.println("***Home Team, select your pitcher***");

			for(int i = 0; i < homeTeam.pitchers.length; i++) {
				System.out.println(i + ": " + homeTeam.pitchers[i].name + ", control: " 
						+ homeTeam.pitchers[i].control + ", speed: " + homeTeam.pitchers[i].speed 
						+ ", stamina: " + homeTeam.pitchers[i].stamina);
			}
			System.out.print("Selection: ");
			userChoice = TextIO.getlnInt();
		} while(userChoice < 0 || userChoice > 4);
		homeTeamPitcher = homeTeam.pitchers[userChoice];

		do {
			System.out.println("***Away Team, select your pitcher***");

			for(int i = 0; i < awayTeam.pitchers.length; i++) {
				System.out.println(i + ": " + awayTeam.pitchers[i].name + ", control: " 
						+ awayTeam.pitchers[i].control + ", speed: " + awayTeam.pitchers[i].speed 
						+ ", stamina: " + awayTeam.pitchers[i].stamina);
			}
			System.out.print("Selection: ");
			userChoice = TextIO.getlnInt();
		} while(userChoice < 0 || userChoice > 4);
		awayTeamPitcher = awayTeam.pitchers[userChoice];

		System.out.println("*** OK!  Today's pitchers are..."
				+ " for the home team: " + homeTeamPitcher.name + ", and for the away team: "
				+ awayTeamPitcher.name);
	}

	private String getRandomWeather() {
		int rand = (int)(Math.random()*10); // generate random number from 0 to 9.
		if(rand < 6) {
			return "sunny";
		}
		else if(rand == 7) {
			return "cloudy";
		}
		else if(rand == 8) {
			return "windy";
		}
		else {
			return "rainy";
		}
	}

	private String getCurrentBaseRunners(Hitter[] baseRunners, Hitter batter, Pitcher currentPitcher) {
		String diamond = 
				"                          .&&&.                           \n" + 
						"                  &&                     &&                 \n" + 
						"              &             &   &             &             \n" + 
						"          .                  & &                  .         \n" + 
						"        &                  &&& &&&                  &       \n" + 
						"      &                 &&         &&                 &     \n" + 
						"    &                 &               &                 &   \n" + 
						"   &               &&                   &&               &  \n" + 
						"  &              &                         &              & \n" + 
						" &            &&                             &&            &\n" + 
						" .          &                                   &           \n" + 
						"     &&   &               &       &               &   &&    \n" + 
						" ( &    &  *             # &&&&&&& %             ,  &    & (\n" + 
						"   & &*   &               &       &               &   *& &  \n" + 
						"      (     &                &&&                &     (     \n" + 
						"        &      &                             &      &       \n" + 
						"           (     &                         &     (          \n" + 
						"             &      &                   &      &            \n" + 
						"                #     &               &     (               \n" + 
						"                  &      &         &      &                 \n" + 
						"                     #     &&   &&     #                    \n" + 
						"                       &    &&&&&    &                      \n" + 
						"                         &   &&&   &                        \n" + 
						"                          &   ,   &                       ";

		String smallDiamond = 
				"                      &&&                       \n" + 
						"              #&         &         &#             \n" + 
						"          &            %"+getSecond(baseRunners)+"%            &         \n" + 
						"                         &                        \n" + 
						"     &               &       &               &    \n" + 
						"                  &             &                 \n" + 
						"  ,             &                 &             , \n" + 
						"             &                       &            \n" + 
						"          &                           &          \n" + 
						"        &             &     &             &       \n" + 
						"  "+getThird(baseRunners)+"    &          "+currentPitcher.name+" &        "+getFirst(baseRunners)+"& & # \n" + 
						"   &    &#            &     &            #&    &  \n" + 
						"           &            . .            &          \n" + 
						"        &    #&                     &#    &       \n" + 
						"                &                 &               \n" + 
						"             &    ,&           &,    &            \n" + 
						"                     &       &                    \n" + 
						"                  &   & &&& &   &                 \n" + 
						"                     & &&&&& &                    \n" + 
						"                      "+batter.name+"              ";


		return smallDiamond;
	}

	private String getFirst(Hitter[] hitters) {
		if(hitters[FIRST_BASE] == null) {
			return "   ";
		}
		else {
			return hitters[FIRST_BASE].name;
		}
	}

	private String getSecond(Hitter[] hitters) {
		if(hitters[SECOND_BASE] == null) {
			return "   ";
		}
		else {
			return hitters[SECOND_BASE].name;
		}
	}

	private String getThird(Hitter[] hitters) {
		if(hitters[THIRD_BASE] == null) {
			return "   ";
		}
		else {
			return hitters[THIRD_BASE].name;
		}
	}





}
