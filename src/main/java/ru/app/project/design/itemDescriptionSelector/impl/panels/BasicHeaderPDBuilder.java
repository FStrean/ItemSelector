package ru.app.project.design.itemDescriptionSelector.impl.panels;

import ru.app.project.design.itemDescriptionSelector.interf.panels.HeaderPDBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BasicHeaderPDBuilder implements HeaderPDBuilder {
    private final JPanel panel;
    public BasicHeaderPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridLayout(1,0));
    }

    @Override
    public JButton buildJButtonLeftDesign() {
        JButton button = new JButton();
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add(button);
        jPanel.setBorder(new EmptyBorder(15, 20, 15, 20));
        panel.add(jPanel);
        return button;
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        panel.add(description);
        return description;
    }

    @Override
    public JButton buildJButtonRightDesign() {
        JButton button = new JButton();
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add(button);
        jPanel.setBorder(new EmptyBorder(15, 20, 15, 20));
        panel.add(jPanel);
        return button;
    }
}
