package ru.app.project.design.itemDescriptionSelector.impl;

import ru.app.project.design.itemDescriptionSelector.interf.ItemDescriptionSelectorCDBuilder;
import ru.app.project.utility.RelativeLayout;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.cards.itemDescriptionSelector.panels.ButtonsP;
import ru.app.project.windows.cards.itemDescriptionSelector.panels.FooterP;
import ru.app.project.windows.cards.itemDescriptionSelector.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicItemDescriptionSelectorCDBuilder implements ItemDescriptionSelectorCDBuilder {
    private final JPanel panel;

    public BasicItemDescriptionSelectorCDBuilder(JPanel panel) {
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
        panel.add(buttonsPanel, 75.0f);
        return buttonsPanel;
    }

    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP footerP = new FooterP();
        panel.add(footerP, 10.0f);
        return footerP;
    }
}
