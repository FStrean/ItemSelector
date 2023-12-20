package ru.app.project.design.itemDescription.impl.panels;

import ru.app.project.design.itemDescription.interf.panels.Header2PDBuilder;

import javax.swing.*;
import java.awt.*;

public class BasicHeader2PDBuilder implements Header2PDBuilder {
    private final JPanel panel;
    public BasicHeader2PDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridBagLayout());
    }
    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        panel.add(description, constraints);
        return description;
    }
}
