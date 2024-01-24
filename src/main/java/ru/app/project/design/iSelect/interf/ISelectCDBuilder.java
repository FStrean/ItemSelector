package ru.app.project.design.iSelect.interf;

import ru.app.project.windows.BasicPanel;

import java.awt.*;

public interface ISelectCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildUnderHeaderPanelDesign();
    BasicPanel buildLeftPanelDesign();
    BasicPanel buildRightPanelDesign();
    BasicPanel buildFooterPanelDesign();

    void paint(Graphics g);
}
