package ru.app.project.windows.cards.iDescSelect;

import ru.app.project.config.window.IDescSelectCInfoCfg;
import ru.app.project.design.iDescSelect.impl.BasicIDescSelectCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.RootWindow;

import javax.swing.*;

public class IDescSelectC extends JPanel implements BasicCard {
    private final RootWindow rootWindow;
    private final BasicIDescSelectCDBuilder designBuilder;
    private final ConfigLoader<IDescSelectCInfoCfg> configLoader;

    private BasicPanel headerPanel;
    private BasicPanel buttonsPanel;
    private BasicPanel footerPanel;

    public IDescSelectC(RootWindow rootWIndow) {
        this.rootWindow = rootWIndow;
        this.designBuilder = new BasicIDescSelectCDBuilder(this);
        this.configLoader = new ConfigLoader<>(IDescSelectCInfoCfg.class);

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
}
