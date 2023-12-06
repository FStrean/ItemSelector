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
        this.panel.setLayout(new GridLayout(0,1));
    }

    @Override
    public HeaderP buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP();
        panel.add(headerPanel);
        return headerPanel;
    }

    @Override
    public ButtonsP buildButtonsPanelDesign() {
        ButtonsP buttonsPanel = new ButtonsP();
        panel.add(buttonsPanel);
        return buttonsPanel;
    }

    @Override
    public FooterP buildFooterPanelDesign() {
        FooterP headerPanel = new FooterP();
        panel.add(headerPanel);
        return headerPanel;
    }
}
