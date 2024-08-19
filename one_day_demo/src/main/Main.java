package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("One_Day");

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
// to make the window big
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        gamePanel.setupgame();
        gamePanel.StartGameTrid();
    }
}
