package ru.app.project.design.description.impl;

import ru.app.project.design.description.interf.DescriptionCDBuilder;
import ru.app.project.components.RelativeLayout;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.cards.description.panels.ButtonsP;
import ru.app.project.windows.cards.description.panels.DescriptionP;
import ru.app.project.windows.cards.description.panels.FooterP;
import ru.app.project.windows.cards.description.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicDescriptionCDBuilder implements DescriptionCDBuilder {
    private final JPanel panel;
    private final JPanel contentPanel;
    public BasicDescriptionCDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setBackground(Color.WHITE);
        this.contentPanel = new JPanel();

        this.contentPanel.setOpaque(false);

        RelativeLayout mainLayout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);
        RelativeLayout contentLayout = new RelativeLayout(RelativeLayout.X_AXIS, 20);

        mainLayout.setFill(true);
        contentLayout.setFill(true);

        this.panel.setLayout(mainLayout);
        this.contentPanel.setLayout(contentLayout);
    }

    @Override
    public BasicPanel buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP();
        panel.add(headerPanel, 15.0f);
        return headerPanel;
    }

    @Override
    public BasicPanel buildLeftPanelDesign() {
        ButtonsP buttonsPanel = new ButtonsP();
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(false);
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS);
        layout.setFill(true);
        jPanel.setLayout(layout);
        JPanel jPanel1 = new JPanel();
        jPanel1.setOpaque(false);
        jPanel.add(jPanel1, 10.0f);
        jPanel.add(buttonsPanel, 80.0f);
        JPanel jPanel2 = new JPanel();
        jPanel2.setOpaque(false);
        jPanel.add(jPanel2, 10.0f);
        contentPanel.add(jPanel, 15.0f);
        return buttonsPanel;
    }

    @Override
    public BasicPanel buildRightPanelDesign() {
        DescriptionP descriptionPanel = new DescriptionP();
        contentPanel.add(descriptionPanel, 85.0f);
        panel.add(contentPanel, 75.0f);
        return descriptionPanel;
    }

    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP footerPanel = new FooterP();
        panel.add(footerPanel, 10.0f);
        return footerPanel;
    }

    @Override
    public void paint(Graphics g) {
    }
}
