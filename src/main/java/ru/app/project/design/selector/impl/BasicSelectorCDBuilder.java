package ru.app.project.design.selector.impl;

import ru.app.project.design.selector.interf.SelectorCDBuilder;
import ru.app.project.utility.RelativeLayout;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.selector.panels.ButtonsP;
import ru.app.project.windows.cards.selector.panels.FooterP;
import ru.app.project.windows.cards.selector.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicSelectorCDBuilder implements SelectorCDBuilder {
    private final JPanel panel;
    public BasicSelectorCDBuilder(JPanel panel) {
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
        panel.add(buttonsPanel, 40.0f);
        panel.add(new JPanel(), 20.0f);
        return buttonsPanel;
    }

    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP headerPanel = new FooterP();
        panel.add(headerPanel, 10.0f);
        return headerPanel;
    }
}
