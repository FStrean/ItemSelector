package ru.app.project.design.itemDescription.impl.panels;

import ru.app.project.components.ImageButton;
import ru.app.project.design.itemDescription.interf.panels.FooterPDBuilder;
import ru.app.project.components.RelativeLayout;

import javax.swing.*;
import java.awt.*;

public class BasicFooterPDBuilder implements FooterPDBuilder {
    private final JPanel panel;
    public BasicFooterPDBuilder(JPanel panel) {
        this.panel = panel;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.X_AXIS, 20);
        layout.setFill(true);
        this.panel.setLayout(layout);
    }
    @Override
    public JButton buildJButton1Design() {
        JButton button = new JButton();
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        panel.add(button, 15.0f);
        return button;
    }
    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(description, 80.0f);
        return description;
    }

    @Override
    public ImageButton buildJButton2Design() {
        ImageButton button = new ImageButton("icons/home.png");
        button.setAlign(BorderLayout.LINE_END, BorderLayout.LINE_END);
        panel.add(button, 5.0f);
        return button;
    }
}
