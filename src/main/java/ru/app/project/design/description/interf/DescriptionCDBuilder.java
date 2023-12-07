package ru.app.project.design.description.interf;

import ru.app.project.windows.BasicPanel;

public interface DescriptionCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildLeftPanelDesign();
    BasicPanel buildRightPanelDesign();
    BasicPanel buildFooterPanelDesign();
}
