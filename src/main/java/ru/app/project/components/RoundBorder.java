package ru.app.project.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RoundBorder implements Border {
    private final Color color;

    private final int radius;

    public RoundBorder(Color color, int radius) {
        this.color = color;
        this.radius = radius;
    }

    public RoundBorder(int radius) {
        this.color = null;
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new JButton().getBorder().getBorderInsets(c);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width,
                            int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        if(color != null) {
            g2.setColor(color);
        }
        g2.drawRoundRect(x, y, c.getWidth() - 1, c.getHeight() - 1, radius, radius);
        g2.dispose();
    }
}