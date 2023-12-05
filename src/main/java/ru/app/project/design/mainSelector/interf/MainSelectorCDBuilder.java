package ru.app.project.design.mainSelector.interf;

import ru.app.project.windows.cards.mainSelector.panels.ButtonsP;
import ru.app.project.windows.cards.mainSelector.panels.FooterP;
import ru.app.project.windows.cards.mainSelector.panels.HeaderP;

public interface MainSelectorCDBuilder {
    HeaderP buildHeaderPanelDesign();
    ButtonsP buildButtonsPanelDesign();
    FooterP buildFooterPanelDesign();
}
