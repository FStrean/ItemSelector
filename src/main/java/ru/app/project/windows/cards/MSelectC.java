package ru.app.project.windows.cards;

import ru.app.project.config.cards.MSelectCInfoCfg;
import ru.app.project.design.impl.BasicMSelectCDBuilder;
import ru.app.project.design.interf.MSelectCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.StaticCard;
import ru.app.project.windows.StaticPanel;
import ru.app.project.windows.RootWindow;

import java.awt.*;
import java.util.List;

public class MSelectC extends StaticCard {
    private final MSelectCDBuilder designBuilder;

    public MSelectC(RootWindow rootWin) {
        super(rootWin);
        this.designBuilder = new BasicMSelectCDBuilder(this);
        ConfigLoader<MSelectCInfoCfg> configLoader = new ConfigLoader<>(MSelectCInfoCfg.class);
        this.cfg = configLoader.getCfg();

        this.applyDesign();
        this.applyLogic();
        this.applyConfig();
    }

    @Override
    public void applyDesign() {
        StaticPanel headerPanel = designBuilder.buildHeaderPanelDesign();
        StaticPanel buttonsPanel = designBuilder.buildCenterPanelDesign();
        StaticPanel footerPanel = designBuilder.buildFooterPanelDesign();

        panels = List.of(headerPanel, buttonsPanel, footerPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        designBuilder.paint(g);
    }
}
