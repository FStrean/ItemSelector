package ru.app.project.design.selector.impl.panels;

import ru.app.project.components.ImageButton;
import ru.app.project.components.RoundButton;
import ru.app.project.design.selector.interf.panels.FooterPDBuilder;
import ru.app.project.components.RelativeLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BasicFooterPDBuilder implements FooterPDBuilder {
    private final JPanel panel;
    private final JPanel leftButtonPanel;
    public BasicFooterPDBuilder(JPanel panel) {
        leftButtonPanel = new JPanel();
        leftButtonPanel.setLayout(new GridLayout(0,1));
        this.panel = panel;
        this.panel.setOpaque(false);
        leftButtonPanel.setOpaque(false);
        RelativeLayout layout = new RelativeLayout(RelativeLayout.X_AXIS, 20);
        layout.setFill(true);
        this.panel.setLayout(layout);
        this.panel.add(leftButtonPanel, 10.0f);
    }

    @Override
    public JButton buildLeftButtonDesign() {
        RoundButton button = new RoundButton("", 40, Color.BLACK);
        button.setForeground(Color.WHITE);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setOpaque(false);
        jPanel.setBorder(new EmptyBorder(5, 0, 5, 0));
        jPanel.add(button);
        leftButtonPanel.add(jPanel);
        return button;
    }

    @Override
    public JLabel buildJLabelDesign() {
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setOpaque(false);
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS);
        layout.setFill(true);
        descriptionPanel.setLayout(layout);
        JPanel jPanel1  = new JPanel();
        jPanel1.setOpaque(false);
        descriptionPanel.add(jPanel1, 67.0f);
        JLabel description = new JLabel();
        description.setOpaque(false);
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        descriptionPanel.add(description, 33.0f);
        panel.add(descriptionPanel, 85.0f);
        return description;
    }

    @Override
    public ImageButton buildJButtonDesign() {
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setOpaque(false);
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS);
        layout.setFill(true);
        homeButtonPanel.setLayout(layout);
        JPanel jPanel1 = new JPanel();
        jPanel1.setOpaque(false);
        homeButtonPanel.add(jPanel1, 67.0f);
        ImageButton button = new ImageButton("icons/home.png");
        button.setAlign(BorderLayout.LINE_END, BorderLayout.LINE_END);
        homeButtonPanel.add(button, 33.0f);
        panel.add(homeButtonPanel, 5.0f);
        return button;
    }
}
