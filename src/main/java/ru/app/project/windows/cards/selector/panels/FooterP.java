package ru.app.project.windows.cards.selector.panels;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.window.SelectCInfoCfg;
import ru.app.project.design.select.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.select.interf.panels.FooterPDBuilder;
import ru.app.project.utility.TextSizeCalculator;
import ru.app.project.utility.RelativeTextSizeRatioCalculator;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.desc.DescC;
import ru.app.project.windows.cards.iDescSelect.IDescSelectC;
import ru.app.project.windows.cards.mSelect.MSelectC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final FooterPDBuilder designBuilder;
    private SelectCInfoCfg config;
    private MutableComponent parent;


    private JButton leftButton1;
    private JButton leftButton2;
    private JLabel description;
    private JImageButton button;

    private Double leftButtonRatio = null;
    private Double descriptionRatio = null;

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
        leftButton1.addActionListener(event -> rootWindow.showCard(IDescSelectC.class));
        leftButton2.addActionListener(event -> rootWindow.showCard(DescC.class));
        button.addActionListener(event -> rootWindow.showCard(MSelectC.class));

        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descriptionRatio == null) {
                        descriptionRatio = RelativeTextSizeRatioCalculator.getJLabelTextRatio(description);
                        leftButtonRatio = RelativeTextSizeRatioCalculator.getJButtonTextRatio(leftButton1);
                    }
                    TextSizeCalculator.calculateJLabelTextSize(description, descriptionRatio);
                    TextSizeCalculator.calculateJButtonTextSize(leftButton1, leftButtonRatio);
                    TextSizeCalculator.calculateJButtonTextSize(leftButton2, leftButtonRatio);
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
        leftButton1.setText(config.getLButton1());
        leftButton2.setText(config.getLButton2());
        description.setText(config.getFHeader());
    }

    @Override
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {
        this.config = (SelectCInfoCfg)config;
    }
}
