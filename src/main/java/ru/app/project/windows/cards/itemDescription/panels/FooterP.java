package ru.app.project.windows.cards.itemDescription.panels;

import ru.app.project.config.window.ItemDescriptionWStateConfig;
import ru.app.project.design.itemDescription.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.itemDescription.interf.panels.FooterPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;

import javax.swing.*;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private ItemDescriptionWStateConfig.Item config;
    private MutableComponent parent;

    private JLabel description;
    private JButton button;

    private final FooterPDBuilder designBuilder;
    public FooterP() {
        this.designBuilder = new BasicFooterPDBuilder(this);

        this.config = null;
        this.rootWindow = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        description = designBuilder.buildJLabelDesign();
        button = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic(){
        button.addActionListener(event -> parent.runOnLeaveAction());
    }

    @Override
    public void loadConfig() {
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
        this.config = (ItemDescriptionWStateConfig.Item)config;
    }
}
