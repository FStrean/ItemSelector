package ru.app.project.windows.cards.mainSelector.panels;

import ru.app.project.design.mainSelector.impl.panels.BasicHeaderPDBuilder;
import ru.app.project.design.mainSelector.interf.panels.HeaderPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;

import javax.swing.*;

public class HeaderP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private MutableComponent parent;

    private JLabel description;

    private final HeaderPDBuilder designBuilder;
    public HeaderP() {
        designBuilder = new BasicHeaderPDBuilder(this);

        this.rootWindow = null;

        this.applyDesign();
        this.applyLogic();
        this.loadConfig();
    }

    @Override
    public void applyDesign() {
        this.description = designBuilder.buildJLabelDesign();
    }

    @Override
    public void applyLogic() {

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
