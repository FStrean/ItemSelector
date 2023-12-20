package ru.app.project.windows.cards.itemDescription.panels;

import ru.app.project.config.window.ItemDescriptionCStateConfig;
import ru.app.project.design.itemDescription.impl.panels.BasicHeader2PDBuilder;
import ru.app.project.design.itemDescription.interf.panels.Header2PDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;

import javax.swing.*;

public class Header2P extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final Header2PDBuilder designBuilder;
    private ItemDescriptionCStateConfig.Item config;
    private MutableComponent parent;
    private JLabel description;

    public Header2P() {
        this.designBuilder = new BasicHeader2PDBuilder(this);

        this.config = null;
        this.rootWindow = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        description = designBuilder.buildJLabelDesign();
    }

    @Override
    public void applyLogic(){
    }

    @Override
    public void applyConfig() {
        description.setText(config.getDescription());
    }

    @Override
    public void runOnLeaveAction() {

    }

    @Override
    public void setParent(MutableComponent parent) {
        this.parent = parent;
    }

    @Override
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {
        this.config = (ItemDescriptionCStateConfig.Item)config;
    }
}