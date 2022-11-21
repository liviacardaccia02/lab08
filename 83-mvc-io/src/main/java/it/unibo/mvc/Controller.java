package it.unibo.mvc;

import java.util.List;

/**
 * Application controller responsible of I/O access.
 */
public interface Controller {

    /**
     * Sets the input string as the next string to print.
     * 
     * @param string
     */
    void setString(String string);

    /**
     * Returns the next string to print.
     * 
     * @return next string
     */
    String getString();

    /**
     * Returns the history of printed strings in for of a list.
     * 
     * @return history as list
     */
    List<String> getHistory();

    /**
     * Prints the current string.
     */
    void printString();
}
