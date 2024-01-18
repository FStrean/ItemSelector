package ru.app.project.windows.cards.iDesc.panels;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.window.IDescCInfoCfg;
import ru.app.project.design.iDesc.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.iDesc.interf.panels.FooterPDBuilder;
import ru.app.project.utility.TextSizeCalculator;
import ru.app.project.utility.RelativeTextSizeRatioCalculator;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.iDescSelect.IDescSelectC;
import ru.app.project.windows.cards.mSelect.MSelectC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final FooterPDBuilder designBuilder;
    private IDescCInfoCfg config;
    private MutableComponent parent;

    private JButton button;
    private JLabel description;
    private JImageButton homeButton;


    private Double buttonRatio = null;
    private Double descriptionRatio = null;

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
            rootWindow.showCard(IDescSelectC.class);
        });
        homeButton.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWindow.showCard(MSelectC.class);
        });

        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descriptionRatio == null) {
                        buttonRatio = RelativeTextSizeRatioCalculator.getJButtonTextRatio(button);
                        descriptionRatio = RelativeTextSizeRatioCalculator.getJLabelTextRatio(description);
                    }
                    TextSizeCalculator.calculateJLabelTextSize(description, descriptionRatio);
                    TextSizeCalculator.calculateJButtonTextSize(button, buttonRatio);
                }
            });
        }
    }

    @Override
    public void applyConfig() {
        description.setText(config.getFHeader());
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
        this.config = (IDescCInfoCfg)config;
    }
}
