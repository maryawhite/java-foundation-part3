package com.mwhite.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnotherCelsiusConverter extends JFrame {

    private JLabel celsiusLabel;
    private JTextField tempTextField;
    private JLabel fahrenheitLabel;
    private JButton convertButton;
    private JButton closeButton;

    public AnotherCelsiusConverter() {
        initComponents();
    }

    private void initComponents() {
        tempTextField = new JTextField(15); // Set the preferred size of the text field
        celsiusLabel = new JLabel("Celsius");
        convertButton = new JButton("Convert");
        fahrenheitLabel = new JLabel("Fahrenheit");
        closeButton = new JButton("Close");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Celsius Converter");

        //action listener for the convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertButtonActionPerformed(e);
            }
        });

        //AbstractAction for the Enter key, users can press enter instead of clicking the convert button.
        Action enterAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertButtonActionPerformed(e);
            }
        };

        // Bind Enter key to the enterAction
        tempTextField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
        tempTextField.getActionMap().put("enterAction", enterAction);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeButtonActionPerformed(e);
            }
        });

        // Create a JPanel to hold the components and use GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Add some padding around the components
        gbc.insets = new Insets(5, 5, 5, 5); // top, left, bottom, right

        // Add components to the panel with GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(tempTextField, gbc);

        gbc.gridx = 1;
        panel.add(celsiusLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Span two columns for the button and label
        panel.add(convertButton, gbc);

        gbc.gridy = 2;
        panel.add(fahrenheitLabel, gbc);

        gbc.gridy = 3;
        panel.add(closeButton, gbc);

        // Add the panel to the frame's content pane
        getContentPane().add(panel);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    private void convertButtonActionPerformed(ActionEvent e) {
        try{
            int tempFahr = (int) ((Double.parseDouble(tempTextField.getText()))
                    * 1.8 + 32);
            fahrenheitLabel.setText(tempFahr + " Fahrenheit");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Please enter a number.");
            ex.printStackTrace();
        }

    }

    private void closeButtonActionPerformed(ActionEvent e) {
        tempTextField.setText("");
        dispose();   //close the frame
    }

    public static void main(String[] args) {
        System.out.println("main Thread: " + Thread.currentThread().getName());
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread name: " + Thread.currentThread().getName()); //Swing Event Dispatch Thread EDT AWT-EventQueue-0
                new AnotherCelsiusConverter().setVisible(true);
            }
        });
    }
}
