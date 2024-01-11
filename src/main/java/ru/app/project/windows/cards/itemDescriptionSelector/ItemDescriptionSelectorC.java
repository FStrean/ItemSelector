package ru.app.project.windows.cards.itemDescriptionSelector;

import ru.app.project.config.window.ItemDescriptionSelectorCStateConfig;
import ru.app.project.design.itemDescriptionSelector.impl.BasicItemDescriptionSelectorCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.RootWindow;

import javax.swing.*;
import java.awt.*;

public class ItemDescriptionSelectorC extends JPanel implements BasicCard {
    private final RootWindow rootWindow;
    private final BasicItemDescriptionSelectorCDBuilder designBuilder;
    private final ConfigLoader<ItemDescriptionSelectorCStateConfig> configLoader;

    private BasicPanel headerPanel;
    private BasicPanel buttonsPanel;
    private BasicPanel footerPanel;

    public ItemDescriptionSelectorC(RootWindow rootWIndow) {
        this.rootWindow = rootWIndow;
        this.designBuilder = new BasicItemDescriptionSelectorCDBuilder(this);
        this.configLoader = new ConfigLoader<>(ItemDescriptionSelectorCStateConfig.class);

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
