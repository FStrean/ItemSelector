package ru.app.project.design.iSelectSelect.interf;

import ru.app.project.windows.BasicPanel;

import java.awt.*;

public interface ISelectSelectCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildLeftPanelDesign();
    BasicPanel buildRightPanelDesign();
    BasicPanel buildFooterPanelDesign();
    void paint(Graphics g);
}
