package ru.app.project.design.mainSelector.impl;

import ru.app.project.design.mainSelector.interf.MainSelectorCDBuilder;
import ru.app.project.utility.RelativeLayout;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.cards.mainSelector.panels.ButtonsP;
import ru.app.project.windows.cards.mainSelector.panels.FooterP;
import ru.app.project.windows.cards.mainSelector.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicMainSelectorCDBuilder implements MainSelectorCDBuilder {
    private final JPanel panel;
    public BasicMainSelectorCDBuilder(JPanel panel) {
        this.panel = panel;
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
        panel.add(new JPanel(), 15.0f);
        panel.add(buttonsPanel, 50.0f);
        panel.add(new JPanel(), 10.0f);
        return buttonsPanel;
    }

    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP footerPanel = new FooterP();
        panel.add(footerPanel, 10.0f);
        return footerPanel;
    }
}
