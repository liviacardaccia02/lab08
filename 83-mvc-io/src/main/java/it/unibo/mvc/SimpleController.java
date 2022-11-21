package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> history = new ArrayList<>();
    private String nextString;

    @Override
    public void setString(final String string) {
        this.nextString = string;
    }

    @Override
    public String getString() {
        return this.nextString;
    }

    @Override
    public List<String> getHistory() {
        return this.history;
    }

    @Override
    public void printString() throws IllegalStateException {
        history.add(this.nextString);
        System.out.println(this.nextString);
    }

}
