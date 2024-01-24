package ru.app.project.design.video.impl.panels;

import ru.app.project.components.JImageButton;
import ru.app.project.components.RelativeLayout;
import ru.app.project.design.video.interf.panels.HeaderPDBuilder;

import javax.swing.*;
import java.awt.*;

public class BasicHeaderPDBuilder implements HeaderPDBuilder {
    private final JPanel panel;
    public BasicHeaderPDBuilder(JPanel panel) {
        this.panel = panel;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.X_AXIS, 10);

        layout.setFill(true);
        this.panel.setOpaque(false);
        this.panel.setLayout(layout);
    }

    @Override
    public JImageButton buildJButton1Design() {
        JImageButton btn = new JImageButton("icons/alt_arrow_left.png");

        btn.setAlign(JImageButton.LINE_START, JImageButton.LINE_START);
        btn.setBackground(Color.WHITE);

        panel.add(btn, 10.0f);

        return btn;
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel text = new JLabel();

        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(text, 80.0f);

        return text;
    }

    @Override
    public JImageButton buildJButton2Design() {
        JImageButton btn = new JImageButton("icons/alt_arrow_right.png");

        btn.setAlign(JImageButton.LINE_END, JImageButton.LINE_START);

        panel.add(btn, 10.0f);

        return btn;
    }
}
