package ru.app.project.windows.cards.itemDescription.panels;

import ru.app.project.config.window.ItemDescriptionCStateConfig;
import ru.app.project.design.itemDescription.impl.panels.BasicDescriptionPDBuilder;
import ru.app.project.design.itemDescription.interf.panels.DescriptionPDBuilder;
import ru.app.project.utility.TextSizeCalculator;
import ru.app.project.utility.RelativeTextSizeRatioCalculator;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DescriptionP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final DescriptionPDBuilder designBuilder;
    private ItemDescriptionCStateConfig.Item config;
    private ItemDescriptionCStateConfig additionalConfig;
    private MutableComponent parent;
    private JLabel description;

    private Double descriptionRatio = null;

    public DescriptionP() {
        this.designBuilder = new BasicDescriptionPDBuilder(this);

        this.config = null;
        this.rootWindow = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        description = designBuilder.buildJLabelDesign();
    }

    @Override
    public void applyLogic() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if(descriptionRatio == null) {
                    descriptionRatio = RelativeTextSizeRatioCalculator.getTextRatio(additionalConfig.getItemMainDescriptionStyle(), description.getWidth());
                }
                TextSizeCalculator.calculateJLabelTextSize(description, description.getHeight(), descriptionRatio);
            }
        });
    }

    @Override
    public void applyConfig() {
        description.setText("<html>" + additionalConfig.getItemMainDescriptionStyle() + config.getMainDescription() + "</html>");
        if(descriptionRatio != null) {
            TextSizeCalculator.calculateJLabelTextSize(description, description.getHeight(), descriptionRatio);
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
        this.config = (ItemDescriptionCStateConfig.Item)config;
    }

    public void setAdditionalConfig(Object config) {
        this.additionalConfig = (ItemDescriptionCStateConfig)config;
    }
}
