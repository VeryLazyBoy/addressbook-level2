package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";
    
    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    public static String[] getWelcomeMessage(String version, String storageFilePath) {
    	ArrayList<String> msgList = new ArrayList<String>(); 
    	String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    	msgList.add(DIVIDER);
    	msgList.add(DIVIDER);
    	msgList.add(MESSAGE_WELCOME);
    	msgList.add(version);
    	msgList.add(MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE);
    	msgList.add(storageFileInfo);
    	msgList.add(DIVIDER);
    	Object[] messages = msgList.toArray();
    	return Arrays.copyOf(messages, messages.length, String[].class);
    }
    
    public static String[] getGoodbyeMessage() {
    	ArrayList<String> msgList = new ArrayList<String>(); 
    	msgList.add(MESSAGE_GOODBYE);
    	msgList.add(DIVIDER);
    	msgList.add(DIVIDER);
    	Object[] messages = msgList.toArray();
    	return Arrays.copyOf(messages, messages.length, String[].class);
    }

    public static String[] getInitFailedMessage() {
    	ArrayList<String> msgList = new ArrayList<String>(); 
    	msgList.add(MESSAGE_INIT_FAILED);
    	msgList.add(DIVIDER);
    	msgList.add(DIVIDER);
    	Object[] messages = msgList.toArray();
    	return Arrays.copyOf(messages, messages.length, String[].class);
    }

    public static String askForInput() {
    	return LINE_PREFIX + "Enter command: ";
    }
    
    public static String addPrefix(String m) {
    	return LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX);
    }
    
    public static String[] getFormattedFeedback(String feedback) {
    	ArrayList<String> msgList = new ArrayList<String>(); 
    	msgList.add(feedback);
    	msgList.add(DIVIDER);
    	Object[] messages = msgList.toArray();
    	return Arrays.copyOf(messages, messages.length, String[].class);
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

	public static String formatMessageEntered(String fullInputLine) {
		return "[Command entered:" + fullInputLine + "]";
	}
}
