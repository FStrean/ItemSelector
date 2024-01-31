package ru.app.project.windows.cards;

import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.VideoCInfoCfg;
import ru.app.project.design.impl.BasicVideoCDBuilder;
import ru.app.project.design.interf.VideoCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.template.DynamicPanel;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.template.DynamicCard;
import ru.app.project.windows.root.RootWindow;

import java.awt.*;
import java.util.List;

public class VideoC extends DynamicCard {
    private final VideoCDBuilder designBuilder;

    public VideoC(RootWindow rootWin)  {
        super(rootWin);
        this.designBuilder = new BasicVideoCDBuilder(this);
        ConfigLoader<VideoCInfoCfg> configLoader = new ConfigLoader<>(VideoCInfoCfg.class);
        this.cfg = configLoader.getCfg();
        this.addCfg = configLoader.getCfg();

        this.applyDesign();
        this.applyLogic();
        this.applyDynamicLogic();
        this.applyConfig();
    }

    @Override
    public void applyDesign() {
        StaticPanel headerPanel = designBuilder.buildHeaderPanelDesign();
        StaticPanel videosPanel = designBuilder.buildCenterPanelDesign();
        StaticPanel footerPanel = designBuilder.buildFooterPanelDesign();

        panels = List.of(headerPanel, footerPanel);
        dynamicPanels = List.of((DynamicPanel) videosPanel);
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
            if(this.id > AppProperties.getNumOfVidInVideo() / AppProperties.getMaxNumOfVidInScreen() + 1) {
                this.id = 1;
            }
            if(this.id < 1) {
                this.id = AppProperties.getNumOfVidInVideo() / AppProperties.getMaxNumOfVidInScreen() + 1;
            }
        }
        applyDynamicConfig();
    }
}