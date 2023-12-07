package ru.app.project.windows.cards.description;

import ru.app.project.config.window.DescriptionCStateConfig;
import ru.app.project.design.description.impl.BasicDescriptionCDBuilder;
import ru.app.project.design.description.interf.DescriptionCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.RootWindow;

import javax.swing.*;

public class DescriptionC extends JPanel implements BasicCard {
    private final RootWindow rootWindow;
    private final DescriptionCDBuilder designBuilder;
    private final ConfigLoader<DescriptionCStateConfig> configLoader;

    private BasicPanel headerPanel;
    private BasicPanel buttonsPanel;
    private BasicPanel descriptionPanel;
    private BasicPanel footerPanel;
    public DescriptionC(RootWindow rootWindow) {
        this.rootWindow = rootWindow;

        this.designBuilder = new BasicDescriptionCDBuilder(this);
        this.configLoader = new ConfigLoader<>(DescriptionCStateConfig.class);

        this.applyDesign();
        this.applyLogic();
        this.loadConfig();
    }

    @Override
    public void applyDesign() {
        headerPanel = designBuilder.buildHeaderPanelDesign();
        buttonsPanel = designBuilder.buildLeftPanelDesign();
        descriptionPanel = designBuilder.buildRightPanelDesign();
        footerPanel = designBuilder.buildFooterPanelDesign();
    }

    @Override
    public void applyLogic() {
        headerPanel.setParent(this);
        buttonsPanel.setParent(this);
        descriptionPanel.setParent(this);
        footerPanel.setParent(this);
        headerPanel.setRootWindow(rootWindow);
        buttonsPanel.setRootWindow(rootWindow);
        descriptionPanel.setRootWindow(rootWindow);
        footerPanel.setRootWindow(rootWindow);
        headerPanel.setConfig(configLoader.getConfig());
        buttonsPanel.setConfig(configLoader.getConfig());
        descriptionPanel.setConfig(configLoader.getConfig());
        footerPanel.setConfig(configLoader.getConfig());
    }

    @Override
    public void runOnLeaveAction() {

    }

    @Override
    public void loadConfig() {
        headerPanel.loadConfig();
        buttonsPanel.loadConfig();
        descriptionPanel.loadConfig();
        footerPanel.loadConfig();
    }
}
