package ru.app.project.windows.cards.itemDescriptionSelector;

import ru.app.project.design.itemDescriptionSelector.impl.BasicItemDescriptionSelectorCDBuilder;
import ru.app.project.windows.MainWindow;
import ru.app.project.windows.cards.itemDescriptionSelector.panels.ButtonsP;
import ru.app.project.windows.cards.itemDescriptionSelector.panels.FooterP;
import ru.app.project.windows.cards.itemDescriptionSelector.panels.HeaderP;

import javax.swing.*;

public class ItemDescriptionSelectorC extends JPanel {
    private final MainWindow mainWindow;
    private final BasicItemDescriptionSelectorCDBuilder designBuilder;

    private HeaderP headerPanel;
    private ButtonsP buttonsPanel;
    private FooterP footerPanel;

    public ItemDescriptionSelectorC(MainWindow mainWIndow) {
        this.mainWindow = mainWIndow;
        designBuilder = new BasicItemDescriptionSelectorCDBuilder(this.mainWindow, this);

        this.applyDesign();
        this.applyLogic();
    }

    public void applyDesign() {
        headerPanel = designBuilder.buildHeaderPanelDesign();
        buttonsPanel = designBuilder.buildButtonsPanelDesign();
        footerPanel = designBuilder.buildFooterPanelDesign();
    }

    public void applyLogic() {
        footerPanel.setDescriptionText("dflsadflsjalfjsadflsadf");
        headerPanel.setDescriptionText("dflalsdfsadflsafdsadsfsadf");
    }
}
