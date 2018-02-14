package tracker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharacterTest {
	
	private final static String testName = "TestCharacter";
	private final static int avgInitiative = 10;
	private final static int avgDexterity = 10;
	private Character c;
	
	@Before
	public void setup() {
		c = new Character(testName);
	}
	
	@Test
	public void setInitiative_assertThatSetterChangesInitiativeField() {
		c.setInitiative(avgInitiative);
		Assert.assertEquals(avgInitiative, c.getInitiative());
	}
	
	@Test
	public void setDexterity_assertThatSetterChangesDexterityField() {
		c.setDexterity(avgDexterity);
		Assert.assertEquals(avgDexterity, c.getDexterity());
	}

	@Test(expected = EqualityException.class)
	public void compareTo_throwsExceptionWhenComparingIdenticalCharacters() {
		c.compareTo(c);
	}

	@Test(expected = EqualityException.class)
	public void compareTo_throwsExceptionWhenComparingCharactersOfEqualInitiativeAndDexterity() {
		c.setInitiative(avgInitiative);
		c.setDexterity(avgDexterity);
		c.compareTo(new Character("Guy", avgInitiative, avgDexterity));
	}

	@Test
	public void verifyThatReadyFieldCanBeChanged() {
		assert(!c.ready);
		c.ready = true;
		assert(c.ready);
	}

	@Test
	public void verifyThatDelayFieldCanBeChanged() {
		assert(!c.delay);
		c.delay = true;
		assert(c.delay);
	}
}
