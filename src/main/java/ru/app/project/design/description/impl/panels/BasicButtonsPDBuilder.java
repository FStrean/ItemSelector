package ru.app.project.design.description.impl.panels;

import ru.app.project.design.description.interf.panels.ButtonsPDBuilder;

import javax.swing.*;
import java.awt.*;

public class BasicButtonsPDBuilder implements ButtonsPDBuilder {
    private final JPanel panel;
    public BasicButtonsPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridBagLayout());
    }

    @Override
    public JButton buildJButton1Design() {
        GridBagConstraints constraints_ = new GridBagConstraints();
        constraints_.fill = GridBagConstraints.BOTH;
        constraints_.gridx = 0;
        constraints_.gridy = 0;
        constraints_.weightx = 1;
        constraints_.weighty = 0.2;
        panel.add(new JPanel(), constraints_);

        JButton button = new JButton();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.3;
        panel.add(button, constraints);
        return button;
    }

    @Override
    public JButton buildJButton2Design() {
        JButton button = new JButton();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1;
        constraints.weighty = 0.3;
        panel.add(button, constraints);

        GridBagConstraints constraints_ = new GridBagConstraints();
        constraints_.fill = GridBagConstraints.BOTH;
        constraints_.gridx = 0;
        constraints_.gridy = 3;
        constraints_.weightx = 1;
        constraints_.weighty = 0.2;
        panel.add(new JPanel(), constraints_);
        return button;
    }
}
