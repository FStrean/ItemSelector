package ru.app.project.design.interf;

import ru.app.project.windows.BasicPanel;

import java.awt.*;

public interface VideoCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildCenterPanelDesign();
    BasicPanel buildFooterPanelDesign();

    void paint(Graphics g);
}
