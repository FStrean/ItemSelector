package ru.app.project.windows.cards.description.panels;

import ru.app.project.config.window.DescriptionCStateConfig;
import ru.app.project.design.description.interf.panels.ButtonsPDBuilder;
import ru.app.project.design.description.impl.panels.BasicButtonsPDBuilder;
import ru.app.project.utility.TextSizeCalculator;
import ru.app.project.utility.RelativeTextSizeRatioCalculator;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.itemDescriptionSelector.ItemDescriptionSelectorC;
import ru.app.project.windows.cards.selector.SelectorC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ButtonsP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final ButtonsPDBuilder designBuilder;
    private DescriptionCStateConfig config;
    private MutableComponent parent;

    private JButton button1;
    private JButton button2;

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
        button1 = designBuilder.buildJButtonDesign();
        button2 = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic() {
        button1.addActionListener(event -> rootWindow.showCard(ItemDescriptionSelectorC.class));
        button2.addActionListener(event -> rootWindow.showCard(SelectorC.class));

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if(buttonRatio == null) {
                    buttonRatio = RelativeTextSizeRatioCalculator.getJButtonTextRatio(button1);
                }
                TextSizeCalculator.calculateJButtonTextSize(button1, buttonRatio);
                TextSizeCalculator.calculateJButtonTextSize(button2, buttonRatio);
            }
        });
    }

    @Override
    public void runOnLeaveAction() {

    }

    @Override
    public void applyConfig() {
        button1.setText(config.getButton1());
        button2.setText(config.getButton2());
    }

    @Override
    public void setParent(MutableComponent parent) {

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
