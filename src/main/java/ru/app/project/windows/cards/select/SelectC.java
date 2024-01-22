package ru.app.project.windows.cards.select;

import ru.app.project.config.window.SelectCInfoCfg;
import ru.app.project.design.select.impl.BasicSelectCDBuilder;
import ru.app.project.design.select.interf.SelectCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.RootWindow;

import javax.swing.*;
import java.awt.*;

public class SelectC extends JPanel implements BasicCard {
    private final RootWindow rootWin;
    private final SelectCDBuilder designBuilder;
    private final ConfigLoader<SelectCInfoCfg> configLoader;

    private BasicPanel headerPanel;
    private BasicPanel buttonsPanel;
    private BasicPanel footerPanel;

    public SelectC(RootWindow rootWin) throws HeadlessException {
        this.rootWin = rootWin;
        this.designBuilder = new BasicSelectCDBuilder(this);
        this.configLoader = new ConfigLoader<>(SelectCInfoCfg.class);

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
        headerPanel.setRootWin(rootWin);
        buttonsPanel.setRootWin(rootWin);
        footerPanel.setRootWin(rootWin);
        headerPanel.setCfg(configLoader.getCfg());
        buttonsPanel.setCfg(configLoader.getCfg());
        footerPanel.setCfg(configLoader.getCfg());
    }

    @Override
    public void runOnLeaveAction() {
        headerPanel.runOnLeaveAction();
        buttonsPanel.runOnLeaveAction();
        footerPanel.runOnLeaveAction();
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