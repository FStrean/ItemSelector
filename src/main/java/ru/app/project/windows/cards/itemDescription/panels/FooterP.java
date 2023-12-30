package ru.app.project.windows.cards.itemDescription.panels;

import ru.app.project.components.ImageButton;
import ru.app.project.config.window.ItemDescriptionCStateConfig;
import ru.app.project.design.itemDescription.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.itemDescription.interf.panels.FooterPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.itemDescriptionSelector.ItemDescriptionSelectorC;
import ru.app.project.windows.cards.mainSelector.MainSelectorC;

import javax.swing.*;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final FooterPDBuilder designBuilder;
    private ItemDescriptionCStateConfig config;
    private MutableComponent parent;

    private JButton button;
    private JLabel description;
    private ImageButton homeButton;

    public FooterP() {
        this.designBuilder = new BasicFooterPDBuilder(this);

        this.config = null;
        this.rootWindow = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        button = designBuilder.buildJButton1Design();
        description = designBuilder.buildJLabelDesign();
        homeButton = designBuilder.buildJButton2Design();
    }

    @Override
    public void applyLogic(){
        button.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWindow.showCard(ItemDescriptionSelectorC.class);
        });
        homeButton.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWindow.showCard(MainSelectorC.class);
        });
    }

    @Override
    public void applyConfig() {
        description.setText(config.getDescription());
        button.setText(config.getButton());
    }

    @Override
    public void runOnLeaveAction() {

    }

    @Override
    public void setParent(MutableComponent parent) {
        this.parent = parent;
    }

    @Override
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {
        this.config = (ItemDescriptionCStateConfig)config;
    }
}
