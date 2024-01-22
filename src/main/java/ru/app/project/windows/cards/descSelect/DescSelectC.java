package ru.app.project.windows.cards.descSelect;

import ru.app.project.config.window.DescSelectCInfoCfg;
import ru.app.project.design.descSelect.impl.BasicDescSelectCDBuilder;
import ru.app.project.design.descSelect.interf.DescSelectCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.RootWindow;

import javax.swing.*;
import java.awt.*;

public class DescSelectC extends JPanel implements BasicCard {
    private final RootWindow rootWin;
    private final DescSelectCDBuilder designBuilder;
    private final ConfigLoader<DescSelectCInfoCfg> configLoader;

    private BasicPanel headerPanel;
    private BasicPanel imagesPanel;
    private BasicPanel buttonsPanel;
    private BasicPanel footerPanel;

    public DescSelectC(RootWindow rootWin) {
        this.rootWin = rootWin;
        this.designBuilder = new BasicDescSelectCDBuilder(this);
        this.configLoader = new ConfigLoader<>(DescSelectCInfoCfg.class);

        this.applyDesign();
        this.applyLogic();
        this.applyConfig();
    }

    @Override
    public void applyDesign() {
        headerPanel = designBuilder.buildHeaderPanelDesign();
        imagesPanel = designBuilder.buildLeftPanelDesign();
        buttonsPanel = designBuilder.buildRightPanelDesign();
        footerPanel = designBuilder.buildFooterPanelDesign();
    }

    @Override
    public void applyLogic() {
        headerPanel.setParent(this);
        imagesPanel.setParent(this);
        buttonsPanel.setParent(this);
        footerPanel.setParent(this);
        headerPanel.setRootWin(rootWin);
        imagesPanel.setRootWin(rootWin);
        buttonsPanel.setRootWin(rootWin);
        footerPanel.setRootWin(rootWin);
        headerPanel.setCfg(configLoader.getCfg());
        imagesPanel.setCfg(configLoader.getCfg());
        buttonsPanel.setCfg(configLoader.getCfg());
        footerPanel.setCfg(configLoader.getCfg());
    }

    @Override
    public void applyConfig() {
        headerPanel.applyConfig();
        imagesPanel.applyConfig();
        buttonsPanel.applyConfig();
        footerPanel.applyConfig();
    }

    @Override
    public void runOnLeaveAction() {
        headerPanel.runOnLeaveAction();
        imagesPanel.runOnLeaveAction();
        buttonsPanel.runOnLeaveAction();
        footerPanel.runOnLeaveAction();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        designBuilder.paint(g);
    }
}
