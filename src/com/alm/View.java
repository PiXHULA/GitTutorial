package com.alm;

import static java.awt.Color.BLACK;
import static javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class View extends JFrame {

    Question currentQuestion;
    Controller controller;

    JLabel description;
    JTextField textField;
    JTextArea textArea;
    JLabel label;
    OS OS;
    ProcessBuilder processBuilder;

    public View(Question startingQuestion, Controller controller) {

        OS = OSValidator.getOs();
        processBuilder = new ProcessBuilder();
        String username = getUsername("whoami").get(0);
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
        description.setBorder(new EmptyBorder(20, 0, 20, 0));

        //input output panels

        JPanel terminal = new JPanel(new BorderLayout());//inputpanel och outpanel
        terminal.setBackground(BLACK);

        //containers
        JPanel inputPanel = new JPanel();
        inputPanel.setMaximumSize(new Dimension(100, 20));

        inputPanel.setBackground(BLACK);

        JPanel outpanel = new JPanel();
        outpanel.setBackground(BLACK);

        label = new JLabel(username + "$ ", SwingConstants.LEFT);
        label.setForeground(Color.WHITE);

        textField = new JTextField();

        textField.setBackground(BLACK);
        textField.setForeground(Color.white);
        textField.setBorder(new EmptyBorder(0, 0, 0, 0));
        textField.setPreferredSize(new Dimension(400, 20));
        textArea = new JTextArea(20, 45);
        JScrollPane scroll = new JScrollPane(textArea, VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar verticalScrollBar = new JScrollBar();
        verticalScrollBar.setBackground(BLACK);
        scroll.setVerticalScrollBar(verticalScrollBar);
        scroll.setBackground(BLACK);

        textArea.setBackground(BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setSize(500, 500);
        textArea.setEditable(false);
        textArea.setLineWrap(true);

        inputPanel.add(label);
        inputPanel.add(textField);

        outpanel.add(scroll);

        terminal.setBackground(BLACK);
        terminal.add(inputPanel, BorderLayout.LINE_START);
        terminal.add(outpanel, BorderLayout.PAGE_END);

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    if (textField.getText().equalsIgnoreCase(currentQuestion.getCommand())) {
                        textArea.setText(getUsername(textField.getText()).stream().collect(Collectors.joining("\n")));
                        correct();
                    } else {
                        JOptionPane.showMessageDialog(null, "Fel, försök igen");
                        textField.setText("");
                    }
                }
            }
        });

        contentPanel.add(createImage(), BorderLayout.NORTH);
        contentPanel.add(terminal, BorderLayout.CENTER);
        contentPanel.add(description, BorderLayout.SOUTH);
        contentPanel.setBorder(new EmptyBorder(20, 90, 20, 90));

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
        String inputText = textField.getText();
        if (inputText.equals("pwd") || inputText.startsWith("cd")) {
            label.setText(currentQuestion.getOutput());
        }

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

    public java.util.List<String> getUsername(String input) {

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
