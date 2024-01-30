package ru.app.project.design.impl.panels.iDescSelect;

import ru.app.project.components.RoundButton;
import ru.app.project.design.interf.panels.iDescSelect.HeaderPDBuilder;
import ru.app.project.components.RelativeLayout;

import javax.swing.*;
import java.awt.*;

public class BasicHeaderPDBuilder implements HeaderPDBuilder {
    private final JPanel panel;
    public BasicHeaderPDBuilder(JPanel panel) {
        this.panel = panel;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.X_AXIS, 20);

        layout.setFill(true);
        this.panel.setOpaque(false);
        this.panel.setLayout(layout);
    }

    @Override
    public JButton buildJButtonDesign() {
        RoundButton btn = new RoundButton("", 40, Color.BLACK);
        Font font = btn.getFont();
        int style = font.getStyle();

        style ^= Font.BOLD;
        font = font.deriveFont(style);

        btn.setFont(font);
        btn.setForeground(Color.WHITE);

        panel.add(btn, 15.0f);

        return btn;
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel text = new JLabel();

        text.setOpaque(false);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(text, 70.0f);

        return text;
    }
}
