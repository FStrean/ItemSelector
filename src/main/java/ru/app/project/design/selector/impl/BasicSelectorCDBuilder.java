package ru.app.project.design.selector.impl;

import ru.app.project.design.selector.interf.SelectorCDBuilder;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.selector.panels.ButtonsP;
import ru.app.project.windows.cards.selector.panels.FooterP;
import ru.app.project.windows.cards.selector.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicSelectorCDBuilder implements SelectorCDBuilder {
    private RootWindow rootWindow;
    private final JPanel panel;
    public BasicSelectorCDBuilder(JPanel panel) {
        this.rootWindow = rootWindow;
        this.panel = panel;
        this.panel.setLayout(new GridBagLayout());
    }

    @Override
    public HeaderP buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0.2;
        panel.add(headerPanel, constraints);
        return headerPanel;
    }

    @Override
    public ButtonsP buildButtonsPanelDesign() {
        GridBagConstraints constraints__ = new GridBagConstraints();
        constraints__.fill = GridBagConstraints.BOTH;
        constraints__.gridx = 0;
        constraints__.gridy = 1;
        constraints__.weightx = 1;
        constraints__.weighty = 0.2;
        panel.add(new JPanel(), constraints__);

        ButtonsP buttonsPanel = new ButtonsP();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1;
        constraints.weighty = 0.3;
        panel.add(buttonsPanel, constraints);

        GridBagConstraints constraints_ = new GridBagConstraints();
        constraints_.fill = GridBagConstraints.BOTH;
        constraints_.gridx = 0;
        constraints_.gridy = 3;
        constraints_.weightx = 1;
        constraints_.weighty = 0.2;
        panel.add(new JPanel(), constraints_);

        return buttonsPanel;
    }

    @Override
    public FooterP buildFooterPanelDesign() {
        FooterP headerPanel = new FooterP();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        panel.add(headerPanel, constraints);
        return headerPanel;
    }
}
