package ru.app.project.design.iDescSelect.impl.panels;

import ru.app.project.components.RoundButton;
import ru.app.project.design.iDescSelect.interf.panels.HeaderPDBuilder;
import ru.app.project.components.RelativeLayout;

import javax.swing.*;
import java.awt.*;

public class BasicHeaderPDBuilder implements HeaderPDBuilder {
    private final JPanel panel;
    public BasicHeaderPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setOpaque(false);
        RelativeLayout layout = new RelativeLayout(RelativeLayout.X_AXIS, 20);
        layout.setFill(true);
        this.panel.setLayout(layout);
    }

    @Override
    public JButton buildJButtonDesign() {
        RoundButton button = new RoundButton("", 40, Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button, 15.0f);
        return button;
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        description.setOpaque(false);
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(description, 70.0f);
        return description;
    }
}
