package seedu.addressbook.data.tagging;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {
    private Tag tag;
    private Person person;
    private String action;
    
    /**
     * Every time a Tagging object is created, the info is stored in record field;
     * @param tag the new added/deleted tag
     * @param person the one who add or delete a tag
     * @param action "+" or "-"
     */
    public Tagging(Tag tag, Person person, String action) {
        this.tag = tag;
        this.person = person;
        this.action = action;
    }

    @Override
    public String toString() {
        String record = action + " " + person.getName() + " " + tag.toString();
        return record;
    }
}
