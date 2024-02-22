package ru.app.project.design.interf;

import ru.app.project.windows.template.StaticPanel;

import java.awt.*;

public interface IDescCDBuilder {
    StaticPanel buildHeaderPanelDesign();

    StaticPanel buildLeftPanelDesign();
    void updateLeftPanelDesign(float ratio);
    StaticPanel buildRightPanelDesign();
    void updateRightPanelDesign(float ratio);
    StaticPanel buildFooterPanelDesign();

    void paint(Graphics g);
}
