package com.alm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class View extends JFrame{

    Question currentQuestion;
    Controller controller;

    JLabel description;
    JTextField textArea;
    JLabel terminal;
    
    public View(Question startingQuestion, Controller controller) {
        
        currentQuestion = startingQuestion;
        this.controller = controller;

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        JLabel jLabel = new JLabel("GIT GAME", SwingConstants.CENTER);
        jLabel.setFont(new Font("Calibri", Font.PLAIN, 72));
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        description = new JLabel(currentQuestion.getMessage(), SwingConstants.CENTER);
        description.setFont(new Font("Calibri", Font.PLAIN, 12));
        description.setBorder(new EmptyBorder(20,0,20,0));

        JPanel inputPanel = new JPanel(new GridLayout(3,2));

        terminal = new JLabel("Terminal~ % ", SwingConstants.LEFT);
        terminal.setForeground(Color.WHITE);

        textArea= new JTextField();
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);
        textArea.setBorder(new EmptyBorder(0,0,0,0));

        inputPanel.setBackground(Color.BLACK);
        inputPanel.add(terminal);
        inputPanel.add(textArea);

        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    if (textArea.getText().equalsIgnoreCase(currentQuestion.getCommand())) {
                        correct();
                    } else {
                        JOptionPane.showMessageDialog(null, "Fel, försök igen");
                        textArea.setText("");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        contentPanel.add(createImage(), BorderLayout.NORTH);
        contentPanel.add(inputPanel, BorderLayout.CENTER);
        contentPanel.add(description,BorderLayout.SOUTH);
        contentPanel.setBorder(new EmptyBorder(20,90,20,90));

        mainPanel.add(contentPanel);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
        setSize(new Dimension(600, 400));
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public void correct() {
        terminal.setText(currentQuestion.getOutput());
        controller.newQuestion();
        description.setText(currentQuestion.getMessage());
        textArea.setText("");
    }

    public static JLabel createImage() {
        String logoPath = "src/com/alm/resources/template.png";
        JLabel logoGame = new JLabel(new ImageIcon(logoPath));
        return logoGame;
    }

    public void win() {
        JOptionPane.showMessageDialog(null, "Du vann!");
        System.exit(0);
    }
}
