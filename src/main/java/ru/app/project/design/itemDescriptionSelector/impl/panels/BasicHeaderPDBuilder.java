package ru.app.project.design.itemDescriptionSelector.impl.panels;

import ru.app.project.design.itemDescriptionSelector.interf.panels.HeaderPDBuilder;

import javax.swing.*;
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
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 1;
        constraints.insets = new Insets(5, 20, 5, 20);

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
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.6;
        constraints.weighty = 1;
        constraints.insets = new Insets(5, 20, 5, 20);

        panel.add(description, constraints);
        return description;
    }

    @Override
    public JButton buildJButtonRightDesign() {
        JButton button = new JButton();
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 1;
        constraints.insets = new Insets(5, 20, 5, 20);

        panel.add(button, constraints);
        return button;
    }
}
