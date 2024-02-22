package ru.app.project.design.impl;

import ru.app.project.design.interf.IDescCDBuilder;
import ru.app.project.components.RelativeLayout;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.cards.panels.iDesc.DescriptionP;
import ru.app.project.windows.cards.panels.iDesc.FooterP;
import ru.app.project.windows.cards.panels.iDesc.HeaderP;
import ru.app.project.windows.cards.panels.iDesc.ImagesP;

import javax.swing.*;
import java.awt.*;

public class BasicIDescCDBuilder implements IDescCDBuilder {
    private final JPanel panel;
    private final JPanel contentPanel;

    private final RelativeLayout contentLayout;

    private ImagesP ip;
    private DescriptionP dp;
    public BasicIDescCDBuilder(JPanel panel) {
        this.panel = panel;
        this.contentPanel = new JPanel();
        RelativeLayout mainLayout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);
        contentLayout = new RelativeLayout(RelativeLayout.X_AXIS, 20);

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
        ip = new ImagesP();

        contentPanel.add(ip, 35.0f);

        return ip;
    }

    public void updateLeftPanelDesign(float ratio) {
        contentLayout.addLayoutComponent(ip, ratio);
    }

    @Override
    public StaticPanel buildRightPanelDesign() {
        dp = new DescriptionP();

        contentPanel.add(dp, 65.0f);
        panel.add(contentPanel, 75.0f);

        return dp;
    }

    public void updateRightPanelDesign(float ratio) {
        contentLayout.addLayoutComponent(dp, ratio);
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
