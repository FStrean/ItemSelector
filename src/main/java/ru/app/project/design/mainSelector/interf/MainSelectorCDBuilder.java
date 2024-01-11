package ru.app.project.design.mainSelector.interf;

import ru.app.project.windows.BasicPanel;

import java.awt.*;

public interface MainSelectorCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildCenterPanelDesign();
    BasicPanel buildFooterPanelDesign();
    void paint(Graphics g);
}
