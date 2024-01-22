package ru.app.project.design.descSelect.interf;

import ru.app.project.windows.BasicPanel;

import java.awt.*;

public interface DescSelectCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildLeftPanelDesign();
    BasicPanel buildRightPanelDesign();
    BasicPanel buildFooterPanelDesign();
    void paint(Graphics g);
}
