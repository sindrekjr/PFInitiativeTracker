package tracker;

import java.util.Arrays;

public class InitiativeTracker {
	
	private final int DEFAULT_SIZE = 20;
	
	/**
	 * initialOrder stores the initial sorting of added characters
	 * currentOrder is continually updated in the round method
	 */
	private Character[] initialOrder, currentOrder;
	private int last;
	
	/**
	 * round stores the current round number
	 * 0 indicates surprise round or combat has not started
	 */
	private int round;
	
	/**
	 * Constructor. Sets length of initial order to a default size
	 */
	InitiativeTracker() {
		this.initialOrder = new Character[DEFAULT_SIZE];
		this.last = 0;
		this.round = 0;
	}
	
	/**
	 * Overloaded add method, which allows "amount" parameter to default to 1
	 * @param character Character object to add
	 * @throws EqualityException delegates exception to client
	 */
	public void add(Character character) throws EqualityException {
		this.add(character, 1);
	}
	
	/**
	 * Adds objects of the Character class to the InitiativeTracker
	 * @param character Character object to add
	 * @param amount how many duplicates of character to add
	 * @throws EqualityException delegates exception to client
	 */
	public void add(Character character, int amount) throws EqualityException {
		if(last + amount >= initialOrder.length) {
			initialOrder = Arrays.copyOf(initialOrder, last + amount + DEFAULT_SIZE);
		}
		
		for(int i = 0; i <= last; i++) {
			//if(i == last || resolveInitiative(character, initialOrder[i])) {
			if(i == last || character.compareTo(initialOrder[i]) > 0 ) {
				System.arraycopy(initialOrder, i, initialOrder, i + amount, last - i);
				for(int j = 0; j < amount; j++) {
					initialOrder[i + j] = (amount == 1) ? character : new Character(character.getName(), character.getInitiative(), character.getDexterity());
					last++;
				}
				break;
			}
		}
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
