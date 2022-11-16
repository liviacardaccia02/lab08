package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Toolkit;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My second Java graphical interface";
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame(TITLE);

    /**
     * Creates a new SimpleGUIWithFileChooser.
     * 
     * @param controller 
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea();
        final JButton save = new JButton("Save");
        final JTextField filepath = new JTextField(controller.getPath());
        final JButton browse = new JButton("Browse");

        panel1.add(text, BorderLayout.CENTER);
        panel1.add(save, BorderLayout.SOUTH);
        panel2.add(filepath, BorderLayout.CENTER);
        panel2.add(browse, BorderLayout.LINE_END);
        panel1.add(panel2, BorderLayout.NORTH);
        frame.setContentPane(panel1);

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

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final JFileChooser filechooser = new JFileChooser();
                    final int i = filechooser.showSaveDialog(browse);
                    switch (i) {
                        case JFileChooser.APPROVE_OPTION: 
                            controller.setFile(filechooser.getSelectedFile());
                            break;
                        case JFileChooser.CANCEL_OPTION:
                            //in this case the program should do nothing
                            break;
                        default:
                        JOptionPane.showMessageDialog(frame, "Error occured");
                }
            }
        });
    }

    private void display() { 
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String[] args) {
        final Controller ctrl = new Controller();
        new SimpleGUIWithFileChooser(ctrl).display();
    }
}
