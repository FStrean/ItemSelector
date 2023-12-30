package ru.app.project.windows.cards.itemDescription;

import ru.app.project.config.window.ItemDescriptionCStateConfig;
import ru.app.project.design.itemDescription.interf.ItemDescriptionCDBuilder;
import ru.app.project.design.itemDescription.impl.BasicItemDescriptionCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.RootWindow;

import javax.swing.*;

public class ItemDescriptionC extends JPanel implements BasicCard {
    private final RootWindow rootWindow;
    private final ItemDescriptionCDBuilder designBuilder;
    private final ConfigLoader<ItemDescriptionCStateConfig> configLoader;
    private ItemDescriptionCStateConfig.Item config;


    private BasicPanel headerPanel;
    private BasicPanel imagesPanel;
//    private BasicPanel videosPanel;
    private BasicPanel descriptionPanel;
    private BasicPanel footerPanel;

    public ItemDescriptionC(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
        this.designBuilder = new BasicItemDescriptionCDBuilder(this);
        this.configLoader = new ConfigLoader<>(ItemDescriptionCStateConfig.class);
        this.config = null;

        this.applyDesign();
        this.applyLogic();

        this.footerPanel.setConfig(configLoader.getConfig());
        this.footerPanel.applyConfig();
    }

    public void showState(int id) {
        config = configLoader.getConfig().getItems().stream()
                .filter(listItem -> listItem.getId() == id).findFirst()
                .orElse(new ItemDescriptionCStateConfig.Item());
        headerPanel.setConfig(config);
        imagesPanel.setConfig(config);
//        videosPanel.setConfig(config);
        descriptionPanel.setConfig(config);
        applyConfig();
    }

    @Override
    public void applyDesign() {
        headerPanel = designBuilder.buildHeaderPanelDesign();
        imagesPanel = designBuilder.buildLeftPanelDesign();
//        videosPanel = designBuilder.buildRightPanelDesign();
        descriptionPanel = designBuilder.buildRightPanelDesign();
        footerPanel = designBuilder.buildFooterPanelDesign();
    }

    @Override
    public void applyLogic() {
        headerPanel.setParent(this);
        imagesPanel.setParent(this);
//        videosPanel.setParent(this);
        descriptionPanel.setParent(this);
        footerPanel.setParent(this);
        headerPanel.setRootWindow(rootWindow);
        imagesPanel.setRootWindow(rootWindow);
//        videosPanel.setRootWindow(rootWindow);
        descriptionPanel.setRootWindow(rootWindow);
        footerPanel.setRootWindow(rootWindow);
    }

    @Override
    public void applyConfig() {
        headerPanel.applyConfig();
//        videosPanel.applyConfig();
        descriptionPanel.applyConfig();
        imagesPanel.applyConfig();
    }

    @Override
    public void runOnLeaveAction() {
        headerPanel.runOnLeaveAction();
        imagesPanel.runOnLeaveAction();
//        videosPanel.runOnLeaveAction();
        descriptionPanel.runOnLeaveAction();
        footerPanel.runOnLeaveAction();
    }
}
