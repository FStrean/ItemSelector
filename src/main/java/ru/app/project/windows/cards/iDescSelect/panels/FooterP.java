package ru.app.project.windows.cards.iDescSelect.panels;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.window.IDescSelectCInfoCfg;
import ru.app.project.design.iDescSelect.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.iDescSelect.interf.panels.FooterPDBuilder;
import ru.app.project.utility.TextSizeCalculator;
import ru.app.project.utility.RelativeTextSizeRatioCalculator;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.mSelect.MSelectC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final FooterPDBuilder designBuilder;
    private IDescSelectCInfoCfg config;
    private MutableComponent parent;

    private JLabel description;
    private JImageButton button;

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
    public void applyLogic() {
        button.addActionListener(event -> rootWindow.showCard(MSelectC.class));
        if(AppProperties.isDynamicTextSizeOn()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descriptionRatio == null) {
                        descriptionRatio = RelativeTextSizeRatioCalculator.getJLabelTextRatio(description);
                    }
                    TextSizeCalculator.calculateJLabelTextSize(description, descriptionRatio);
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
        description.setText(config.getFHeader());
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
