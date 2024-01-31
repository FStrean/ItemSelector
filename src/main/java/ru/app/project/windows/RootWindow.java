package ru.app.project.windows;

import ru.app.project.windows.component.ChangeableLogicComponent;
import ru.app.project.windows.component.CustomizableDesignComponent;

public interface RootWindow extends CustomizableDesignComponent, ChangeableLogicComponent {
    void showCard(Class<? extends DynamicCard> cardClass, int i);
    void showCard(Class<? extends StaticCard> cardClass);
}
