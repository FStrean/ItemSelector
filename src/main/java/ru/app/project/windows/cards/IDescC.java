package ru.app.project.windows.cards;

import ru.app.project.config.cards.IDescCInfoCfg;
import ru.app.project.design.interf.IDescCDBuilder;
import ru.app.project.design.impl.BasicIDescCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MultipleStateCard;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.panels.iDesc.DescriptionP;
import ru.app.project.windows.cards.panels.iDesc.HeaderP;

import javax.swing.*;
import java.awt.*;

public class IDescC extends JPanel implements BasicCard, MultipleStateCard {
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

    @Override
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
