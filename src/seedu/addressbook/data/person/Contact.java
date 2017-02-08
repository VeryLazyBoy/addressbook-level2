package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public abstract class Contact {
    public final String value;
    private boolean isPrivate;
    
    /**
     * Validates given contact.
     *
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String contact, boolean isPrivate, String errorMsg, String regex) throws IllegalValueException {
        String trimmedContact = contact.trim();
        this.isPrivate = isPrivate;
        if (!isValidContact(trimmedContact, regex)) {
            throw new IllegalValueException(errorMsg);
        }
        this.value = trimmedContact;
    }
    
    /**
     * Returns true if a given string is a valid person contact which matches the given regex.
     */
    public static boolean isValidContact(String test, String regex) {
        return test.matches(regex);
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
