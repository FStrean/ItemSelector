package ru.app.project.design.select.interf;

import ru.app.project.windows.BasicPanel;

import java.awt.*;

public interface SelectCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildCenterPanelDesign();
    BasicPanel buildFooterPanelDesign();

    void paint(Graphics g);
}
