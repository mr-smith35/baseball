
public class BaseballData {
	Team crows = new Team();	
	Team cinnamons = new Team();




	public BaseballData() {
		crows.teamName = "Crows";
		crows.managerName = "Sartino";
		
		crows.hitters[0] = new Hitter("Tree Taco",200, 100, 330, 300);
		crows.hitters[1] = new Hitter("Joshua",300, 225, 440, 770);
		crows.hitters[2] = new Hitter("Kathrin",400, 150, 280, 320);

		crows.hitters[3] = new Hitter("Hot",320, 175, 370, 300);

		crows.hitters[4] = new Hitter("Yariv",200, 190, 400, 520);
		crows.hitters[5] = new Hitter("Higo", 240, 160, 310, 220);
		
		crows.hitters[6] = new Hitter("Abandance",100, 100, 310, 190);
		crows.hitters[7] = new Hitter("Clover",200, 175, 330, 200);
		crows.hitters[8] = new Hitter("Zachary",240, 170, 400, 510);

		crows.pitchers[0] = new Pitcher("Joshua", 89, 85, 70 );
		crows.pitchers[1] = new Pitcher("Yariv", 50, 70, 50 );
		crows.pitchers[2] = new Pitcher("Zachary", 65, 65, 65 );
		crows.pitchers[3] = new Pitcher("Aronto", 75, 81, 60 );
		crows.pitchers[4] = new Pitcher("Mackary", 50, 40, 32 ); 
		
		cinnamons.teamName = "Cinnamons";
		cinnamons.managerName = "Jason Orange";
		// 	public Hitter(String name, int extraBasePower, int hrPower, int average, int speed) {
		cinnamons.hitters[0] = new Hitter("Lightning", 100, 0,  340, 800);
		cinnamons.hitters[1] = new Hitter("Bobby Cinnamon",500, 100, 260, 400);
		cinnamons.hitters[2] = new Hitter("Michael Cinnamon",500, 125, 290, 360);
		cinnamons.hitters[3] = new Hitter("BULKY",20, 400, 250, 100);

		cinnamons.hitters[4] = new Hitter("The Truck", 100, 280, 240, 110);
		cinnamons.hitters[5] = new Hitter("The Giant", 050, 300, 220, 100);
		cinnamons.hitters[6] = new Hitter("Smack",300, 150, 310, 350);
		
		cinnamons.hitters[7] = new Hitter("Hitty",220, 100, 290, 250);
		cinnamons.hitters[8] = new Hitter("Jack Cinnamon",100, 100, 230, 200);

		//cinnamons.hitters[8] = new Hitter("Billy",100, 50, 200, 300);

		cinnamons.pitchers[0] = new Pitcher("Fireball Frank", 50, 92, 60 );
		cinnamons.pitchers[1] = new Pitcher("Knuckleball Neal", 40, 10, 95 );
		cinnamons.pitchers[2] = new Pitcher("Strikey", 55, 90, 57 );
		cinnamons.pitchers[3] = new Pitcher("Quad Strikey", 40, 83, 40 );
		cinnamons.pitchers[4] = new Pitcher("Slowball Sue", 30, 13, 80 );

		
		
	}
}
