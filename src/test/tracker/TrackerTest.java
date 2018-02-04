package tracker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrackerTest {
	
	private final static Character character = new Character("Draugar");
	private final static int num = 12;
	private InitiativeTracker init;
	
	@Before
	public void setup() {
		init = new InitiativeTracker();
	}
	
	@Test
	public void add_addSingleCharacterToTracker() {
		init.add(character);
		Assert.assertEquals(character, init.getInitialOrder()[0]);
	}
	
	@Test
	public void add_addSeveralCharactersToTracker() {
		for(int i = 1; i <= num; i++) init.add(new Character("Character" + i, i));
	}
	
	@Test
	public void add_checkThatCharactersAreSortedByInitiative() {
		for(int i = 0; i <= num; i++) init.add(new Character("Character" + i, i));
		
		int initiative = num;
		for(int i = 0; i <= num; i++) {
			Assert.assertEquals(initiative--, init.getInitialOrder()[i].getInitiative());
		}
	}
	
	@Test
	public void add_addSeveralGroupsOfCharactersWhereAllInEachGroupHaveEqualInitiative() {
		int initiative = num;
		for(int i = 1; i <= 5; i++) {
			init.add(new Character("Mob" + i, initiative), i);
			initiative /= 2;
		}
	}
	
	@Test
	public void size_assertSizeAfterAddingSeveralCharacters() {
		for(int i = 1; i <= num; i++) init.add(new Character("Character" + i, i));
		Assert.assertEquals(num, init.size());
	}
}
