package ru.app.project.windows.cards.mainSelector;

import ru.app.project.design.mainSelector.impl.BasicMainSelectorCDBuilder;
import ru.app.project.design.mainSelector.interf.MainSelectorCDBuilder;
import ru.app.project.windows.BasicCard;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.mainSelector.panels.ButtonsP;
import ru.app.project.windows.cards.mainSelector.panels.FooterP;
import ru.app.project.windows.cards.mainSelector.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class MainSelectorC extends JPanel implements BasicCard {
    private final RootWindow rootWindow;

    private HeaderP headerPanel;
    private ButtonsP buttonsPanel;
    private FooterP footerPanel;

    private final MainSelectorCDBuilder designBuilder;

    public MainSelectorC(RootWindow rootWindow) throws HeadlessException {
        this.rootWindow = rootWindow;
        this.designBuilder = new BasicMainSelectorCDBuilder(this);

        this.applyDesign();
        this.applyLogic();
        this.loadConfig();
    }

    @Override
    public void applyDesign() {
        headerPanel = designBuilder.buildHeaderPanelDesign();
        buttonsPanel = designBuilder.buildButtonsPanelDesign();
        footerPanel = designBuilder.buildFooterPanelDesign();
    }

    @Override
    public void applyLogic() {
        headerPanel.setParent(this);
        buttonsPanel.setParent(this);
        footerPanel.setParent(this);
        headerPanel.setRootWindow(rootWindow);
        buttonsPanel.setRootWindow(rootWindow);
        footerPanel.setRootWindow(rootWindow);
    }

    @Override
    public void runOnLeaveAction() {

    }

    @Override
    public void loadConfig() {

    }
}
