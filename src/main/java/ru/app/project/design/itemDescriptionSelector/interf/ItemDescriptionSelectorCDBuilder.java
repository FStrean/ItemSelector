package ru.app.project.design.itemDescriptionSelector.interf;

import ru.app.project.windows.BasicPanel;

import java.awt.*;

public interface ItemDescriptionSelectorCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildCenterPanelDesign();
    BasicPanel buildFooterPanelDesign();

    void paint(Graphics g);
}
