package tracker;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TrackerTest {
	
	private final static Character character = new Character("Draugar");
	private final static int num = 12;
	private InitiativeTracker init;
	
	@BeforeEach
	void setup() {
		init = new InitiativeTracker();
	}
	
	@Test
	void add_addSingleCharacterToTracker() {
		init.add(character);
		assertEquals(character, init.getInitialOrder()[0]);
	}
	
	@Test
	void add_addSeveralCharactersToTracker() {
		for(int i = 1; i <= num; i++) init.add(new Character("Character" + i, i));
	}
	
	@Test
	void add_checkThatCharactersAreSortedByInitiative() {
		for(int i = 0; i <= num; i++) init.add(new Character("Character" + i, i));
		
		int initiative = num;
		for(int i = 0; i <= num; i++) {
			assertEquals(initiative--, init.getInitialOrder()[i].getInitiative());
		}
	}
	
	@Test
	void add_addSeveralGroupsOfCharactersWhereAllInEachGroupHaveEqualInitiativeAndDexterity() {
		int initiative = num;
		for(int i = 1; i <= 5; i++) {
			init.add(new Character("Mob" + i, initiative, num), i);
			initiative /= 2;
		}
	}
	
	@Test
	void add_assertThatCharactersWithEqualInitiativeAreSortedByDexterity() {
		Character highDex = new Character("First", 10, 20);
		Character lowDex = new Character("Second", 10, 8);
		
		init.add(highDex);
		init.add(lowDex);
		assertEquals(highDex, init.getInitialOrder()[0]);
	}
	
	@Test
	void add_throwsExceptionWhenAttemptingToAddIdenticalCharacters() {
		init.add(character);
		assertThrows(EqualityException.class, () -> init.add(character));
	}
	
	@Test
	void add_throwsExceptionWhenAttemptingToAddCharactersWithEqualInitiativeAndDexterity() {
		init.add(new Character("Guy", num, num));
		assertThrows(EqualityException.class, () -> init.add(new Character("Gal", num, num)));
	}
	
	@Test
	void size_assertSizeAfterAddingSeveralCharacters() {
		for(int i = 1; i <= num; i++) init.add(new Character("Character" + i, i));
		assertEquals(num, init.size());
	}
	
	@Test
	void round_assertThatRoundMethodIncrementsRoundCounter() {
		for(int i = 1; i <= num; i++) {
			init.round();
			assertEquals(i, init.getRound());
		}
	}
	
	@Test
	void getCurrentOrder_assertThatCurrentOrderIsEqualToInitialOrderWhenNoSpecialActionsHaveBeenDone() {
		for(int i = 0; i <= num; i++) init.add(new Character("Character" + i, i));
		
		init.round();
		assertArrayEquals(init.getInitialOrder(), init.getCurrentOrder());
	}
	
	/*@Test
	public void getCurrentOrder_assertThatCurrentOrderChangesAfterSpecialActions() {
		for(int i = 0; i <= num; i++) init.add(new Character("Character" + i, i));
		
		init.round();
		Assert.assertNotEquals(init.getInitialOrder(), init.getCurrentOrder());
	}*/
}
