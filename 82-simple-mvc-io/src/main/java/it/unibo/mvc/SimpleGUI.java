package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public class SimpleGUI {

    private static final String TITLE = "My first Java graphical interface";
    private final JFrame frame = new JFrame(TITLE);

    /**
     * Creates a new SimpleGUI.
     * 
     * @param controller 
     */
    public SimpleGUI(final Controller controller) {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea();
        frame.add(text, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        frame.add(save, BorderLayout.AFTER_LAST_LINE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                try {
                    controller.printString(text.getText());
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(frame, e, "Error occured", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void display() { 
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String[] args) {
        final Controller ctrl = new Controller();
        new SimpleGUI(ctrl).display();
    }

}
