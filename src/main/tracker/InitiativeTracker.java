package tracker;

import java.util.Arrays;

public class InitiativeTracker {

    private final static int DEFAULT_SIZE = 10;

    private Character[] initialOrder; // HashMap<Integer, Character[]> ?
    private int last = 0;

    InitiativeTracker() {
        initialOrder = new Character[DEFAULT_SIZE];
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
	
	public Character[] getInitialOrder() {
		return initialOrder;
	}
}
