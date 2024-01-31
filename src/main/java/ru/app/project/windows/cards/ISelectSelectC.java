package ru.app.project.windows.cards;

import ru.app.project.config.cards.ISelectSelectCInfoCfg;
import ru.app.project.design.impl.BasicISelectSelectCDBuilder;
import ru.app.project.design.interf.ISelectSelectCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.template.StaticCard;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.root.RootWindow;

import java.awt.*;
import java.util.List;

public class ISelectSelectC extends StaticCard {
    private final ISelectSelectCDBuilder designBuilder;

    public ISelectSelectC(RootWindow rootWin) {
        super(rootWin);
        this.designBuilder = new BasicISelectSelectCDBuilder(this);
        ConfigLoader<ISelectSelectCInfoCfg> configLoader = new ConfigLoader<>(ISelectSelectCInfoCfg.class);
        this.cfg = configLoader.getCfg();

        this.applyDesign();
        this.applyLogic();
        this.applyConfig();
    }

    @Override
    public void applyDesign() {
        StaticPanel headerPanel = designBuilder.buildHeaderPanelDesign();
        StaticPanel imagesPanel = designBuilder.buildLeftPanelDesign();
        StaticPanel buttonsPanel = designBuilder.buildRightPanelDesign();
        StaticPanel footerPanel = designBuilder.buildFooterPanelDesign();

        panels = List.of(headerPanel, imagesPanel, buttonsPanel, footerPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        designBuilder.paint(g);
    }
}
