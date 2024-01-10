package ru.app.project.windows.cards.selector.panels;

import ru.app.project.components.ImageButton;
import ru.app.project.config.window.SelectorCStateConfig;
import ru.app.project.design.selector.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.selector.interf.panels.FooterPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.description.DescriptionC;
import ru.app.project.windows.cards.itemDescriptionSelector.ItemDescriptionSelectorC;
import ru.app.project.windows.cards.mainSelector.MainSelectorC;

import javax.swing.*;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final FooterPDBuilder designBuilder;
    private SelectorCStateConfig config;
    private MutableComponent parent;


    private JButton leftButton1;
    private JButton leftButton2;
    private JLabel description;
    private ImageButton button;

    public FooterP() {
        this.designBuilder = new BasicFooterPDBuilder(this);

        this.rootWindow = null;
        this.config = null;

        this.applyDesign();
        this.applyLogic();
    }
    @Override

    public void applyDesign() {
        leftButton1 = designBuilder.buildLeftButtonDesign();
        leftButton2 = designBuilder.buildLeftButtonDesign();
        description = designBuilder.buildJLabelDesign();
        button = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic(){
        leftButton1.addActionListener(event -> rootWindow.showCard(ItemDescriptionSelectorC.class));
        leftButton2.addActionListener(event -> rootWindow.showCard(DescriptionC.class));
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
    public void applyConfig() {
        leftButton1.setText(config.getLeftButton1());
        leftButton2.setText(config.getLeftButton2());
        description.setText(config.getFDescription());
    }

    @Override
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {
        this.config = (SelectorCStateConfig)config;
    }
}
