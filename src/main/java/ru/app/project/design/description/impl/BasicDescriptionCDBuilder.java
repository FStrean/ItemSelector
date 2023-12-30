package ru.app.project.design.description.impl;

import ru.app.project.design.description.interf.DescriptionCDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.cards.description.panels.ButtonsP;
import ru.app.project.windows.cards.description.panels.DescriptionP;
import ru.app.project.windows.cards.description.panels.FooterP;
import ru.app.project.windows.cards.description.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicDescriptionCDBuilder implements DescriptionCDBuilder {
    private final JPanel panel;
    public BasicDescriptionCDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridBagLayout());
    }

    @Override
    public BasicPanel buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.BOTH;

        panel.add(headerPanel, constraints);
        return headerPanel;
    }

    @Override
    public BasicPanel buildLeftPanelDesign() {
        ButtonsP buttonsPanel = new ButtonsP();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.8;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.BOTH;

        panel.add(buttonsPanel, constraints);
        return buttonsPanel;
    }

    @Override
    public BasicPanel buildRightPanelDesign() {
        DescriptionP descriptionPanel = new DescriptionP();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.9;
        constraints.weighty = 0.8;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.BOTH;

        panel.add(descriptionPanel, constraints);
        return descriptionPanel;
    }

    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP footerPanel = new FooterP();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.BOTH;

        panel.add(footerPanel, constraints);
        return footerPanel;
    }
}
