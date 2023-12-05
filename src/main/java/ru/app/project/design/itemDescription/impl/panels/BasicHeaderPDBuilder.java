package ru.app.project.design.itemDescription.impl.panels;

import ru.app.project.components.ImageButton;
import ru.app.project.design.itemDescription.interf.panels.HeaderPDBuilder;

import javax.swing.*;
import java.awt.*;

public class BasicHeaderPDBuilder implements HeaderPDBuilder {
    private final JPanel panel;
    public BasicHeaderPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridLayout(1,0));
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        panel.add(description);
        return description;
    }

    @Override
    public ImageButton buildJButtonLeftDesign() {
        ImageButton button = new ImageButton("icons/arrow_left.png");
        panel.add(button);
        return button;
    }

    @Override
    public ImageButton buildJButtonRightDesign() {
        ImageButton button = new ImageButton("icons/arrow_right.png");
        panel.add(button);
        return button;
    }
}
