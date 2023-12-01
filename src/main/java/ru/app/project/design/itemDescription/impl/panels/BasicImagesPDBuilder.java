package ru.app.project.design.itemDescription.impl.panels;

import javax.swing.*;

public class BasicImagesPDBuilder {
    private final JPanel panel;

    public BasicImagesPDBuilder(JPanel panel) {
        this.panel = panel;
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }
}
