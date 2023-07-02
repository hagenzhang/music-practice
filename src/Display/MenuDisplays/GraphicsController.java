package Display.MenuDisplays;

import javax.swing.*;

import Controller.PracticeControllers.ChordConstructionController;
import Controller.PracticeControllers.NoteLocationController;
import Controller.PracticeControllers.PracticeController;
import Display.PracticeProgramDisplays.ChordConstructionDisplay;
import Display.PracticeProgramDisplays.NoteLocationDisplay;
import Display.PracticeProgramDisplays.PracticeProgramDisplay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicsController {
    private PracticeController practiceController;
    private PracticeProgramDisplay practiceDisplay;

    /**
     * Draws the first menu for people to interact with the program.
     * 
     * @param frame JFrame to draw everything in
     */
    public void drawInitialMenu(JFrame frame) {
        // needs to be called in order to ensure that each menu change is on a clean slate
        removeAllComponents(frame); 

        // Set Menu Buttons For The Initial Menu
        JButton practice1Button = new JButton("Fretboard Familiarity");
        practice1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchNoteLocationMenu(frame);
            }
        });

        JButton practice2Button = new JButton("Constructing Chords");
        practice2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchChordConstructionMenu(frame);
            }
        });

        JButton quitButton = new JButton("End Practice");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 0, 2, 0);

        panel.add(practice1Button, gbc);

        gbc.gridy++;
        panel.add(practice2Button, gbc);

        gbc.gridy++;
        panel.add(quitButton, gbc);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }


    // Launches the Note Location Practice Program menu.
    public void launchNoteLocationMenu(JFrame frame) {
        // needs to be called in order to ensure that each menu change is on a clean slate
        removeAllComponents(frame); 

        // Sets the fields
        this.practiceDisplay = new NoteLocationDisplay(frame);
        this.practiceController = new NoteLocationController(practiceDisplay);

        // Create button to start the actual program
        JButton proceedButton = new JButton("Start Practice!");
        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeAllComponents(frame);
                practiceController.start();
            }
        });
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Add vertical spacing between components

        JLabel instructions = new JLabel(practiceDisplay.getInstructionString());
        instructions.setFont(new Font("Arial", Font.PLAIN, 20));
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setVerticalAlignment(JLabel.CENTER);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints frameGbc = new GridBagConstraints();
        frameGbc.gridx = 0;
        frameGbc.gridy = 0;
        frameGbc.weightx = 1.0;
        frameGbc.fill = GridBagConstraints.BOTH;

        frame.add(panel, frameGbc);
        panel.add(proceedButton, gbc);

        frameGbc.gridy++;
        frame.add(instructions, frameGbc);

        frame.setVisible(true);
    }


    // Launches the Chord Construction Practice Menu.
    private void launchChordConstructionMenu(JFrame frame) {
        // needs to be called in order to ensure that each menu change is on a clean slate
        removeAllComponents(frame); 

        // Sets the fields
        this.practiceDisplay = new ChordConstructionDisplay(frame);
        this.practiceController = new ChordConstructionController(practiceDisplay);

        // Create button to start the actual program
        JButton proceedButton = new JButton("Start Practice!");
        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeAllComponents(frame);
                practiceController.start();
            }
        });
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Add vertical spacing between components

        JLabel instructions = new JLabel(practiceDisplay.getInstructionString());
        instructions.setFont(new Font("Arial", Font.PLAIN, 20));
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setVerticalAlignment(JLabel.CENTER);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints frameGbc = new GridBagConstraints();
        frameGbc.gridx = 0;
        frameGbc.gridy = 0;
        frameGbc.weightx = 1.0;
        frameGbc.fill = GridBagConstraints.BOTH;

        frame.add(panel, frameGbc);
        panel.add(proceedButton, gbc);

        frameGbc.gridy++;
        frame.add(instructions, frameGbc);

        frame.setVisible(true);
    }

    /**
     * Used to refresh all components on a JFrame. Deletes all components in order to ensure
     * old components don't stay when menu changes occur.
     * 
     * @param frame JFrame to refresh.
     */
    public static void removeAllComponents(JFrame frame) {
        Container contentPane = frame.getContentPane();
        Component[] components = contentPane.getComponents();
        
        for (Component component : components) {
            contentPane.remove(component);
        }
        
        frame.revalidate();
        frame.repaint();
    }
}
