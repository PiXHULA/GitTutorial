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
    JTextField textField;
    JTextArea textArea;
    JLabel terminal;

    public View(Question startingQuestion,Controller controller) {

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

        JPanel outputPanel = new JPanel(new GridLayout(2,1));
        JPanel inputPanel = new JPanel(new FlowLayout());

        inputPanel.setBackground(Color.BLACK);

        terminal = new JLabel("Terminal~ % ", SwingConstants.LEFT);
        terminal.setForeground(Color.WHITE);

        textField = new JTextField();
        textField.setBackground(Color.black);
        textField.setForeground(Color.white);
        textField.setBorder(new EmptyBorder(0,0,0,0));
        textField.setPreferredSize(new Dimension());

        textArea = new JTextArea(5,1);
        textArea.setBackground(Color.BLACK);
        textArea.setEditable(false);

        inputPanel.add(terminal);
        inputPanel.add(textField);

        outputPanel.setBackground(Color.BLACK);
        outputPanel.add(inputPanel);
        outputPanel.add(textArea);


        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    if (textField.getText().equalsIgnoreCase(currentQuestion.getCommand())) {
                        correct();
                    } else {
                        JOptionPane.showMessageDialog(null, "Fel, försök igen");
                        System.out.println(textField.getText());
                        textField.setText("");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        contentPanel.add(createImage(), BorderLayout.NORTH);
        contentPanel.add(outputPanel, BorderLayout.CENTER);
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
        textField.setText("");
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
