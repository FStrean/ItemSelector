package ru.app.project.design.interf;

import ru.app.project.windows.BasicPanel;

import java.awt.*;

public interface IDescCDBuilder {
    BasicPanel buildHeaderPanelDesign();

    BasicPanel buildLeftPanelDesign();
    BasicPanel buildRightPanelDesign();
    BasicPanel buildFooterPanelDesign();

    void paint(Graphics g);
}
