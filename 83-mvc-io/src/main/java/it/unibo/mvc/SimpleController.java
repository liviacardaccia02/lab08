package it.unibo.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> history = new ArrayList<>();
    private String nextString;

    @Override
    public void setString(final String string) {
        this.nextString = Objects.requireNonNull(string);
    }

    @Override
    public String getString() {
        return this.nextString;
    }

    @Override
    public List<String> getHistory() {
        return Collections.unmodifiableList(this.history);
    }

    @Override
    public void printString() throws IllegalStateException {
        history.add(this.nextString);
        System.out.println(this.nextString);
    }

}
