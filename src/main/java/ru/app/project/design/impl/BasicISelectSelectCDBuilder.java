package ru.app.project.design.impl;

import ru.app.project.components.RelativeLayout;
import ru.app.project.design.interf.ISelectSelectCDBuilder;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.cards.panels.iSelectSelect.ButtonsP;
import ru.app.project.windows.cards.panels.iSelectSelect.FooterP;
import ru.app.project.windows.cards.panels.iSelectSelect.HeaderP;
import ru.app.project.windows.cards.panels.iSelectSelect.ImagesP;

import javax.swing.*;
import java.awt.*;

public class BasicISelectSelectCDBuilder implements ISelectSelectCDBuilder {
    private final JPanel panel;
    private final JPanel contentPanel;
    public BasicISelectSelectCDBuilder(JPanel panel) {
        this.panel = panel;
        this.contentPanel = new JPanel();
        RelativeLayout mainLayout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);
        RelativeLayout contentLayout = new RelativeLayout(RelativeLayout.X_AXIS, 20);

        contentLayout.setFill(true);
        mainLayout.setFill(true);
        this.panel.setBackground(Color.WHITE);
        this.panel.setLayout(mainLayout);
        this.contentPanel.setOpaque(false);
        this.contentPanel.setLayout(contentLayout);
    }

    @Override
    public StaticPanel buildHeaderPanelDesign() {
        HeaderP hp = new HeaderP();

        panel.add(hp, 15.0f);

        return hp;
    }

    @Override
    public StaticPanel buildLeftPanelDesign() {
        ImagesP ip = new ImagesP();

        contentPanel.add(ip, 75.0f);

        return ip;
    }

    @Override
    public StaticPanel buildRightPanelDesign() {
        JPanel p = new JPanel();
        ButtonsP dp = new ButtonsP();
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        layout.setFill(true);
        p.setLayout(layout);
        p.setOpaque(false);
        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);

        p.add(p1, 25.0f);
        p.add(dp, 50.0f);
        p.add(p2, 25.0f);
        contentPanel.add(p, 15.0f);
        contentPanel.add(p3, 10.0f);
        panel.add(contentPanel, 75.0f);

        return dp;
    }


    @Override
    public StaticPanel buildFooterPanelDesign() {
        FooterP fp = new FooterP();

        panel.add(fp, 10.0f);

        return fp;
    }

    @Override
    public void paint(Graphics g) {

    }
}
