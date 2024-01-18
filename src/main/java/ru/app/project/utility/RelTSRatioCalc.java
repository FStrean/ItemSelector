package ru.app.project.utility;

import javax.swing.*;

public class RelTSRatioCalc {
    public static double getTextRatio(JLabel label) {
        return getRatio(label.getText(), label.getWidth());
    }
    public static double getTextRatio(JButton button) {
        return getRatio(button.getText(), button.getWidth());
    }
    public static double getTextRatio(String text, double width) {
        return getRatio(text, width);
    }

    private static double getRatio(String text, double width) {
        if(width == 0.0) {
            return -1.0;
        }
        int index = text.indexOf("font-size:");
        double initialFontSize;

        if (index != -1) {
            int startIndex = text.indexOf(":", index) + 1;
            int endIndex = text.indexOf("px", startIndex);
            String fontSizeString = text.substring(startIndex, endIndex).trim();
            initialFontSize =  Double.parseDouble(fontSizeString);
        } else {
            return -1.0;
        }

        return width / initialFontSize;
    }
}
