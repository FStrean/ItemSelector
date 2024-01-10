package ru.app.project.design.itemDescriptionSelector.impl.panels;

import ru.app.project.components.ImageButton;
import ru.app.project.design.itemDescriptionSelector.interf.panels.FooterPDBuilder;
import ru.app.project.utility.RelativeLayout;

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
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(description, 95.0f);
        return description;
    }

    @Override
    public ImageButton buildJButtonDesign() {
        ImageButton button = new ImageButton("icons/home.png");
        panel.add(button, 5.0f);
        return button;
    }
}
