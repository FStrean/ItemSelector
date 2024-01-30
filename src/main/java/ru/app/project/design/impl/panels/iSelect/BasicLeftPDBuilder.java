package ru.app.project.design.impl.panels.iSelect;

import ru.app.project.components.JImage;
import ru.app.project.components.RelativeLayout;
import ru.app.project.design.interf.panels.iSelect.LeftPDBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BasicLeftPDBuilder implements LeftPDBuilder {
    private final JPanel panel;
    public BasicLeftPDBuilder(JPanel panel) {
        this.panel = panel;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);

        layout.setFill(true);
        this.panel.setOpaque(false);
        this.panel.setLayout(layout);
    }

    @Override
    public JLabel buildJLabel1Design() {
        JLabel text = new JLabel();
        Font font = text.getFont();
        int style = font.getStyle();

        style ^= Font.BOLD;
        font = font.deriveFont(style);

        text.setFont(font);
        text.setOpaque(false);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(text, 15.0f);

        return text;
    }

    @Override
    public JImage buildJImage1Design() {
        JImage ip = new JImage();
        JPanel p = new JPanel();

        ip.setOpaque(false);
        p.setOpaque(false);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(5, 0, 5, 0));

        p.add(ip);
        panel.add(p, 50.0f);

        return ip;
    }

    @Override
    public JLabel buildJLabel2Design() {
        JLabel text = new JLabel();
        Font font = text.getFont();
        int style = font.getStyle();

        style ^= Font.BOLD;
        font = font.deriveFont(style);

        text.setFont(font);
        text.setOpaque(false);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(text, 15.0f);

        return text;
    }

    @Override
    public JImage buildJImage2Design() {
        JImage ip = new JImage();
        JPanel p = new JPanel();

        ip.setOpaque(false);
        p.setOpaque(false);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(5, 0, 5, 0));

        p.add(ip);
        panel.add(p, 20.0f);

        return ip;
    }
}
