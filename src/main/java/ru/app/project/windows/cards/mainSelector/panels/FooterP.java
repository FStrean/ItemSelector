package ru.app.project.windows.cards.mainSelector.panels;

import ru.app.project.design.mainSelector.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.mainSelector.interf.panels.FooterPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;

import javax.swing.*;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private MutableComponent parent;

    private JLabel description;

    private final FooterPDBuilder designBuilder;
    public FooterP() {
        this.designBuilder = new BasicFooterPDBuilder(this);

        this.rootWindow = null;

        this.applyDesign();
        this.applyLogic();
        this.loadConfig();
    }
    @Override

    public void applyDesign() {
        description = designBuilder.buildJLabelDesign();
    }

    @Override
    public void applyLogic(){
    }

    @Override
    public void runOnLeaveAction() {

    }

    @Override
    public void setParent(MutableComponent parent) {
        this.parent = parent;
    }

    @Override
    public void loadConfig() {
        description.setText("dsflsadflsdflsadlfs");
    }

    @Override
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {

    }
}
