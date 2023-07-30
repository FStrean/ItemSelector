package ru.app.project.config;

import java.awt.*;

public class SystemProperties {
    private static final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static final Dimension dimension = toolkit.getScreenSize();
    public static int getScreenWidth() {
        return (int) dimension.getWidth();
    }
    public static int getScreenHeight() {
        return (int) dimension.getHeight();
    }
}
