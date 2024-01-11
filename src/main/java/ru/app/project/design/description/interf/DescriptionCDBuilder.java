package ru.app.project.design.description.interf;

import ru.app.project.windows.BasicPanel;

import java.awt.*;

public interface DescriptionCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildLeftPanelDesign();
    BasicPanel buildRightPanelDesign();
    BasicPanel buildFooterPanelDesign();

    void paint(Graphics g);
}
