package ru.app.project.windows.cards.iDescSelect.panels;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.IDescSelectCInfoCfg;
import ru.app.project.design.iDescSelect.impl.panels.BasicHeaderPDBuilder;
import ru.app.project.design.iDescSelect.interf.panels.HeaderPDBuilder;
import ru.app.project.utility.TextSizeCalculator;
import ru.app.project.utility.RelativeTextSizeRatioCalculator;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.desc.DescC;
import ru.app.project.windows.cards.selector.SelectC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HeaderP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final HeaderPDBuilder designBuilder;
    private IDescSelectCInfoCfg config;
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
        button1.addActionListener(event -> rootWindow.showCard(DescC.class));
        button2.addActionListener(event -> rootWindow.showCard(SelectC.class));

        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descriptionRatio == null) {
                        descriptionRatio = RelativeTextSizeRatioCalculator.getJLabelTextRatio(description);
                        buttonRatio = RelativeTextSizeRatioCalculator.getJButtonTextRatio(button1);
                    }
                    TextSizeCalculator.calculateJLabelTextSize(description, descriptionRatio);
                    TextSizeCalculator.calculateJButtonTextSize(button1, buttonRatio);
                    TextSizeCalculator.calculateJButtonTextSize(button2, buttonRatio);
                }
            });
        }
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
        button1.setText(config.getLButton());
        description.setText(config.getHHeader());
        button2.setText(config.getRButton());
    }

    @Override
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {
        this.config = (IDescSelectCInfoCfg)config;
    }
}
