/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop2.lms.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Oca
 */
public class DatePicker extends JDialog {

    private int month;
    private int year;
    private JLabel label;
    private String selectedDay;
    private Button[] buttons;

    public DatePicker() {
        setModal(true);
        setTitle("Date Picker");

        month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

        label = new JLabel("", JLabel.CENTER);

        JPanel panel1 = new JPanel(new GridLayout(7, 7));
        panel1.setPreferredSize(new Dimension(500, 200));

        buttons = new Button[49];

        String[] header = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i = 0; i < 7; i++) {
            buttons[i] = new Button(header[i]);
            buttons[i].setBackground(new Color(39, 45, 67));
            buttons[i].setForeground(Color.white);
            panel1.add(buttons[i]);
        }

        for (int i = 7; i < buttons.length; i++) {
            buttons[i] = new Button();
            panel1.add(buttons[i]);
            final int selection = i;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    selectedDay = buttons[selection].getText();
                    dispose();
                }
            });
        }

        JPanel panel2 = new JPanel(new GridLayout(1, 3));
        Button previous = new Button("<");
        Button next = new Button(">");
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                month--;
                displayDate();
            }
        });
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                month++;
                displayDate();
            }
        });
        panel2.add(previous);
        panel2.add(label);
        panel2.add(next);

        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        pack();
        displayDate();
    }

    public void displayDate() {
        for (int i = 7; i < buttons.length; i++) {
            buttons[i].setText("");
        }

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, 1);

        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        for (int i = 6 + dayOfWeek, day = 1; day <= daysInMonth; i++, day++) {
            buttons[i].setText("" + day);
            buttons[i].setForeground(Color.white);
        }

        label.setText(sdf.format(cal.getTime()));
    }

    public String setPickedDate() {
        if (selectedDay == null || selectedDay.isEmpty()) {
            return selectedDay;
        }

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, Integer.parseInt(selectedDay));

        return sdf.format(cal.getTime());
    }
}