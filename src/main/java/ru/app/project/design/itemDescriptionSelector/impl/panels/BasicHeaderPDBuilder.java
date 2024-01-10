package ru.app.project.design.itemDescriptionSelector.impl.panels;

import ru.app.project.design.itemDescriptionSelector.interf.panels.HeaderPDBuilder;
import ru.app.project.utility.RelativeLayout;

import javax.swing.*;
import java.awt.*;

public class BasicHeaderPDBuilder implements HeaderPDBuilder {
    private final JPanel panel;
    public BasicHeaderPDBuilder(JPanel panel) {
        this.panel = panel;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.X_AXIS, 20);
        layout.setFill(true);
        this.panel.setLayout(layout);
    }

    @Override
    public JButton buildJButtonLeftDesign() {
        JButton button = new JButton();
        panel.add(button, 15.0f);
        return button;
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(description, 70.0f);
        return description;
    }

    @Override
    public JButton buildJButtonRightDesign() {
        JButton button = new JButton();
        panel.add(button, 15.0f);
        return button;
    }
}
