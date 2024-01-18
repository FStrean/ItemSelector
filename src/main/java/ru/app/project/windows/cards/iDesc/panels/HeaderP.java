package ru.app.project.windows.cards.iDesc.panels;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.window.IDescCInfoCfg;
import ru.app.project.design.iDesc.impl.panels.BasicHeaderPDBuilder;
import ru.app.project.design.iDesc.interf.panels.HeaderPDBuilder;
import ru.app.project.utility.TextSizeCalculator;
import ru.app.project.utility.RelativeTextSizeRatioCalculator;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.iDesc.IDescC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HeaderP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final HeaderPDBuilder designBuilder;
    private IDescCInfoCfg.Item config;
    private IDescCInfoCfg additionalConfig;
    private MutableComponent parent;

    private JImageButton buttonLeft;
    private JImageButton buttonRight;
    private JLabel description;

    private Double descriptionRatio = null;

    private int id;

    public HeaderP() {
        this.designBuilder = new BasicHeaderPDBuilder(this);

        this.config = null;
        this.rootWindow = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        buttonLeft = designBuilder.buildJButton1Design();
        buttonRight = designBuilder.buildJButton2Design();
        description = designBuilder.buildJLabelDesign();
    }

    @Override
    public void applyLogic(){
        int maxId = AppProperties.getNumOfItemsInIDesc();
        buttonLeft.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWindow.showCard(IDescC.class, (id - 1) < 1 ? maxId : (id - 1));
        });
        buttonRight.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWindow.showCard(IDescC.class, (id + 1) > maxId ? 1 : (id + 1));
        });

        if(AppProperties.isDynamicTextSizeOn()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descriptionRatio == null) {
                        descriptionRatio = RelativeTextSizeRatioCalculator.getTextRatio(additionalConfig.getHHeaderStyle(), description.getWidth());
                    }
                    TextSizeCalculator.calculateJLabelTextSize(description, descriptionRatio);
                }
            });
        }
    }

    @Override
    public void applyConfig() {
        id = config.getId();

        description.setText("<html>" + additionalConfig.getHHeaderStyle() + config.getHHeader() + "</html>");
        if(descriptionRatio != null) {
            TextSizeCalculator.calculateJLabelTextSize(description, descriptionRatio);
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
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {
        this.config = (IDescCInfoCfg.Item)config;
    }

    public void setAdditionalConfig(Object config) {
        this.additionalConfig = (IDescCInfoCfg)config;
    }
}
