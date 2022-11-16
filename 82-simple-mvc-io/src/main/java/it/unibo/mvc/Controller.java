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

    /**
     * Sets the input file as the current file.
     * 
     * @param file
     */
    public void setFile(final File file) {
        this.currentFile = file;
    }

    /**
     * Returns the current file.
     * 
     * @return currentFile
     */
    public File getFile() {
        return this.currentFile;
    }

    /**
     * Returns the path of the current file.
     * 
     * @return the path
     */
    public String getPath() {
        return this.currentFile.getPath();
    }

    /**
     * Saves the string given as input on the current file.
     * 
     * @param input saved on the current file
     * 
     * @throws IOException
     */
    public void printString(final String input) throws IOException {
        try (PrintStream ps = new PrintStream(this.currentFile.getPath(), StandardCharsets.UTF_8)) {
            ps.println(input);
        } 
    }

}
