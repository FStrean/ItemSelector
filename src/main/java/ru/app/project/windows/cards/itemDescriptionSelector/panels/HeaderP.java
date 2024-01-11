package ru.app.project.windows.cards.itemDescriptionSelector.panels;

import ru.app.project.config.window.ItemDescriptionCStateConfig;
import ru.app.project.config.window.ItemDescriptionSelectorCStateConfig;
import ru.app.project.design.itemDescriptionSelector.impl.panels.BasicHeaderPDBuilder;
import ru.app.project.design.itemDescriptionSelector.interf.panels.HeaderPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.description.DescriptionC;
import ru.app.project.windows.cards.selector.SelectorC;

import javax.swing.*;

public class HeaderP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final HeaderPDBuilder designBuilder;
    private ItemDescriptionSelectorCStateConfig config;
    private MutableComponent parent;

    private JButton buttonLeft;
    private JLabel description;
    private JButton buttonRight;

    public HeaderP() {
        this.designBuilder = new BasicHeaderPDBuilder(this);

        this.rootWindow = null;
        this.config = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        buttonLeft = designBuilder.buildJButtonDesign();
        description = designBuilder.buildJLabelDesign();
        buttonRight = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic(){
        buttonLeft.addActionListener(event -> rootWindow.showCard(DescriptionC.class));
        buttonRight.addActionListener(event -> rootWindow.showCard(SelectorC.class));
    }

    @Override
    public void runOnLeaveAction() {

    }

    @Override
    public void setParent(MutableComponent parent) {
        this.parent = parent;
    }

    @Override
    public void applyConfig() {
        buttonLeft.setText(config.getLeftButton());
        description.setText(config.getHDescription());
        buttonRight.setText(config.getRightButton());
    }

    @Override
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {
        this.config = (ItemDescriptionSelectorCStateConfig)config;
    }
}
