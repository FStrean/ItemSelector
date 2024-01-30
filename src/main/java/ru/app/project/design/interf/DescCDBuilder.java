package ru.app.project.design.interf;

import ru.app.project.windows.BasicPanel;

import java.awt.*;

public interface DescCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildLeftPanelDesign();
    BasicPanel buildRightPanelDesign();
    BasicPanel buildFooterPanelDesign();

    void paint(Graphics g);
}
