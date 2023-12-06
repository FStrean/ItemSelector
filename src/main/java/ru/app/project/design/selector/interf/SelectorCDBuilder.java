package ru.app.project.design.selector.interf;

import ru.app.project.windows.cards.selector.panels.ButtonsP;
import ru.app.project.windows.cards.selector.panels.FooterP;
import ru.app.project.windows.cards.selector.panels.HeaderP;

public interface SelectorCDBuilder {
    HeaderP buildHeaderPanelDesign();
    ButtonsP buildButtonsPanelDesign();
    FooterP buildFooterPanelDesign();
}
