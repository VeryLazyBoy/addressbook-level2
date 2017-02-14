package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        String trimmedName = name.trim();
        if (!isValidName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = trimmedName;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }
    
    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if 
     * 1. the other name is null, e.g. null
     * 2. the other name is in a different case, e.g.John K SMITh
     * 3. the other name is in a different order, e.g.Smith John K
     * 4. the other name is a subset/superset, e.g.John Smith, John K M Smith
     */
     public boolean isSimilar(Name other) { 
         boolean isSimilar = false;
         
         if (other == null) {
             return true;
         }
         
         isSimilar = isSimilarIgnoringCase(other) || isSubsetOrSuperset(other);
         
         return isSimilar;
     }
     
     /**
      *check if the names are similar in a case-insensitive manner 
      *
      */
     public boolean isSimilarIgnoringCase(Name other) {
         String upperThisName = this.fullName.toUpperCase();
         String upperOtherName = other.fullName.toUpperCase();
         return upperThisName.equals(upperOtherName);
     }
     
     /**
      *check if this name is a subset or superset of the other name 
      *
      */
     public boolean isSubsetOrSuperset(Name other) {
         String thisName = this.fullName;
         String otherName = other.fullName;
         List<String> upperThisNames = Arrays.asList(thisName.toUpperCase().split(" "));
         List<String> upperOtherNames = Arrays.asList(otherName.toUpperCase().split(" "));
         
         return upperThisNames.containsAll(upperOtherNames) || upperOtherNames.containsAll(upperThisNames);
     }
}
