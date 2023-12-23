/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop2.lms.components;

import javax.swing.JButton;

/**
 *
 * @author Pulvera
 */
public class Button extends JButton {

    public Button(String text) {
        setBackground(new java.awt.Color(32, 36, 51));

        setForeground(new java.awt.Color(255, 255, 255));

        setText(text);
    }

    public Button() {
        setBackground(new java.awt.Color(162, 150, 189));

        setForeground(new java.awt.Color(0, 0, 0));

    }
}
