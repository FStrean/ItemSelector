package ru.app.project.windows.cards.itemDescriptionSelector.panels;

import ru.app.project.config.window.ItemDescriptionSelectorCStateConfig;
import ru.app.project.design.itemDescriptionSelector.impl.panels.BasicHeaderPDBuilder;
import ru.app.project.design.itemDescriptionSelector.interf.panels.HeaderPDBuilder;
import ru.app.project.utility.TextSizeCalculator;
import ru.app.project.utility.RelativeTextSizeRatioCalculator;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.description.DescriptionC;
import ru.app.project.windows.cards.selector.SelectorC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HeaderP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final HeaderPDBuilder designBuilder;
    private ItemDescriptionSelectorCStateConfig config;
    private MutableComponent parent;

    private JButton button1;
    private JLabel description;
    private JButton button2;

    private Double descriptionRatio = null;
    private Double buttonRatio = null;

    public HeaderP() {
        this.designBuilder = new BasicHeaderPDBuilder(this);

        this.rootWindow = null;
        this.config = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        button1 = designBuilder.buildJButtonDesign();
        description = designBuilder.buildJLabelDesign();
        button2 = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic(){
        button1.addActionListener(event -> rootWindow.showCard(DescriptionC.class));
        button2.addActionListener(event -> rootWindow.showCard(SelectorC.class));
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if(descriptionRatio == null) {
                    descriptionRatio = RelativeTextSizeRatioCalculator.getJLabelTextRatio(description);
                    buttonRatio = RelativeTextSizeRatioCalculator.getJButtonTextRatio(button1);
                }
                TextSizeCalculator.calculateJLabelTextSize(description, description.getHeight(), descriptionRatio);
                TextSizeCalculator.calculateJButtonTextSize(button1, button1.getHeight(), buttonRatio);
                TextSizeCalculator.calculateJButtonTextSize(button2, button2.getHeight(), buttonRatio);
            }
        });
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
        button1.setText(config.getLeftButton());
        description.setText(config.getHDescription());
        button2.setText(config.getRightButton());
    }

    @Override
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {
        this.config = (ItemDescriptionSelectorCStateConfig)config;
    }
}
