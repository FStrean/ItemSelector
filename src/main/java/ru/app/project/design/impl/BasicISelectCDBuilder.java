package ru.app.project.design.impl;

import ru.app.project.components.RelativeLayout;
import ru.app.project.design.interf.ISelectCDBuilder;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.cards.panels.iSelect.*;

import javax.swing.*;
import java.awt.*;

public class BasicISelectCDBuilder implements ISelectCDBuilder {
    private final JPanel panel;
    private final JPanel contentPanel;
    public BasicISelectCDBuilder(JPanel panel) {
        this.panel = panel;
        this.contentPanel = new JPanel();
        RelativeLayout mainLayout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);
        RelativeLayout contentLayout = new RelativeLayout(RelativeLayout.X_AXIS, 5);

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

        panel.add(hp, 10.0f);

        return hp;
    }

    @Override
    public StaticPanel buildUnderHeaderPanelDesign() {
        UnderHeaderP uhp = new UnderHeaderP();

        panel.add(uhp, 10f);

        return uhp;
    }

    @Override
    public StaticPanel buildLeftPanelDesign() {
        LeftP ip = new LeftP();

        contentPanel.add(ip, 50.0f);
        panel.add(contentPanel, 70.f);

        return ip;
    }

    @Override
    public StaticPanel buildRightPanelDesign() {
        RightP dp = new RightP();

        contentPanel.add(dp, 50.0f);

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
