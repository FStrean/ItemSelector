package ru.app.project.design.mainSelector.impl;

import ru.app.project.design.mainSelector.interf.MainSelectorCDBuilder;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.mainSelector.panels.ButtonsP;
import ru.app.project.windows.cards.mainSelector.panels.FooterP;
import ru.app.project.windows.cards.mainSelector.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicMainSelectorCDBuilder implements MainSelectorCDBuilder {
    private RootWindow rootWindow;
    private final JPanel panel;
    public BasicMainSelectorCDBuilder(RootWindow rootWindow, JPanel panel) {
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
        ButtonsP buttonsPanel = new ButtonsP(rootWindow);
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
