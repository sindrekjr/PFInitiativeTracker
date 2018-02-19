package tracker;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
	
	private final static String testName = "TestCharacter";
	private final static int avgInitiative = 10;
	private final static int avgDexterity = 10;
	private Character c;
	
	@BeforeEach
	void setup() {
		c = new Character(testName);
	}
	
	@Test
	void setInitiative_assertThatSetterChangesInitiativeField() {
		c.setInitiative(avgInitiative);
		assertEquals(avgInitiative, c.getInitiative());
	}
	
	@Test
	void setDexterity_assertThatSetterChangesDexterityField() {
		c.setDexterity(avgDexterity);
		assertEquals(avgDexterity, c.getDexterity());
	}

	@Test
	void compareTo_throwsExceptionWhenComparingIdenticalCharacters() {
		assertThrows(EqualityException.class, () -> c.compareTo(c));
	}

	@Test
	void compareTo_throwsExceptionWhenComparingCharactersOfEqualInitiativeAndDexterity() {
		c.setInitiative(avgInitiative);
		c.setDexterity(avgDexterity);
		assertThrows(EqualityException.class, () -> c.compareTo(new Character("Guy", avgInitiative, avgDexterity)));
	}

	@Test
	void verifyThatReadyFieldCanBeChanged() {
		assert(!c.ready);
		c.ready = true;
		assert(c.ready);
	}

	@Test
	void verifyThatDelayFieldCanBeChanged() {
		assert(!c.delay);
		c.delay = true;
		assert(c.delay);
	}
}
