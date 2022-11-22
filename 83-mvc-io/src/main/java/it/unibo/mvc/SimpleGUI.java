package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    /**
     * builds a new {@link SimpleGUI} with a simple controller.
     * 
     * @param controller
     */
    public SimpleGUI(final SimpleController controller) {
        //north panel
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        final JTextField text = new JTextField();
        panel1.add(text, BorderLayout.NORTH);
        final JTextArea area = new JTextArea();
        area.setEditable(false);
        panel1.add(area, BorderLayout.CENTER);
        //south panel
        final JPanel panel2 = new JPanel();
        final JButton print = new JButton("print");
        final JButton showHistory = new JButton("show history");
        panel2.add(print);
        panel2.add(showHistory);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
        //assemble
        panel1.add(panel2, BorderLayout.SOUTH);
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         * Handlers
         */
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                controller.setString(text.getText());
                controller.printString();
            }

        });

        showHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                area.setText((controller.getHistory()).toString());
            }
            
        });

        //setting dimension
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
    }

    private void display() {
        frame.setVisible(true);
    }

    /**
     * 
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController()).display();
    }

}
