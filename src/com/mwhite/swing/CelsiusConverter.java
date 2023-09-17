package com.mwhite.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** This example is provided by Oracle.
 * https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/learn/CelsiusConverterProject/src/learn/CelsiusConverterGUI.java
 */
public class CelsiusConverter extends JFrame {

    private JLabel celsiusLabel;
    private JTextField tempTextField;
    private JLabel fahrenheitLabel;
    private JButton convertButton;

    public CelsiusConverter() {
        initComponents();
    }

    private void initComponents() {
        tempTextField = new JTextField();
        celsiusLabel = new JLabel();
        convertButton = new JButton();
        fahrenheitLabel = new JLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Celsius Converter");

        celsiusLabel.setText("Celsius");

        convertButton.setText("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertButtonActionPerformed(e);
            }
        });

        fahrenheitLabel.setText("Fahrenheit");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(tempTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(celsiusLabel))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(convertButton)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fahrenheitLabel)))
                        .addContainerGap(27, Short.MAX_VALUE))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {convertButton, tempTextField});

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(tempTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(celsiusLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(convertButton)
                                        .addComponent(fahrenheitLabel))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        pack();
    }

    private void convertButtonActionPerformed(ActionEvent e) {
        int tempFahr = (int) ((Double.parseDouble(tempTextField.getText()))
                * 1.8 + 32);
        fahrenheitLabel.setText(tempFahr + " Fahrenheit");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CelsiusConverter().setVisible(true);
            }
        });
    }
}
