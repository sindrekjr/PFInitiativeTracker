package java.tracker;

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
	public void add_addSeveralGroupsOfCharactersWhereAllInEachGroupHaveEqualInitiativeAndDexterity() {
		int initiative = num;
		for(int i = 1; i <= 5; i++) {
			init.add(new Character("Mob" + i, initiative, num), i);
			initiative /= 2;
		}
	}
	
	@Test
	public void add_assertThatCharactersWithEqualInitiativeAreSortedByDexterity() {
		Character highDex = new Character("First", 10, 20);
		Character lowDex = new Character("Second", 10, 8);
		
		init.add(highDex);
		init.add(lowDex);
		Assert.assertEquals(highDex, init.getInitialOrder()[0]);
	}
	
	@Test(expected = EqualityException.class)
	public void add_throwsExceptionWhenAttemptingToAddIdenticalCharacters() {
		init.add(character);
		init.add(character);
	}
	
	@Test(expected = EqualityException.class)
	public void add_throwsExceptionWhenAttemptingToAddCharactersWithEqualInitiativeAndDexterity() {
		init.add(new Character("Guy", num, num));
		init.add(new Character("Gal", num, num));
	}
	
	@Test
	public void size_assertSizeAfterAddingSeveralCharacters() {
		for(int i = 1; i <= num; i++) init.add(new Character("Character" + i, i));
		Assert.assertEquals(num, init.size());
	}
	
	@Test
	public void round_assertThatRoundMethodIncrementsRoundCounter() {
		for(int i = 1; i <= num; i++) {
			init.round();
			Assert.assertEquals(i, init.getRound());
		}
	}
	
	@Test
	public void getCurrentOrder_assertThatCurrentOrderIsEqualToInitialOrderWhenNoSpecialActionsHaveBeenDone() {
		for(int i = 0; i <= num; i++) init.add(new Character("Character" + i, i));
		
		init.round();
		Assert.assertArrayEquals(init.getInitialOrder(), init.getCurrentOrder());
	}
	
	/*@Test
	public void getCurrentOrder_assertThatCurrentOrderChangesAfterSpecialActions() {
		for(int i = 0; i <= num; i++) init.add(new Character("Character" + i, i));
		
		init.round();
		Assert.assertNotEquals(init.getInitialOrder(), init.getCurrentOrder());
	}*/
}
