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


    private BasicPanel header1Panel;
    private BasicPanel header2Panel;
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
        header1Panel.setConfig(config);
        header2Panel.setConfig(config);
        imagesPanel.setConfig(config);
//        videosPanel.setConfig(config);
        descriptionPanel.setConfig(config);
        applyConfig();
    }

    @Override
    public void applyDesign() {
        header1Panel = designBuilder.buildHeader1PanelDesign();
        header2Panel = designBuilder.buildHeader2PanelDesign();
        imagesPanel = designBuilder.buildLeftPanelDesign();
//        videosPanel = designBuilder.buildRightPanelDesign();
        descriptionPanel = designBuilder.buildRightPanelDesign();
        footerPanel = designBuilder.buildFooterPanelDesign();
    }

    @Override
    public void applyLogic() {
        header1Panel.setParent(this);
        header2Panel.setParent(this);
        imagesPanel.setParent(this);
//        videosPanel.setParent(this);
        descriptionPanel.setParent(this);
        footerPanel.setParent(this);
        header1Panel.setRootWindow(rootWindow);
        imagesPanel.setRootWindow(rootWindow);
//        videosPanel.setRootWindow(rootWindow);
        descriptionPanel.setRootWindow(rootWindow);
        footerPanel.setRootWindow(rootWindow);
    }

    @Override
    public void applyConfig() {
        header1Panel.applyConfig();
        header2Panel.applyConfig();
//        videosPanel.applyConfig();
        descriptionPanel.applyConfig();
        imagesPanel.applyConfig();
    }

    @Override
    public void runOnLeaveAction() {
        header1Panel.runOnLeaveAction();
        header2Panel.runOnLeaveAction();
        imagesPanel.runOnLeaveAction();
//        videosPanel.runOnLeaveAction();
        descriptionPanel.runOnLeaveAction();
        footerPanel.runOnLeaveAction();
    }
}
