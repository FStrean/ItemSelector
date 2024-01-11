package ru.app.project.utility;

import javax.swing.*;

public class TextSizeCalculator {
    public static void calculateJLabelTextSize(JLabel label, int height, double ratio) {
        double fontSize = (double)height / ratio;
        String formattedFontSize = "font-size: " + String.format("%.1f", fontSize).replace(',', '.') + "px;";
        label.setText(label.getText().replaceAll("font-size:\\s*\\d+(\\.\\d+)?px;", formattedFontSize));
    }

    public static void calculateJButtonTextSize(JButton button, int height, double ratio) {
        double fontSize = (double)height / ratio;
        String formattedFontSize = "font-size: " + String.format("%.1f", fontSize).replace(',', '.') + "px;";
        button.setText(button.getText().replaceAll("font-size:\\s*\\d+(\\.\\d+)?px;", formattedFontSize));
    }
}
