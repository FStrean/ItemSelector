package ru.app.project.design.iSelectSelect.impl.panels;

import ru.app.project.design.iSelectSelect.interf.panels.ButtonsPDBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BasicButtonsPDBuilder implements ButtonsPDBuilder {
    private JPanel panel;
    public BasicButtonsPDBuilder(JPanel panel) {
        this.panel = panel;

        this.panel.setOpaque(false);
        this.panel.setLayout(new GridLayout(0, 1));
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel text = new JLabel();

        text.setOpaque(false);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(text);

        return text;
    }

    @Override
    public JButton buildJButtonDesign() {
        JButton button = new JButton();
        JPanel p = new JPanel(new BorderLayout());

        button.setBackground(new Color(208, 206, 206));
        button.setForeground(Color.BLACK);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        p.setOpaque(false);
        p.setBorder(new EmptyBorder(5, 0, 5, 0));

        p.add(button);
        panel.add(p);

        return button;
    }
}
