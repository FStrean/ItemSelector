package ru.app.project.design.iDesc.impl.panels;

import ru.app.project.components.JImage;
import ru.app.project.design.iDesc.interf.panels.ImagesPDBuilder;

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
        JImage ip = new JImage();
        JPanel p = new JPanel();

        ip.setOpaque(false);
        p.setOpaque(false);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(5, 0, 5, 0));

        p.add(ip);
        panel.add(p);

        return ip;
    }
}
