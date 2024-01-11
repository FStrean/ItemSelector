package ru.app.project.design.itemDescriptionSelector.impl.panels;

import ru.app.project.components.RoundButton;
import ru.app.project.config.AppProperties;
import ru.app.project.design.itemDescriptionSelector.interf.panels.ButtonsPDBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BasicButtonsPDBuilder implements ButtonsPDBuilder {
    private JPanel panel;
    public BasicButtonsPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setOpaque(false);
        this.panel.setLayout(new GridLayout(0, AppProperties.getNumberOfItemsInItemDescriptionWindow() / 3));
    }

    @Override
    public JButton buildJButtonDesign() {
        RoundButton button = new RoundButton("", 40, new Color(164, 164, 164));
        button.setForeground(Color.BLACK);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setOpaque(false);
        jPanel.add(button);
        jPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        panel.add(jPanel);
        return button;
    }
}
