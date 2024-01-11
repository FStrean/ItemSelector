package ru.app.project.design.itemDescription.impl.panels;

import ru.app.project.components.ImageButton;
import ru.app.project.design.itemDescription.interf.panels.HeaderPDBuilder;
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
    public ImageButton buildJButton1Design() {
        ImageButton button = new ImageButton("icons/arrow_left.png");
        button.setAlign(BorderLayout.LINE_START, BorderLayout.LINE_START);
        panel.add(button, 5.0f);
        return button;
    }

    @Override
    public ImageButton buildJButton2Design() {
        ImageButton button = new ImageButton("icons/arrow_right.png");
        button.setAlign(BorderLayout.LINE_START, BorderLayout.LINE_START);
        panel.add(button, 5.0f);
        return button;
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        description.setOpaque(false);
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(description, 90.0f);
        return description;
    }
}
