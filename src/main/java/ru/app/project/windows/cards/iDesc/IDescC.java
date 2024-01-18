package ru.app.project.windows.cards.iDesc;

import ru.app.project.config.window.IDescCInfoCfg;
import ru.app.project.design.iDesc.interf.IDescCDBuilder;
import ru.app.project.design.iDesc.impl.BasicIDescCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.iDesc.panels.DescriptionP;
import ru.app.project.windows.cards.iDesc.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class IDescC extends JPanel implements BasicCard {
    private final RootWindow rootWin;
    private final IDescCDBuilder designBuilder;
    private final ConfigLoader<IDescCInfoCfg> configLoader;
    private IDescCInfoCfg.Item cfg;
    private IDescCInfoCfg addCfg;

    private BasicPanel headerPanel;
    private BasicPanel imagesPanel;
    private BasicPanel descriptionPanel;
    private BasicPanel footerPanel;

    public IDescC(RootWindow rootWin) {
        this.rootWin = rootWin;
        this.designBuilder = new BasicIDescCDBuilder(this);
        this.configLoader = new ConfigLoader<>(IDescCInfoCfg.class);
        this.cfg = null;

        this.applyDesign();
        this.applyLogic();

        this.footerPanel.setCfg(configLoader.getCfg());
        this.footerPanel.applyConfig();

        this.addCfg = configLoader.getCfg();
        ((DescriptionP)this.descriptionPanel).setAddCfg(addCfg);
        ((HeaderP)this.headerPanel).setAddCfg(addCfg);
    }

    public void showState(int id) {
        cfg = addCfg.getItems().stream()
                .filter(listItem -> listItem.getId() == id).findFirst()
                .orElse(new IDescCInfoCfg.Item());

        headerPanel.setCfg(cfg);
        imagesPanel.setCfg(cfg);
        descriptionPanel.setCfg(cfg);
        applyConfig();
    }

    @Override
    public void applyDesign() {
        headerPanel = designBuilder.buildHeaderPanelDesign();
        imagesPanel = designBuilder.buildLeftPanelDesign();
        descriptionPanel = designBuilder.buildRightPanelDesign();
        footerPanel = designBuilder.buildFooterPanelDesign();
    }

    @Override
    public void applyLogic() {
        headerPanel.setParent(this);
        imagesPanel.setParent(this);
        descriptionPanel.setParent(this);
        footerPanel.setParent(this);
        headerPanel.setRootWin(rootWin);
        imagesPanel.setRootWin(rootWin);
        descriptionPanel.setRootWin(rootWin);
        footerPanel.setRootWin(rootWin);
    }

    @Override
    public void applyConfig() {
        headerPanel.applyConfig();
        descriptionPanel.applyConfig();
        imagesPanel.applyConfig();
    }

    @Override
    public void runOnLeaveAction() {
        headerPanel.runOnLeaveAction();
        imagesPanel.runOnLeaveAction();
        descriptionPanel.runOnLeaveAction();
        footerPanel.runOnLeaveAction();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        designBuilder.paint(g);
    }
}
