package ru.app.project.windows;

import ru.app.project.windows.component.ChangeableLogicComponent;
import ru.app.project.windows.component.ConfigurableComponent;
import ru.app.project.windows.component.CustomizableDesignComponent;

import javax.swing.*;
import java.util.List;

public abstract class StaticCard extends JPanel implements ConfigurableComponent, CustomizableDesignComponent, ChangeableLogicComponent {
    private final RootWindow rootWin;
    protected Object cfg;
    protected List<StaticPanel> panels;

    public StaticCard(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void applyLogic() {
        for(StaticPanel panel : panels) {
            panel.setParent(this);
            panel.setRootWin(rootWin);
            panel.setCfg(cfg);
        }
    }

    @Override
    public void runOnLeaveAction() {
        for(StaticPanel panel : panels) {
            panel.runOnLeaveAction();
        }
    }

    @Override
    public void applyConfig() {
        for(StaticPanel panel : panels) {
            panel.applyConfig();
        }
    }
}
