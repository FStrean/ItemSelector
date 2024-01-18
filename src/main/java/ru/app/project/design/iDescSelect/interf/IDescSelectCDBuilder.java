package ru.app.project.design.iDescSelect.interf;

import ru.app.project.windows.BasicPanel;

import java.awt.*;

public interface IDescSelectCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildCenterPanelDesign();
    BasicPanel buildFooterPanelDesign();

    void paint(Graphics g);
}
