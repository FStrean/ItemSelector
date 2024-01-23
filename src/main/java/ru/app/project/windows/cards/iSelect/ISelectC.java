package ru.app.project.windows.cards.iSelect;

import ru.app.project.config.window.ISelectCInfoCfg;
import ru.app.project.design.iSelect.impl.BasicISelectCDBuilder;
import ru.app.project.design.iSelect.interf.ISelectCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MultipleStateCard;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.iSelect.panels.HeaderP;
import ru.app.project.windows.cards.iSelect.panels.LeftP;
import ru.app.project.windows.cards.iSelect.panels.RightP;

import javax.swing.*;
import java.awt.*;

public class ISelectC extends JPanel implements BasicCard, MultipleStateCard {
    private final RootWindow rootWin;
    private final ISelectCDBuilder designBuilder;
    private final ConfigLoader<ISelectCInfoCfg> configLoader;
    private ISelectCInfoCfg.Item cfg;
    private ISelectCInfoCfg addCfg;

    private BasicPanel headerPanel;
    private BasicPanel leftPanel;
    private BasicPanel rightPanel;
    private BasicPanel footerPanel;

    public ISelectC(RootWindow rootWin) {
        this.rootWin = rootWin;
        this.designBuilder = new BasicISelectCDBuilder(this);
        this.configLoader = new ConfigLoader<>(ISelectCInfoCfg.class);
        this.cfg = null;

        this.applyDesign();
        this.applyLogic();

        this.footerPanel.setCfg(configLoader.getCfg());
        this.footerPanel.applyConfig();

        this.addCfg = configLoader.getCfg();
        ((HeaderP)this.headerPanel).setAddCfg(addCfg);
        ((LeftP)this.leftPanel).setAddCfg(addCfg);
        ((RightP)this.rightPanel).setAddCfg(addCfg);
    }

    @Override
    public void showState(int id) {
        cfg = addCfg.getItems().stream()
                .filter(listItem -> listItem.getId() == id).findFirst()
                .orElse(new ISelectCInfoCfg.Item());

        headerPanel.setCfg(cfg);
        leftPanel.setCfg(cfg);
        rightPanel.setCfg(cfg);
        applyConfig();
    }

    @Override
    public void applyDesign() {
        headerPanel = designBuilder.buildHeaderPanelDesign();
        leftPanel = designBuilder.buildLeftPanelDesign();
        rightPanel = designBuilder.buildRightPanelDesign();
        footerPanel = designBuilder.buildFooterPanelDesign();
    }

    @Override
    public void applyLogic() {
        headerPanel.setParent(this);
        leftPanel.setParent(this);
        rightPanel.setParent(this);
        footerPanel.setParent(this);
        headerPanel.setRootWin(rootWin);
        leftPanel.setRootWin(rootWin);
        rightPanel.setRootWin(rootWin);
        footerPanel.setRootWin(rootWin);
    }

    @Override
    public void applyConfig() {
        headerPanel.applyConfig();
        rightPanel.applyConfig();
        leftPanel.applyConfig();
    }

    @Override
    public void runOnLeaveAction() {
        headerPanel.runOnLeaveAction();
        leftPanel.runOnLeaveAction();
        rightPanel.runOnLeaveAction();
        footerPanel.runOnLeaveAction();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        designBuilder.paint(g);
    }
}