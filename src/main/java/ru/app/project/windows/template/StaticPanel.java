package ru.app.project.windows.template;

import ru.app.project.windows.component.ChangeableLogicComponent;
import ru.app.project.windows.component.ConfigurableComponent;
import ru.app.project.windows.component.CustomizableDesignComponent;
import ru.app.project.windows.root.RootWindow;
import ru.app.project.windows.template.StaticCard;

public interface StaticPanel extends ConfigurableComponent, CustomizableDesignComponent, ChangeableLogicComponent {
    void setParent(StaticCard parent);
    void setRootWin(RootWindow rootWin);
    void setCfg(Object cfg);
}
