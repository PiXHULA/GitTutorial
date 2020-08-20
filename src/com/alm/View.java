package com.alm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class View extends JFrame{

    Question currentQuestion;
    Controller controller;

    JLabel description;
    JTextField textField;
    JTextArea textArea;
    JLabel label;
    OS OS;

    public View(Question startingQuestion,Controller controller) {

        OS = OSValidator.getOs();

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

        //input output panels
        JPanel terminal = new JPanel(new BorderLayout());//inputpanel och outpanel
//        JPanel inputPanel = new JPanel(new FlowLayout()); //label(t) och textfield

        //containers
        JPanel inputPanel = new JPanel();
        inputPanel.setSize(100,20);
        JPanel outpanel =  new JPanel();



        inputPanel.setBackground(Color.BLACK);
        String username = getUsername("whoamI").get(0);
        label = new JLabel(username + "$ ", SwingConstants.LEFT);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.RED);

        textField = new JTextField();
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.white);
        textField.setBorder(new EmptyBorder(0,0,0,0));
        textField.setPreferredSize(new Dimension(100,20));

        textArea = new JTextArea(5,1);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setSize(500,500);
        textArea.setEditable(false);
        textArea.setLineWrap(true);


        inputPanel.add(label);
        inputPanel.add(textField);

        outpanel.add(textArea);

        terminal.setBackground(Color.BLACK);
        terminal.add(inputPanel,BorderLayout.LINE_START);
        terminal.add(outpanel,BorderLayout.PAGE_END);


        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    if (textField.getText().equalsIgnoreCase(currentQuestion.getCommand())) {
                        textArea.setText(getUsername(textField.getText()).stream().collect(Collectors.joining("\n")));
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
        contentPanel.add(terminal, BorderLayout.CENTER);
        contentPanel.add(description,BorderLayout.SOUTH);
        contentPanel.setBorder(new EmptyBorder(20,90,20,90));

        mainPanel.add(contentPanel);

        add(mainPanel);
//        pack(); //SpringLayout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
        setSize(new Dimension(600, 400));
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public void correct() {
        if(textField.getText().equals("pwd"))
            label.setText(currentQuestion.getOutput());

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

    public java.util.List<String> getUsername(String input){

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(OS.SHELL, OS.C, input);

        try {
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            return new BufferedReader(inputStreamReader).lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
