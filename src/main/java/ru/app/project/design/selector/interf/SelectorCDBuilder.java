package ru.app.project.design.selector.interf;

import ru.app.project.windows.BasicPanel;

public interface SelectorCDBuilder {
    BasicPanel buildHeaderPanelDesign();
    BasicPanel buildCenterPanelDesign();
    BasicPanel buildFooterPanelDesign();
}
