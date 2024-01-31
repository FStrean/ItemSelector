package ru.app.project.windows;

import ru.app.project.windows.component.ChangeableLogicComponent;
import ru.app.project.windows.component.ConfigurableComponent;
import ru.app.project.windows.component.CustomizableDesignComponent;

public interface StaticPanel extends ConfigurableComponent, CustomizableDesignComponent, ChangeableLogicComponent {
    void setParent(StaticCard parent);
    void setRootWin(RootWindow rootWin);
    void setCfg(Object cfg);
}
