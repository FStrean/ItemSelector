package ru.app.project.design.mainSelector.impl;

import ru.app.project.design.BasicSettings;
import ru.app.project.design.mainSelector.interf.MainSelectorCDBuilder;
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
        this.panel.setLayout(new GridBagLayout());
    }

    @Override
    public BasicPanel buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP();
        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.05;
        panel.add(headerPanel, constraints);
        return headerPanel;
    }

    @Override
    public BasicPanel buildCenterPanelDesign() {
        GridBagConstraints constraints__ = new GridBagConstraints();
        constraints__.fill = GridBagConstraints.BOTH;
        constraints__.gridx = 0;
        constraints__.gridy = 1;
        constraints__.weightx = 1;
        constraints__.weighty = 0.3;
        panel.add(new JPanel(), constraints__);

        ButtonsP buttonsPanel = new ButtonsP();
        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.35;
        panel.add(buttonsPanel, constraints);

        GridBagConstraints constraints_ = new GridBagConstraints();
        constraints_.fill = GridBagConstraints.BOTH;
        constraints_.gridx = 0;
        constraints_.gridy = 3;
        constraints_.weightx = 1;
        constraints_.weighty = 0.3;
        panel.add(new JPanel(), constraints_);
        return buttonsPanel;
    }

    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP headerPanel = new FooterP();
        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.05;
        panel.add(headerPanel, constraints);
        return headerPanel;
    }
}
