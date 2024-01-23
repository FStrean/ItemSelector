package ru.app.project.components;

import javax.swing.*;
import java.awt.*;

public class RoundButton extends JButton {
    private final int radius;
    private final Color color;

    public RoundButton(String text, int radius, Color color) {
        super(text);
        this.radius = radius;
        this.color = color;
        super.setBackground(color);
        super.setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        if(getModel().isArmed()) {
            g2.setColor(UIManager.getColor("Button.shadow"));
        } else {
            g2.setColor(color);
        }
        g2.fillRoundRect(0, 0, super.getSize().width - 1, super.getSize().height - 1, radius, radius);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke(new BasicStroke(2f));
        if (getModel().isRollover()) {
            g2.setColor(UIManager.getColor("Button.shadow"));
        } else if(getModel().isArmed()) {
            g2.setColor(Color.GRAY);
        } else {
            g2.setColor(color);
        }

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.dispose();
    }
}
