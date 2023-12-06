package ru.app.project.design.itemDescriptionSelector.impl.panels;

import ru.app.project.design.itemDescriptionSelector.interf.panels.HeaderPDBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BasicHeaderPDBuilder implements HeaderPDBuilder {
    private final JPanel panel;
    public BasicHeaderPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridBagLayout());
    }

    @Override
    public JButton buildJButtonLeftDesign() {
        JButton button = new JButton();
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add(button);
        jPanel.setBorder(new EmptyBorder(5, 20, 5, 20));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;



        panel.add(jPanel, constraints);
        return button;
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add(description);
        jPanel.setBorder(new EmptyBorder(5, 20, 5, 20));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        panel.add(jPanel, constraints);
        return description;
    }

    @Override
    public JButton buildJButtonRightDesign() {
        JButton button = new JButton();
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add(button);
        jPanel.setBorder(new EmptyBorder(5, 20, 5, 20));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;



        panel.add(jPanel, constraints);
        return button;
    }
}
