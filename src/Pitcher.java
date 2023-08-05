// we're going to describe all the attributes a 
// Pitcher has
public class Pitcher {
	// "grouping together" these attributes
	String name;
	int control;  // 1 - 100
	int speed;    // 1 - 100
	int stamina;   // how long you can last w/o getting tired 1 - 100
	
	public Pitcher(String name, int control, int speed, int stamina) {
		super();
		this.name = name;
		this.control = control;
		this.speed = speed;
		this.stamina = stamina;
	}

	

}
