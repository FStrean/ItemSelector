package ru.app.project.windows.cards.selector.panels;

import ru.app.project.design.selector.impl.panels.BasicHeaderPDBuilder;
import ru.app.project.design.selector.interf.panels.HeaderPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;

import javax.swing.*;

public class HeaderP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final HeaderPDBuilder designBuilder;
    private MutableComponent parent;

    private JLabel description;

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
