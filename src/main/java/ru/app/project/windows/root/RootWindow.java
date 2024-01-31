package ru.app.project.windows.root;

import ru.app.project.windows.component.ChangeableLogicComponent;
import ru.app.project.windows.component.CustomizableDesignComponent;
import ru.app.project.windows.template.DynamicCard;
import ru.app.project.windows.template.StaticCard;

public interface RootWindow extends CustomizableDesignComponent, ChangeableLogicComponent {
    void showCard(StaticCard previous, Class<? extends DynamicCard> cardClass, int i);
    void showCard(StaticCard previous, Class<? extends StaticCard> cardClass);
}
