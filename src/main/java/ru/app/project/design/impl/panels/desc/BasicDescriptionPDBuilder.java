package ru.app.project.design.impl.panels.desc;

import ru.app.project.design.interf.panels.desc.DescriptionPDBuilder;

import javax.swing.*;
import java.awt.*;

public class BasicDescriptionPDBuilder implements DescriptionPDBuilder {
    private final JPanel panel;
    public BasicDescriptionPDBuilder(JPanel panel) {
        this.panel = panel;

        this.panel.setOpaque(false);
        this.panel.setLayout(new BorderLayout());
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel text = new JLabel();
        Font font = text.getFont();
        int style = font.getStyle();

        style ^= Font.BOLD;
        font = font.deriveFont(style);

        text.setFont(font);
        text.setOpaque(false);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(text);

        return text;
    }
}
