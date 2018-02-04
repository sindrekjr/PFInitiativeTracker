package tracker;

import java.util.Arrays;

public class InitiativeTracker {
	
	private final int DEFAULT_SIZE = 10;
	
	/**
	 * initialOrder stores the initial sorting of added characters
	 * currentOrder is continually updated in the round method
	 */
	private Character[] initialOrder, currentOrder;
	private int last = 0;
	
	/**
	 * round stores the current round number
	 * 0 indicates surprise round or combat has not started
	 */
	private int round;
	
	InitiativeTracker() {
		this.initialOrder = new Character[DEFAULT_SIZE];
		this.round = 0;
	}
	
	public void add(Character character) {
		this.add(character, 1);
	}
	
	public void add(Character character, int amount) {
		if(last + amount >= initialOrder.length) {
			initialOrder = Arrays.copyOf(initialOrder, last + amount + DEFAULT_SIZE);
		}
		
		for(int i = 0; i <= last; i++) {
			if(i == last || resolveInitiative(character, initialOrder[i])) {
				System.arraycopy(initialOrder, i, initialOrder, i + amount, last - i);
				for(int j = 0; j < amount; j++) {
					initialOrder[i + j] = (amount == 1) ? character : new Character(character.getName(), character.getInitiative(), character.getDexterity());
					last++;
				}
				break;
			}
		}
	}
	
	/**
	 * Evaluates whether or not char1 is before char2 in initiative order
	 * @param char1 Character object
	 * @param char2 Character object
	 * @return true if char1 goes first
	 * @throws EqualInitiativeException in cases where initiative has to be resolved by client
	 */
	private boolean resolveInitiative(Character char1, Character char2) throws EqualInitiativeException {
		if(char1.getInitiative() == char2.getInitiative()) {
			if(char1.getDexterity() == char2.getDexterity()) throw new EqualInitiativeException();
			return char1.getDexterity() > char2.getDexterity();
		}
		
		return char1.getInitiative() > char2.getInitiative();
	}
	
	public int size() {
		return this.last;
	}
	
	public void round() {
		if(currentOrder == null) currentOrder = initialOrder;
		
		round++;
		/*Character[] newOrder = new Character[last];
		for(int i = 0; i < last; i++) {
			newOrder[i] = currentOrder[i];
		}
		
		currentOrder = newOrder;*/
	}
	
	public int getRound() {
		return this.round;
	}
	
	public Character[] getInitialOrder() {
		return this.initialOrder;
	}
	
	public Character[] getCurrentOrder() {
		return this.currentOrder;
	}
}
