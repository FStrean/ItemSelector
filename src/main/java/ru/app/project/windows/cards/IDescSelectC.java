package ru.app.project.windows.cards;

import ru.app.project.config.cards.IDescSelectCInfoCfg;
import ru.app.project.design.impl.BasicIDescSelectCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.template.StaticCard;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.root.RootWindow;

import java.awt.*;
import java.util.List;

public class IDescSelectC extends StaticCard {
    private final BasicIDescSelectCDBuilder designBuilder;

    public IDescSelectC(RootWindow rootWIndow) {
        super(rootWIndow);
        this.designBuilder = new BasicIDescSelectCDBuilder(this);
        ConfigLoader<IDescSelectCInfoCfg> configLoader = new ConfigLoader<>(IDescSelectCInfoCfg.class);
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
