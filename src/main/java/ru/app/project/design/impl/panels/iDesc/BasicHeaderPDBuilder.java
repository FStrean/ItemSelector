package ru.app.project.design.impl.panels.iDesc;

import ru.app.project.components.JImageButton;
import ru.app.project.design.interf.panels.iDesc.HeaderPDBuilder;
import ru.app.project.components.RelativeLayout;

import javax.swing.*;

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
    public JImageButton buildJButton1Design() {
        JImageButton btn = new JImageButton(System.getProperty("user.dir") + "/icons/arrow_left.png");

        btn.setAlign(JImageButton.LINE_START, JImageButton.LINE_START);

        panel.add(btn, 5.0f);

        return btn;
    }

    @Override
    public JImageButton buildJButton2Design() {
        JImageButton btn = new JImageButton(System.getProperty("user.dir") + "/icons/arrow_right.png");

        btn.setAlign(JImageButton.LINE_START, JImageButton.LINE_START);

        panel.add(btn, 5.0f);

        return btn;
    }

    @Override
    public JLabel buildJLabelDesign() {
        JLabel text = new JLabel();

        text.setOpaque(false);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(text, 90.0f);

        return text;
    }
}
