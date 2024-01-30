package ru.app.project.design.impl.panels.select;

import ru.app.project.design.interf.panels.select.HeaderPDBuilder;

import javax.swing.*;
import java.awt.*;

public class BasicHeaderPDBuilder implements HeaderPDBuilder {
    private final JPanel panel;
    public BasicHeaderPDBuilder(JPanel panel) {
        this.panel = panel;

        this.panel.setOpaque(false);
        this.panel.setLayout(new GridLayout(1,1));
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel text = new JLabel();

        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(text);

        return text;
    }
}
