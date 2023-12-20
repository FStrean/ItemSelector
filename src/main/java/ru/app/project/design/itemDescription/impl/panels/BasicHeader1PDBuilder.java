package ru.app.project.design.itemDescription.impl.panels;

import ru.app.project.components.ImageButton;
import ru.app.project.design.itemDescription.interf.panels.Header1PDBuilder;

import javax.swing.*;
import java.awt.*;

public class BasicHeader1PDBuilder implements Header1PDBuilder {
    private final JPanel panel;
    public BasicHeader1PDBuilder(JPanel panel) {
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
        constraints.weightx = 0.5;
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
        constraints.weightx = 0.5;
        constraints.weighty = 1;
        panel.add(button, constraints);
        return button;
    }
}
