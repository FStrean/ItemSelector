package ru.app.project.design.desc.impl.panels;

import ru.app.project.components.RoundButton;
import ru.app.project.design.desc.interf.panels.ButtonsPDBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BasicButtonsPDBuilder implements ButtonsPDBuilder {
    private final JPanel panel;
    public BasicButtonsPDBuilder(JPanel panel) {
        this.panel = panel;

        this.panel.setOpaque(false);
        this.panel.setLayout(new GridLayout(0,1));
    }

    @Override
    public JButton buildJButtonDesign() {
        RoundButton btn = new RoundButton("", 40, Color.BLACK);
        JPanel p = new JPanel(new BorderLayout());
        Font font = btn.getFont();
        int style = font.getStyle();

        style ^= Font.BOLD;
        font = font.deriveFont(style);

        btn.setFont(font);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        p.setOpaque(false);
        p.setBorder(new EmptyBorder(25, 0, 25, 0));

        p.add(btn);
        panel.add(p);

        return btn;
    }
}
