package ru.app.project.design.itemDescription.impl.panels;

import ru.app.project.design.itemDescription.interf.panels.DescriptionPDBuilder;
import ru.app.project.components.RelativeLayout;

import javax.swing.*;

public class BasicDescriptionPDBuilder implements DescriptionPDBuilder {
    private final JPanel panel;
    public BasicDescriptionPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setOpaque(false);
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS);
        layout.setFill(true);
        this.panel.setLayout(layout);
    }
    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        description.setOpaque(false);
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(description, 100.0f);
        return description;
    }
}
