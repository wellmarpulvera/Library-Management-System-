/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop2.lms.components;

import java.awt.Color;
import javax.swing.JDialog;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;

/**
 *
 * @author Pulvera
 */
public class Chart extends JDialog {

    public Chart(String title, JFreeChart chart) {
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle(title);
        
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
        pack(); // Adjusts the size of the dialog to fit the chart
        setLocationRelativeTo(null); // Centers the dialog on the screen
    }
}
