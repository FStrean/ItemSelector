package ru.app.project.design.iDescSelect.impl;

import ru.app.project.design.iDescSelect.interf.IDescSelectCDBuilder;
import ru.app.project.components.RelativeLayout;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.cards.iDescSelect.panels.ButtonsP;
import ru.app.project.windows.cards.iDescSelect.panels.FooterP;
import ru.app.project.windows.cards.iDescSelect.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicIDescSelectCDBuilder implements IDescSelectCDBuilder {
    private final JPanel panel;

    public BasicIDescSelectCDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setBackground(Color.WHITE);
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);
        layout.setFill(true);
        this.panel.setLayout(layout);
    }

    @Override
    public BasicPanel buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP();
        panel.add(headerPanel, 15.0f);
        return headerPanel;
    }

    @Override
    public BasicPanel buildCenterPanelDesign() {
        ButtonsP buttonsPanel = new ButtonsP();
        panel.add(buttonsPanel, 75.0f);
        return buttonsPanel;
    }

    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP footerP = new FooterP();
        panel.add(footerP, 10.0f);
        return footerP;
    }

    @Override
    public void paint(Graphics g) {

    }
}
