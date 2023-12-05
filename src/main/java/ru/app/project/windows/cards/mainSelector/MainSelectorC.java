package ru.app.project.windows.cards.mainSelector;

import ru.app.project.design.mainSelector.impl.BasicMainSelectorCDBuilder;
import ru.app.project.design.mainSelector.interf.MainSelectorCDBuilder;
import ru.app.project.windows.MainWindow;
import ru.app.project.windows.cards.mainSelector.panels.ButtonsP;
import ru.app.project.windows.cards.mainSelector.panels.FooterP;
import ru.app.project.windows.cards.mainSelector.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class MainSelectorC extends JPanel {
    private final MainWindow mainWindow;

    private HeaderP headerPanel;
    private ButtonsP buttonsPanel;
    private FooterP footerPanel;

    private final MainSelectorCDBuilder designBuilder;

    public MainSelectorC(MainWindow mainWindow) throws HeadlessException {
        this.mainWindow = mainWindow;
        this.designBuilder = new BasicMainSelectorCDBuilder(this.mainWindow, this);

        applyDesign();
        applyLogic();
    }

    public void applyDesign() {
        headerPanel = designBuilder.buildHeaderPanelDesign();
        buttonsPanel = designBuilder.buildButtonsPanelDesign();
        footerPanel = designBuilder.buildFooterPanelDesign();
    }

    public void applyLogic() {
        headerPanel.setDescriptionText("dsflsadflsdflsadlfs");
        footerPanel.setDescriptionText("dfsfasdfsadfsadfsdf");
    }
}
