package ru.app.project.windows.cards.itemDescription;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.ItemDescriptionCStateConfig;
import ru.app.project.design.itemDescription.interf.ItemDescriptionCDBuilder;
import ru.app.project.design.itemDescription.impl.BasicItemDescriptionCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.itemDescription.panels.FooterP;
import ru.app.project.windows.cards.itemDescription.panels.HeaderP;
import ru.app.project.windows.cards.itemDescription.panels.ImagesP;
import ru.app.project.windows.cards.itemDescription.panels.VideosP;

import javax.swing.*;
import java.awt.*;

public class ItemDescriptionC extends JPanel implements BasicCard {
    private final RootWindow rootWindow;

    private final ConfigLoader<ItemDescriptionCStateConfig> configLoader;
    private ItemDescriptionCStateConfig.Item config;

    private final ItemDescriptionCDBuilder designBuilder;

    private HeaderP headerPanel;
    private ImagesP imagesPanel;
    private VideosP videosPanel;
    private FooterP footerPanel;

    public ItemDescriptionC(RootWindow rootWindow) throws HeadlessException {
        this.configLoader = new ConfigLoader<>(ItemDescriptionCStateConfig.class);
        this.rootWindow = rootWindow;
        this.designBuilder = new BasicItemDescriptionCDBuilder(this);

        this.config = null;

        this.applyDesign();
        this.applyLogic();
    }

    public void showState(int id) {
        config = configLoader.getConfig().getItems().stream()
                .filter(listItem -> listItem.getId() == id).findFirst()
                .orElse(new ItemDescriptionCStateConfig.Item());
        imagesPanel.setConfig(config);
        videosPanel.setConfig(config);
        headerPanel.setConfig(config);
        loadConfig();
    }

    @Override
    public void applyDesign() {
        headerPanel = designBuilder.buildHeaderPanelDesign();
        imagesPanel = designBuilder.buildImagePanelDesign();
        videosPanel = designBuilder.buildVideoPlayerPanelDesign();
        footerPanel = designBuilder.buildFooterPanelDesign();
    }

    @Override
    public void applyLogic() {
        headerPanel.setParent(this);
        imagesPanel.setParent(this);
        videosPanel.setParent(this);
        footerPanel.setParent(this);
        headerPanel.setRootWindow(rootWindow);
        imagesPanel.setRootWindow(rootWindow);
        videosPanel.setRootWindow(rootWindow);
        footerPanel.setRootWindow(rootWindow);
    }

    @Override
    public void loadConfig() {
        headerPanel.loadConfig();
        videosPanel.loadConfig();
        imagesPanel.loadConfig();
        footerPanel.loadConfig();
    }

    @Override
    public void runOnLeaveAction() {
        headerPanel.runOnLeaveAction();
        imagesPanel.runOnLeaveAction();
        videosPanel.runOnLeaveAction();
        footerPanel.runOnLeaveAction();
    }
}
