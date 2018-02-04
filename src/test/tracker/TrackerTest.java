package tracker;

import org.junit.Before;
import org.junit.Test;

public class TrackerTest {

    private final static Character character = new Character();
    private Initiative init;

    @Before
    public void setup() {
        init = new Initiative();
    }

    @Test
    public void addSingleCharacterToInitiative() {
        init.add(character);
    }
}
