package ru.app.project.windows.cards.mainSelector;

import ru.app.project.config.window.MainSelectorCStateConfig;
import ru.app.project.design.mainSelector.impl.BasicMainSelectorCDBuilder;
import ru.app.project.design.mainSelector.interf.MainSelectorCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.RootWindow;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;

public class MainSelectorC extends JPanel implements BasicCard {
    private final RootWindow rootWindow;
    private final MainSelectorCDBuilder designBuilder;
    private final ConfigLoader<MainSelectorCStateConfig> configLoader;

    private BasicPanel headerPanel;
    private BasicPanel buttonsPanel;
    private BasicPanel footerPanel;

    public MainSelectorC(RootWindow rootWindow) throws HeadlessException {
        this.rootWindow = rootWindow;
        this.designBuilder = new BasicMainSelectorCDBuilder(this);
        this.configLoader = new ConfigLoader<>(MainSelectorCStateConfig.class);

        this.applyDesign();
        this.applyLogic();
        this.applyConfig();
    }

    @Override
    public void applyDesign() {
        headerPanel = designBuilder.buildHeaderPanelDesign();
        buttonsPanel = designBuilder.buildCenterPanelDesign();
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
    public void applyConfig() {
        headerPanel.applyConfig();
        buttonsPanel.applyConfig();
        footerPanel.applyConfig();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        designBuilder.paint(g);
    }
}
