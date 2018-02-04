package tracker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrackerTest {

    private final static Character character = new Character();
    private final static int num = 12;
    private InitiativeTracker init;

    @Before
    public void setup() {
        init = new InitiativeTracker();
    }

    @Test
    public void addSingleCharacterToTracker() {
        init.add(character);
		Assert.assertEquals(character, init.getInitialOrder()[0]);
    }
    
	@Test
	public void addSeveralCharactersToTracker() {
		for(int i = 0; i <= num; i++) init.add(new Character(i));
	}
	
	@Test
	public void checkThatCharactersAreSortedByInitiative() {
		for(int i = 0; i <= num; i++) init.add(new Character(i));
    	
    	int value = num;
		for(int i = 0; i <= num; i++) {
			Assert.assertEquals(value--, init.getInitialOrder()[i].getInitiative());
		}
	}
}
