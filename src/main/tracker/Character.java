package tracker;

public class Character implements Comparable<Character> {
	
	private String name;
	private int initiative, dexterity;
	
	Character(String name) {
		this(name, 0);
	}
	
	Character(String name, int initiative) {
		this.name = name;
		this.initiative = initiative;
	}
	
	Character(String name, int initiative, int dexterity) {
		this.name = name;
		this.initiative = initiative;
		this.dexterity = dexterity;
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

    @Override
    public int compareTo(Character character) throws EqualInitiativeException {
	    if(this.getInitiative() != character.getInitiative()) {
	        return this.getInitiative() - character.getInitiative();
        } else if(this.getDexterity() != character.getDexterity()) {
	        return this.getDexterity() - character.getDexterity();
        } else {
	        throw new EqualInitiativeException();
        }
    }
}
