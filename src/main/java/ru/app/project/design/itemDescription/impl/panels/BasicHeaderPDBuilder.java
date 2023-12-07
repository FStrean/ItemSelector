package ru.app.project.design.itemDescription.impl.panels;

import ru.app.project.components.ImageButton;
import ru.app.project.design.itemDescription.interf.panels.HeaderPDBuilder;

import javax.swing.*;
import java.awt.*;

public class BasicHeaderPDBuilder implements HeaderPDBuilder {
    private final JPanel panel;
    public BasicHeaderPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridBagLayout());
    }

    @Override
    public JButton buildJButton1Design() {
        ImageButton button = new ImageButton("icons/arrow_left.png");
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.25;
        constraints.weighty = 1;
        panel.add(button, constraints);
        return button;
    }

    @Override
    public JButton buildJButton2Design() {
        ImageButton button = new ImageButton("icons/arrow_right.png");
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.25;
        constraints.weighty = 1;
        panel.add(button, constraints);
        return button;
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.weighty = 1;
        panel.add(description, constraints);
        return description;
    }
}
