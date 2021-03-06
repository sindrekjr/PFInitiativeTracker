package tracker;

import org.jetbrains.annotations.NotNull;

public class Character implements Comparable<Character> {
	
	private String name;
	private Integer initiative, dexterity;

	/**
	 * ready and delay track whether or not given character has activated either special action
	 */
	boolean ready, delay = false;
	
	Character(String name) {
		this(name, 0);
	}
	
	Character(String name, Integer initiative) {
		this(name, initiative, null);
	}
	
	Character(String name, Integer initiative, Integer dexterity) {
		this.name = name;
		setInitiative(initiative);
		setDexterity(dexterity);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getInitiative() {
		return this.initiative;
	}
	
	public int getDexterity() {
		return this.dexterity;
	}
	
	public void setInitiative(Integer initiative) {
		this.initiative = initiative;
	}
	
	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public int compareTo(@NotNull Character character) throws EqualityException {
		if(this == character) throw new EqualityException();

		if(this.getInitiative() != character.getInitiative()) {
			return this.getInitiative() - character.getInitiative();
		} else if(this.getDexterity() != character.getDexterity()) {
			return this.getDexterity() - character.getDexterity();
		} else {
			throw new EqualityException();
		}
	}
	
	public void setReady(boolean ready) {
		if(this.delay && ready) setDelay(false);
		this.ready = ready;
	}
	
	public void setDelay(boolean delay) {
		if(this.ready && delay) setReady(false);
		this.delay = delay;
	}
}
