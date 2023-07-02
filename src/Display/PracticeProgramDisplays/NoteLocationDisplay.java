package Display.PracticeProgramDisplays;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.PracticeControllers.PracticeController;
import Display.MenuDisplays.GraphicsController;
import Model.PracticeProgram;
import Model.enums.Difficulty;

public class NoteLocationDisplay extends AbstractPracticeProgramDisplay {
    
    public NoteLocationDisplay(JFrame frame) {
        super(frame);
    }

    @Override
    public void startSetupMenu(PracticeProgram practice, PracticeController controller) {
        GraphicsController.removeAllComponents(frame);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Add vertical spacing between components

        JLabel label = new JLabel("Please select your desired difficulty level");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER; // Center the buttons horizontally
        gbc.insets = new Insets(0, 0, 0, 0); // Reset insets for buttons

        JButton button1 = new JButton("Easy");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmationScreen(Difficulty.EASY, practice, controller);
            }
        });
        panel.add(button1, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Medium");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmationScreen(Difficulty.MEDIUM, practice, controller);
            }
        });
        panel.add(button2, gbc);

        gbc.gridy++;
        JButton button3 = new JButton("Hard");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmationScreen(Difficulty.HARD, practice, controller);
            }
        });
        panel.add(button3, gbc);

        gbc.gridy++;
        JButton button4 = new JButton("Rapid");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmationScreen(Difficulty.RAPID, practice, controller);
            }
        });
        panel.add(button4, gbc);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    @Override
    public String getInstructionString() {
        return "<html>This program will provide a note to play, which strings to play it on, and the range " +
                "of frets you should use.<br>" +
                "Follow the instructions, and double check your accuracy using a tuner.<html>";
    }

    public void runExercises(PracticeProgram practice, PracticeController controller) {
        GraphicsController.removeAllComponents(frame);

        String practiceString = PracticeProgram.getProblem(practice.getPracticeCommand());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Add vertical spacing between components

        JLabel label = new JLabel(practiceString);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER; // Center the buttons horizontally
        gbc.insets = new Insets(0, 0, 0, 0); // Reset insets for buttons

        JButton button1 = new JButton("Next Problem");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runExercises(practice, controller);
            }
         });
        panel.add(button1, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Quit Out");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.end();
            }
        });

        panel.add(button2, gbc);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    // Shows a brief confirmation screen before moving on.
    private void confirmationScreen(Difficulty diff, PracticeProgram practice, PracticeController controller) {
        GraphicsController.removeAllComponents(frame);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel label = new JLabel("You have selected " + diff.name() + " as your difficulty. Are you ready?");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);

        JButton button1 = new JButton("Yes");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                practice.setDifficulty(diff);
                controller.start();
            }
        });
        panel.add(button1, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Go Back");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startSetupMenu(practice, controller);
            }
        });
        panel.add(button2, gbc);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }
}
