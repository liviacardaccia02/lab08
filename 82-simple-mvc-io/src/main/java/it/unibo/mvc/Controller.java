package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentFile = new File(System.getProperty("user.home") + File.separator + "output.txt");

    public void setFile(final File file) {
        this.currentFile = file;
    }

    public File getFile() {
        return this.currentFile;
    }

    public String getPath() {
        return this.currentFile.getPath();
    }

    public void printString(final String input) throws IOException {
        try(final PrintStream ps = new PrintStream(this.currentFile.getPath(), StandardCharsets.UTF_8)) {
            ps.println(input);
        } 
    }

}
