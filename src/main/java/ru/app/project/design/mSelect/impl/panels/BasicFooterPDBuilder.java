package ru.app.project.design.mSelect.impl.panels;

import ru.app.project.design.mSelect.interf.panels.FooterPDBuilder;

import javax.swing.*;
import java.awt.*;

public class BasicFooterPDBuilder implements FooterPDBuilder {
    private final JPanel panel;
    public BasicFooterPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setOpaque(false);
        this.panel.setLayout(new GridLayout(1,1));
    }
    @Override
    public JLabel buildJLabelDesign() {
        JLabel description = new JLabel();
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(description);
        return description;
    }
}
