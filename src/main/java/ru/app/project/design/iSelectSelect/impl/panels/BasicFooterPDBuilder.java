package ru.app.project.design.iSelectSelect.impl.panels;

import ru.app.project.components.JImageButton;
import ru.app.project.components.RelativeLayout;
import ru.app.project.design.iSelectSelect.interf.panels.FooterPDBuilder;

import javax.swing.*;
import java.awt.*;

public class BasicFooterPDBuilder implements FooterPDBuilder {
    private final JPanel panel;
    public BasicFooterPDBuilder(JPanel panel) {
        this.panel = panel;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.X_AXIS, 20);

        layout.setFill(true);
        this.panel.setOpaque(false);
        this.panel.setLayout(layout);
    }
    @Override
    public JButton buildJButton1Design() {
        JButton btn = new JButton();

        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.BLACK);

        panel.add(btn, 15.0f);

        return btn;
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

        panel.add(text, 80.0f);

        return text;
    }

    @Override
    public JImageButton buildJButton2Design() {
        JImageButton btn = new JImageButton("icons/home.png");

        btn.setAlign(JImageButton.LINE_END, JImageButton.LINE_END);

        panel.add(btn, 5.0f);

        return btn;
    }
}
