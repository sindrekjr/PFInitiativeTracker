package tracker;

import java.util.Arrays;

public class InitiativeTracker {

    private final static int DEFAULT_SIZE = 10;

    private Character[] initialOrder; // HashMap<Integer, Character[]> ?
    private int first, last = 0;

    public InitiativeTracker() {
        initialOrder = new Character[DEFAULT_SIZE];
    }

    public void add(Character character) {
        if(last == initialOrder.length) {
            initialOrder = Arrays.copyOf(initialOrder, last + DEFAULT_SIZE);
        }
        
        for(int i = 0; i <= last; i++) {
			if(i == last || initialOrder[i].getInitiative() <= character.getInitiative()) {
				for(int j = last; j > i; j--) initialOrder[j] = initialOrder[j - 1];
				initialOrder[i] = character;
				last++;
				return;
			}
		}
    }
	
	public Character[] getInitialOrder() {
		return initialOrder;
	}
}
