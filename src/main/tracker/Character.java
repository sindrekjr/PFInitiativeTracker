package tracker;

public class Character {
	
	private String name;
	private int initiative, dexterity;
	
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
	
	public int getDexterity() {
		return dexterity;
	}
	
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
}
