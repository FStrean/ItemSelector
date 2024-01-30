package ru.app.project.windows.cards;

import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.VideoCInfoCfg;
import ru.app.project.design.impl.BasicVideoCDBuilder;
import ru.app.project.design.interf.VideoCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MultipleStateCard;
import ru.app.project.windows.RootWindow;

import javax.swing.*;
import java.awt.*;

public class VideoC extends JPanel implements BasicCard, MultipleStateCard {
    private final RootWindow rootWin;
    private final VideoCDBuilder designBuilder;
    private final ConfigLoader<VideoCInfoCfg> configLoader;

    private BasicPanel headerPanel;
    private BasicPanel videosPanel;
    private BasicPanel footerPanel;

    private int id;

    public VideoC(RootWindow rootWin) throws HeadlessException {
        this.rootWin = rootWin;
        this.designBuilder = new BasicVideoCDBuilder(this);
        this.configLoader = new ConfigLoader<>(VideoCInfoCfg.class);

        this.applyDesign();
        this.applyLogic();
        this.applyConfig();
    }

    @Override
    public void applyDesign() {
        headerPanel = designBuilder.buildHeaderPanelDesign();
        videosPanel = designBuilder.buildCenterPanelDesign();
        footerPanel = designBuilder.buildFooterPanelDesign();
    }

    @Override
    public void applyLogic() {
        headerPanel.setParent(this);
        videosPanel.setParent(this);
        footerPanel.setParent(this);
        headerPanel.setRootWin(rootWin);
        videosPanel.setRootWin(rootWin);
        footerPanel.setRootWin(rootWin);
        headerPanel.setCfg(configLoader.getCfg());
        videosPanel.setCfg(configLoader.getCfg());
        footerPanel.setCfg(configLoader.getCfg());
    }

    @Override
    public void runOnLeaveAction() {
        headerPanel.runOnLeaveAction();
        videosPanel.runOnLeaveAction();
        footerPanel.runOnLeaveAction();
    }

    @Override
    public void applyConfig() {
        headerPanel.applyConfig();
        footerPanel.applyConfig();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        designBuilder.paint(g);
    }

    @Override
    public void showState(int id) {
        if (id == 0) {
            this.id = 1;
        } else {
            this.id += id;
            if(this.id > AppProperties.getNumOfVidInVideo() / AppProperties.getMaxNumOfVideosInScreen() + 1) {
                this.id = 1;
            }
            if(this.id < 1) {
                this.id = AppProperties.getNumOfVidInVideo() / AppProperties.getMaxNumOfVideosInScreen() + 1;
            }
        }
        videosPanel.applyConfig();
    }

    public int getId() {
        return id;
    }
}