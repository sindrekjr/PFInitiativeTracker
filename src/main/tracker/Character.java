package tracker;

public class Character {
	
	private String name;
	private int initiative;
	
	Character(String name) {
		this(name, 0);
	}
	
	Character(String name, int initiative) {
		this.name = name;
		this.initiative = initiative;
	}
	
	public String getName() {
		return name;
	}
	
	public int getInitiative() {
		return this.initiative;
	}
}
