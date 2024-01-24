package ru.app.project.design.iSelect.impl.panels;

import ru.app.project.components.RelativeLayout;
import ru.app.project.design.iSelect.interf.panels.UnderHeaderPDBuilder;

import javax.swing.*;

public class BasicUnderHeaderPDBuilder implements UnderHeaderPDBuilder {
    private final JPanel panel;
    public BasicUnderHeaderPDBuilder(JPanel panel) {
        this.panel = panel;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);

        this.panel.setOpaque(false);
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }
    @Override
    public JLabel buildJLabelDesign() {
        return null;
    }
}
