package ru.app.project.design.itemDescription.impl.panels;

import ru.app.project.components.JImage;
import ru.app.project.design.itemDescription.interf.panels.ImagesPDBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BasicImagesPDBuilder implements ImagesPDBuilder {
    private final JPanel panel;
    public BasicImagesPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setOpaque(false);
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }

    @Override
    public JImage buildJImageDesign() {
        JImage imagesPanel = new JImage();
        imagesPanel.setOpaque(false);
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(false);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(imagesPanel);
        jPanel.setBorder(new EmptyBorder(5, 0, 5, 0));
        panel.add(jPanel);
        return imagesPanel;
    }
}
