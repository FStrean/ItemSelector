package ru.app.project.windows.cards.selector.panels;

import ru.app.project.design.selector.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.selector.interf.panels.FooterPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.mainSelector.MainSelectorC;

import javax.swing.*;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final FooterPDBuilder designBuilder;
    private MutableComponent parent;

    private JLabel description;
    private JButton button;

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
        button = designBuilder.buildHomeJButtonDesign();
    }

    @Override
    public void applyLogic(){
        button.addActionListener(event -> rootWindow.showCard(MainSelectorC.class));
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
