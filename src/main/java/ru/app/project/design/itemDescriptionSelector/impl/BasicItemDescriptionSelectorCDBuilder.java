package ru.app.project.design.itemDescriptionSelector.impl;

import ru.app.project.design.itemDescriptionSelector.interf.ItemDescriptionSelectorCDBuilder;
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
        this.panel.setLayout(new GridBagLayout());
    }

    @Override
    public BasicPanel buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.BOTH;

        panel.add(headerPanel, constraints);
        return headerPanel;
    }

    @Override
    public BasicPanel buildCenterPanelDesign() {
        ButtonsP buttonsPanel = new ButtonsP();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.BOTH;

        panel.add(buttonsPanel, constraints);
        return buttonsPanel;
    }

    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP footerP = new FooterP();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.BOTH;

        panel.add(footerP, constraints);
        return footerP;
    }
}
