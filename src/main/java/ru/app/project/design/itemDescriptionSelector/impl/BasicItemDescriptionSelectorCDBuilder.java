package ru.app.project.design.itemDescriptionSelector.impl;

import ru.app.project.design.BasicSettings;
import ru.app.project.design.itemDescriptionSelector.interf.ItemDescriptionSelectorCDBuilder;
import ru.app.project.windows.MainWindow;
import ru.app.project.windows.cards.itemDescriptionSelector.panels.ButtonsP;
import ru.app.project.windows.cards.itemDescriptionSelector.panels.FooterP;
import ru.app.project.windows.cards.itemDescriptionSelector.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicItemDescriptionSelectorCDBuilder implements ItemDescriptionSelectorCDBuilder {
    private final MainWindow mainWindow;
    private final JPanel panel;

    public BasicItemDescriptionSelectorCDBuilder(MainWindow mainWindow, JPanel panel) {
        this.mainWindow = mainWindow;
        this.panel = panel;
        this.panel.setLayout(new GridBagLayout());
    }

    @Override
    public HeaderP buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP(mainWindow);

        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;

        panel.add(headerPanel, constraints);
        return headerPanel;
    }

    @Override
    public ButtonsP buildButtonsPanelDesign() {
        ButtonsP buttonsPanel = new ButtonsP(mainWindow);

        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        panel.add(buttonsPanel, constraints);
        return buttonsPanel;
    }

    @Override
    public FooterP buildFooterPanelDesign() {
        FooterP footerP = new FooterP(mainWindow);

        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;

        panel.add(footerP, constraints);
        return footerP;
    }
}
