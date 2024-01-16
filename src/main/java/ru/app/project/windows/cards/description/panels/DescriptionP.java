package ru.app.project.windows.cards.description.panels;

import ru.app.project.config.window.DescriptionCStateConfig;
import ru.app.project.design.description.impl.panels.BasicDescriptionPDBuilder;
import ru.app.project.design.description.interf.panels.DescriptionPDBuilder;
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
    private DescriptionCStateConfig config;
    private MutableComponent parent;

    private JLabel description;

    private Double descriptionRatio = null;

    public DescriptionP() {
        designBuilder = new BasicDescriptionPDBuilder(this);

        this.rootWindow = null;
        this.config = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        this.description = designBuilder.buildJLabelDesign();
    }

    @Override
    public void applyLogic() {
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
        description.setText(config.getDescription());
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
