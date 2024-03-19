package ru.app.project.design.impl.panels.video;

import ru.app.project.components.JImageButton;
import ru.app.project.components.RelativeLayout;
import ru.app.project.components.RoundButton;
import ru.app.project.config.AppProperties;
import ru.app.project.design.interf.panels.video.FooterPDBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BasicFooterPDBuilder implements FooterPDBuilder {
    private final JPanel panel;
    private final JPanel leftButtonPanel;
    public BasicFooterPDBuilder(JPanel panel) {
        this.panel = panel;
        this.leftButtonPanel = new JPanel();
        RelativeLayout layout = new RelativeLayout(RelativeLayout.X_AXIS, 20);

        layout.setFill(true);
        this.leftButtonPanel.setOpaque(false);
        this.leftButtonPanel.setLayout(new GridLayout(0,1));
        this.panel.setOpaque(false);
        this.panel.setLayout(layout);

        this.panel.add(leftButtonPanel, 10.0f);
    }

    @Override
    public JButton buildLeftButtonDesign() {
        RoundButton btn = new RoundButton("", 40, Color.BLACK);
        JPanel p = new JPanel(new BorderLayout());
        Font font = btn.getFont();
        int style = font.getStyle();

        style ^= Font.BOLD;
        font = font.deriveFont(style);

        btn.setFont(font);
        btn.setForeground(Color.WHITE);
        p.setOpaque(false);
        p.setBorder(new EmptyBorder(5, 0, 5, 0));

        p.add(btn);
        leftButtonPanel.add(p);

        return btn;
    }

    @Override
    public JLabel buildJLabelDesign() {
        JPanel dp = new JPanel();
        JLabel text = new JLabel();
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS);
        JPanel p = new JPanel();
        Font font = text.getFont();
        int style = font.getStyle();

        style ^= Font.BOLD;
        font = font.deriveFont(style);

        text.setFont(font);
        layout.setFill(true);
        dp.setOpaque(false);
        dp.setLayout(layout);
        p.setOpaque(false);
        text.setOpaque(false);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setHorizontalAlignment(SwingConstants.CENTER);

        dp.add(p, 67.0f);
        dp.add(text, 33.0f);
        panel.add(dp, 85.0f);

        return text;
    }

    @Override
    public JImageButton buildJButtonDesign() {
        JPanel hbp = new JPanel();
        JPanel p = new JPanel();
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS);
        JImageButton btn = new JImageButton(AppProperties.getWorkingDirPath() + "/icons/home.png");

        layout.setFill(true);
        hbp.setOpaque(false);
        hbp.setLayout(layout);
        p.setOpaque(false);
        btn.setAlign(JImageButton.LINE_END, JImageButton.LINE_END);

        hbp.add(p, 67.0f);
        hbp.add(btn, 33.0f);
        panel.add(hbp, 5.0f);

        return btn;
    }
}
