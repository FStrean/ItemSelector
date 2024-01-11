package ru.app.project.design.mainSelector.impl.panels;

import ru.app.project.components.RoundButton;
import ru.app.project.design.mainSelector.interf.panels.ButtonsPDBuilder;

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
        RoundButton button = new RoundButton("", 40, Color.BLACK);
        button.setForeground(Color.WHITE);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setOpaque(false);
        jPanel.setBorder(new EmptyBorder(15, 40, 15, 40));
        jPanel.add(button);
        panel.add(jPanel);
        return button;
    }
}
