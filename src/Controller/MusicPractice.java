package Controller;

import javax.swing.JFrame;

import Display.MenuDisplays.GraphicsController;

public class MusicPractice {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Music Practice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setResizable(true);

        // The GraphicsController will act as the main controller for convenience sake.
        GraphicsController graphics = new GraphicsController();
        graphics.drawInitialMenu(frame);
    }
}
