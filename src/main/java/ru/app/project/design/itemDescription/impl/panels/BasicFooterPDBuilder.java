package ru.app.project.design.itemDescription.impl.panels;

import ru.app.project.components.ImageButton;
import ru.app.project.design.itemDescription.interf.panels.FooterPDBuilder;

import javax.swing.*;
import java.awt.*;

public class BasicFooterPDBuilder implements FooterPDBuilder {
    private final JPanel panel;
    public BasicFooterPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridLayout(1,0));
    }
    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        panel.add(Box.createRigidArea(new Dimension(100, 0)));
        panel.add(description);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        return description;
    }

    @Override
    public ImageButton buildJButtonDesign() {
        ImageButton button = new ImageButton("icons/home.png");
        panel.add(button);
        return button;
    }
}
