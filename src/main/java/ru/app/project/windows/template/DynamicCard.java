package ru.app.project.windows.template;

import ru.app.project.windows.root.RootWindow;

import java.util.List;

public abstract class DynamicCard extends StaticCard {
    private final RootWindow rootWin;
    protected Object addCfg;
    protected int id;

    protected List<DynamicPanel> dynamicPanels;
    public DynamicCard(RootWindow rootWin) {
        super(rootWin);
        this.rootWin = rootWin;
    }

    @Override
    public void applyLogic() {
        for(StaticPanel panel : panels) {
            panel.setParent(this);
            panel.setRootWin(rootWin);
            panel.setCfg(addCfg);
        }
    }

    @Override
    public void runOnLeaveAction() {
        super.runOnLeaveAction();
        for(DynamicPanel panel : dynamicPanels) {
            panel.runOnLeaveAction();
        }
    }

    public void applyDynamicLogic() {
        for (DynamicPanel panel : dynamicPanels) {
            panel.setParent(this);
            panel.setRootWin(rootWin);
            panel.setAddCfg(addCfg);
        }
    }

    public int getId() {
        return id;
    }

    public void applyDynamicConfig() {
        for(DynamicPanel panel : dynamicPanels) {
            panel.setCfg(cfg);
            panel.applyConfig();
        }
    }

    abstract public void showState(int id);
}
