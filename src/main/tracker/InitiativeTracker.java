package tracker;

import java.util.Arrays;

public class InitiativeTracker {
	
	private final static int DEFAULT_SIZE = 10;
	
	/**
	 * initialOrder stores the initial sorting of added characters
	 * currentOrder is continually updated in the round method
	 */
	private Character[] initialOrder, currentOrder; // HashMap<Integer, Character[]> ?
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
		if(last == initialOrder.length) {
			initialOrder = Arrays.copyOf(initialOrder, last + DEFAULT_SIZE);
		}
		
		for(int i = 0; i <= last; i++) {
			if(i == last || initialOrder[i].getInitiative() <= character.getInitiative()) {
				System.arraycopy(initialOrder, i, initialOrder, i + 1, last - i);
				initialOrder[i] = character;
				last++;
				return;
			}
		}
	}
	
	public void add(Character character, int amount) {
		for(int i = 0; i < amount; i++) this.add(new Character(character.getName(), character.getInitiative()));
	}
	
	public int size() {
		return this.last;
	}
	
	public void round() {
		if(currentOrder == null) currentOrder = initialOrder;
		round++;
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
