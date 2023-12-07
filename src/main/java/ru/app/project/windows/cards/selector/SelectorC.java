package ru.app.project.windows.cards.selector;

import ru.app.project.config.window.SelectorCStateConfig;
import ru.app.project.design.selector.impl.BasicSelectorCDBuilder;
import ru.app.project.design.selector.interf.SelectorCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.selector.panels.ButtonsP;
import ru.app.project.windows.cards.selector.panels.FooterP;
import ru.app.project.windows.cards.selector.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class SelectorC extends JPanel implements BasicCard {
    private final RootWindow rootWindow;
    private final SelectorCDBuilder designBuilder;
    private final ConfigLoader<SelectorCStateConfig> configLoader;

    private HeaderP headerPanel;
    private ButtonsP buttonsPanel;
    private FooterP footerPanel;

    public SelectorC(RootWindow rootWindow) throws HeadlessException {
        this.rootWindow = rootWindow;
        this.designBuilder = new BasicSelectorCDBuilder(this);
        this.configLoader = new ConfigLoader<>(SelectorCStateConfig.class);

        this.applyDesign();
        this.applyLogic();
        this.loadConfig();
    }

    @Override
    public void applyDesign() {
        headerPanel = designBuilder.buildHeaderPanelDesign();
        buttonsPanel = designBuilder.buildButtonsPanelDesign();
        footerPanel = designBuilder.buildFooterPanelDesign();
    }

    @Override
    public void applyLogic() {
        headerPanel.setParent(this);
        buttonsPanel.setParent(this);
        footerPanel.setParent(this);
        headerPanel.setRootWindow(rootWindow);
        buttonsPanel.setRootWindow(rootWindow);
        footerPanel.setRootWindow(rootWindow);
        headerPanel.setConfig(configLoader.getConfig());
        buttonsPanel.setConfig(configLoader.getConfig());
        footerPanel.setConfig(configLoader.getConfig());
    }

    @Override
    public void runOnLeaveAction() {

    }

    @Override
    public void loadConfig() {
        headerPanel.loadConfig();
        buttonsPanel.loadConfig();
        footerPanel.loadConfig();
    }
}