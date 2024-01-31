package ru.app.project.design.interf;

import ru.app.project.windows.StaticPanel;

import java.awt.*;

public interface ISelectSelectCDBuilder {
    StaticPanel buildHeaderPanelDesign();
    StaticPanel buildLeftPanelDesign();
    StaticPanel buildRightPanelDesign();
    StaticPanel buildFooterPanelDesign();
    void paint(Graphics g);
}
