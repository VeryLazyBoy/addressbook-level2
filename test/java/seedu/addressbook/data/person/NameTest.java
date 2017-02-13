package seedu.addressbook.data.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NameTest {
    @Test
    public void namesAreSimilar() throws Exception {
        //null
        assertSimilar(new Name("Frank Liu"), null);
        
        //different case
        assertSimilar(new Name("Frank Liu"), new Name("FRANK LIU"));
    }
    
    public void assertSimilar(Name name, Name other) {
        assertTrue(name.isSimilar(other));
    }
    
    public void assertNotSimilar(Name name, Name other) {
        assertFalse(name.isSimilar(other));
    }
}
