package ru.app.project.windows.cards.selector.panels;

import ru.app.project.config.window.SelectorCStateConfig;
import ru.app.project.design.selector.impl.panels.BasicButtonsPDBuilder;
import ru.app.project.design.selector.interf.panels.ButtonsPDBuilder;
import ru.app.project.utility.TextSizeCalculator;
import ru.app.project.utility.RelativeTextSizeRatioCalculator;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.itemDescription.ItemDescriptionC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ButtonsP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final ButtonsPDBuilder designBuilder;
    private SelectorCStateConfig config;
    private MutableComponent parent;

    private JLabel description;
    private JButton button1;
    private JButton button2;

    private Double descriptionRatio = null;
    private Double buttonRatio = null;

    public ButtonsP() {
        this.designBuilder = new BasicButtonsPDBuilder(this);

        this.rootWindow = null;
        this.config = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        description = designBuilder.buildDescription();
        button1 = designBuilder.buildJButtonDesign();
        button2 = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic() {
        button1.addActionListener(event -> rootWindow.showCard(ItemDescriptionC.class, 1));
        button2.addActionListener(event -> rootWindow.showCard(ItemDescriptionC.class, 1));

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if(descriptionRatio == null) {
                    descriptionRatio = RelativeTextSizeRatioCalculator.getJLabelTextRatio(description);
                    buttonRatio = RelativeTextSizeRatioCalculator.getJButtonTextRatio(button1);
                }
                TextSizeCalculator.calculateJLabelTextSize(description, descriptionRatio);
                TextSizeCalculator.calculateJButtonTextSize(button1, buttonRatio);
                TextSizeCalculator.calculateJButtonTextSize(button2, buttonRatio);
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
        button1.setText(config.getButton1());
        button2.setText(config.getButton2());
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
