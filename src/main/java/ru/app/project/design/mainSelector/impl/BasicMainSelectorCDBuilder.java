package ru.app.project.design.mainSelector.impl;

import ru.app.project.design.BasicSettings;
import ru.app.project.design.mainSelector.interf.MainSelectorCDBuilder;
import ru.app.project.windows.RootWindow;
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
    public HeaderP buildHeaderPanelDesign() {
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
    public ButtonsP buildButtonsPanelDesign() {
        ButtonsP buttonsPanel = new ButtonsP();
        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.9;
        panel.add(buttonsPanel, constraints);
        return buttonsPanel;
    }

    @Override
    public FooterP buildFooterPanelDesign() {
        FooterP headerPanel = new FooterP();
        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.05;
        panel.add(headerPanel, constraints);
        return headerPanel;
    }
}
