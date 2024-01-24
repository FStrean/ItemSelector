package ru.app.project.design.iSelect.impl;

import ru.app.project.components.RelativeLayout;
import ru.app.project.design.iSelect.interf.ISelectCDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.cards.iSelect.panels.RightP;
import ru.app.project.windows.cards.iSelect.panels.FooterP;
import ru.app.project.windows.cards.iSelect.panels.HeaderP;
import ru.app.project.windows.cards.iSelect.panels.LeftP;

import javax.swing.*;
import java.awt.*;

public class BasicISelectCDBuilder implements ISelectCDBuilder {
    private final JPanel panel;
    private final JPanel contentPanel;
    public BasicISelectCDBuilder(JPanel panel) {
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
    public BasicPanel buildHeaderPanelDesign() {
        HeaderP hp = new HeaderP();

        panel.add(hp, 15.0f);

        return hp;
    }

    @Override
    public BasicPanel buildLeftPanelDesign() {
        LeftP ip = new LeftP();

        contentPanel.add(ip, 50.0f);
        panel.add(contentPanel, 75.0f);

        return ip;
    }

    @Override
    public BasicPanel buildRightPanelDesign() {
        RightP dp = new RightP();

        contentPanel.add(dp, 50.0f);

        return dp;
    }


    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP fp = new FooterP();

        panel.add(fp, 10.0f);

        return fp;
    }

    @Override
    public void paint(Graphics g) {

    }
}
