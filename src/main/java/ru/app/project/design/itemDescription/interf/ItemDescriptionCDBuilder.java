package ru.app.project.design.itemDescription.interf;

import ru.app.project.windows.BasicPanel;

public interface ItemDescriptionCDBuilder {
    BasicPanel buildHeaderPanelDesign();

    BasicPanel buildLeftPanelDesign();
    BasicPanel buildRightPanelDesign();
    BasicPanel buildFooterPanelDesign();
}
