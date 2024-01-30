package ru.app.project.design.impl.panels.iSelect;

import ru.app.project.design.interf.panels.iSelect.UnderHeaderPDBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BasicUnderHeaderPDBuilder implements UnderHeaderPDBuilder {
    private final JPanel panel;
    public BasicUnderHeaderPDBuilder(JPanel panel) {
        this.panel = panel;

        this.panel.setBorder(new EmptyBorder(0, 5, 0, 5));
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
