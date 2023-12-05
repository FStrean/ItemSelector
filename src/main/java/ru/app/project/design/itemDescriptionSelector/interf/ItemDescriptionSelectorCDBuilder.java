package ru.app.project.design.itemDescriptionSelector.interf;

import ru.app.project.windows.cards.itemDescriptionSelector.panels.ButtonsP;
import ru.app.project.windows.cards.itemDescriptionSelector.panels.FooterP;
import ru.app.project.windows.cards.itemDescriptionSelector.panels.HeaderP;

import javax.swing.*;

public interface ItemDescriptionSelectorCDBuilder {
    HeaderP buildHeaderPanelDesign();
    ButtonsP buildButtonsPanelDesign();
    FooterP buildFooterPanelDesign();
}
