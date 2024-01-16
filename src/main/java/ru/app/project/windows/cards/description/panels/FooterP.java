package ru.app.project.windows.cards.description.panels;

import ru.app.project.components.ImageButton;
import ru.app.project.config.window.DescriptionCStateConfig;
import ru.app.project.design.description.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.description.interf.panels.FooterPDBuilder;
import ru.app.project.utility.TextSizeCalculator;
import ru.app.project.utility.RelativeTextSizeRatioCalculator;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.mainSelector.MainSelectorC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final FooterPDBuilder designBuilder;
    private DescriptionCStateConfig config;
    private MutableComponent parent;

    private JLabel description;
    private ImageButton button;

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
        description = designBuilder.buildJLabelDesign();
        button = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic(){
        button.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWindow.showCard(MainSelectorC.class);
        });

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if(descriptionRatio == null) {
                    descriptionRatio = RelativeTextSizeRatioCalculator.getJLabelTextRatio(description);
                }
                TextSizeCalculator.calculateJLabelTextSize(description, description.getHeight(), descriptionRatio);
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
        description.setText(config.getFDescription());
    }

    @Override
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {
        this.config = (DescriptionCStateConfig)config;
    }
}
