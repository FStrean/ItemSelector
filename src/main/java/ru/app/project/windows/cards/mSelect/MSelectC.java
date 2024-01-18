package ru.app.project.windows.cards.mSelect;

import ru.app.project.config.window.MSelectCInfoCfg;
import ru.app.project.design.mSelect.impl.BasicMSelectCDBuilder;
import ru.app.project.design.mSelect.interf.MSelectCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.RootWindow;

import javax.swing.*;
import java.awt.*;

public class MSelectC extends JPanel implements BasicCard {
    private final RootWindow rootWin;
    private final MSelectCDBuilder designBuilder;
    private final ConfigLoader<MSelectCInfoCfg> configLoader;

    private BasicPanel headerPanel;
    private BasicPanel buttonsPanel;
    private BasicPanel footerPanel;

    public MSelectC(RootWindow rootWin) throws HeadlessException {
        this.rootWin = rootWin;
        this.designBuilder = new BasicMSelectCDBuilder(this);
        this.configLoader = new ConfigLoader<>(MSelectCInfoCfg.class);

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
