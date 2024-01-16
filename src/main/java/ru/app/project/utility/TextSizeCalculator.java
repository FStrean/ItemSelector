package ru.app.project.utility;

import javax.swing.*;

public class TextSizeCalculator {
    private static final String regExp = "font-size:\\s*\\d+(\\.\\d+)?px;";
    public static void calculateJLabelTextSize(JLabel label, int height, double ratio) {
        label.setText(label.getText().replaceAll(regExp, calculateTextSize(label.getWidth(), height, ratio)));
    }

    public static void calculateJButtonTextSize(JButton button, int height, double ratio) {
        button.setText(button.getText().replaceAll(regExp, calculateTextSize(button.getWidth(), height, ratio)));
    }

    private static String calculateTextSize(double width, int height, double ratio) {
        if(ratio > 0) {
            double fontSize = Math.max(Math.min(width / ratio, height), 0.1);
            return "font-size: " + String.format("%.1f", fontSize).replace(',', '.') + "px;";
        } else {
            return "font-size: 10px;";
        }
    }
}
