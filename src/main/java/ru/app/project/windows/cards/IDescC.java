package ru.app.project.windows.cards;

import ru.app.project.config.cards.IDescCInfoCfg;
import ru.app.project.design.interf.IDescCDBuilder;
import ru.app.project.design.impl.BasicIDescCDBuilder;
import ru.app.project.utility.ConfigLoader;
import ru.app.project.windows.template.DynamicPanel;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.template.DynamicCard;
import ru.app.project.windows.root.RootWindow;

import java.awt.*;
import java.util.List;

public class IDescC extends DynamicCard {
    private final IDescCDBuilder designBuilder;

    public IDescC(RootWindow rootWin) {
        super(rootWin);
        this.designBuilder = new BasicIDescCDBuilder(this);
        ConfigLoader<IDescCInfoCfg> configLoader = new ConfigLoader<>(IDescCInfoCfg.class);
        this.cfg = null;
        this.addCfg = configLoader.getCfg();

        this.applyDesign();
        this.applyLogic();
        this.applyDynamicLogic();
        this.applyConfig();
    }

    @Override
    public void applyDesign() {
        StaticPanel headerPanel = designBuilder.buildHeaderPanelDesign();
        StaticPanel imagesPanel = designBuilder.buildLeftPanelDesign();
        StaticPanel descriptionPanel = designBuilder.buildRightPanelDesign();
        StaticPanel footerPanel = designBuilder.buildFooterPanelDesign();

        this.panels = List.of(footerPanel);
        this.dynamicPanels = List.of((DynamicPanel) headerPanel, (DynamicPanel) imagesPanel, (DynamicPanel) descriptionPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        designBuilder.paint(g);
    }

    @Override
    public void showState(int id) {
        this.id = id;
        cfg = ((IDescCInfoCfg)addCfg).getItems().stream()
                .filter(listItem -> listItem.getId() == id).findFirst()
                .orElse(new IDescCInfoCfg.Item());

        applyDynamicConfig();
    }
}
