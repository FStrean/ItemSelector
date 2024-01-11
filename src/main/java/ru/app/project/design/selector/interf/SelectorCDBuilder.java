package ru.app.project.design.selector.interf;

import ru.app.project.windows.BasicPanel;

import java.awt.*;

public interface SelectorCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildCenterPanelDesign();
    BasicPanel buildFooterPanelDesign();

    void paint(Graphics g);
}
