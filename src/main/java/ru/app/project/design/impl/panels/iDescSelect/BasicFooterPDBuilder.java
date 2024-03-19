package ru.app.project.design.impl.panels.iDescSelect;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.design.interf.panels.iDescSelect.FooterPDBuilder;
import ru.app.project.components.RelativeLayout;

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

        panel.add(text, 95.0f);

        return text;
    }

    @Override
    public JImageButton buildJButtonDesign() {
        JImageButton btn = new JImageButton(AppProperties.getWorkingDirPath() + "/icons/home.png");

        panel.add(btn, 5.0f);

        return btn;
    }
}
