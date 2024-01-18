package ru.app.project.windows.cards.desc;

import ru.app.project.config.window.DescCInfoCfg;
import ru.app.project.design.desc.impl.BasicDescCDBuilder;
import ru.app.project.design.desc.interf.DescCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.RootWindow;

import javax.swing.*;
import java.awt.*;

public class DescC extends JPanel implements BasicCard {
    private final RootWindow rootWindow;
    private final DescCDBuilder designBuilder;
    private final ConfigLoader<DescCInfoCfg> configLoader;

    private BasicPanel headerPanel;
    private BasicPanel buttonsPanel;
    private BasicPanel descriptionPanel;
    private BasicPanel footerPanel;
    public DescC(RootWindow rootWindow) {
        this.rootWindow = rootWindow;

        this.designBuilder = new BasicDescCDBuilder(this);
        this.configLoader = new ConfigLoader<>(DescCInfoCfg.class);

        this.applyDesign();
        this.applyLogic();
        this.applyConfig();
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
    public void applyConfig() {
        headerPanel.applyConfig();
        buttonsPanel.applyConfig();
        descriptionPanel.applyConfig();
        footerPanel.applyConfig();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        designBuilder.paint(g);
    }
}
