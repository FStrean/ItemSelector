package ru.app.project.windows.cards.itemDescriptionSelector.panels;

import ru.app.project.design.itemDescriptionSelector.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.itemDescriptionSelector.interf.panels.FooterPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.mainSelector.MainSelectorC;

import javax.swing.*;
import java.awt.*;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private MutableComponent parent;

    private JLabel description;
    private JButton button;

    private final FooterPDBuilder designBuilder;
    public FooterP() {
        this.designBuilder = new BasicFooterPDBuilder(this);

        this.rootWindow = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        description = designBuilder.buildJLabelDesign();
        button = designBuilder.buildJButtonDesign();
        button.setMaximumSize(new Dimension(20, 20));

    }

    @Override
    public void applyLogic() {
        button.addActionListener(event -> rootWindow.showCard(MainSelectorC.class));
    }

    @Override
    public void runOnLeaveAction() {

    }

    @Override
    public void setParent(MutableComponent parent) {
        this.parent = parent;
    }

    @Override
    public void loadConfig() {
        description.setText("dflsadflsjalfjsadflsadf");
    }

    @Override
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {

    }
}
