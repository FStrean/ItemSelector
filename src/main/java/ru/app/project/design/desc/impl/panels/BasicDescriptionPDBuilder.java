package ru.app.project.design.desc.impl.panels;

import ru.app.project.design.desc.interf.panels.DescriptionPDBuilder;

import javax.swing.*;
import java.awt.*;

public class BasicDescriptionPDBuilder implements DescriptionPDBuilder {
    private final JPanel panel;
    public BasicDescriptionPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setOpaque(false);
        this.panel.setLayout(new BorderLayout());
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        description.setOpaque(false);
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(description);
        return description;
    }
}
