package ru.app.project.windows.cards.selector.panels;

import ru.app.project.config.window.SelectorCStateConfig;
import ru.app.project.design.selector.impl.panels.BasicButtonsPDBuilder;
import ru.app.project.design.selector.interf.panels.ButtonsPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.itemDescription.ItemDescriptionC;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonsP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private final ButtonsPDBuilder designBuilder;
    private SelectorCStateConfig config;
    private MutableComponent parent;

    private JLabel description;
    private final List<JButton> buttons;

    public ButtonsP() {
        this.designBuilder = new BasicButtonsPDBuilder(this);
        this.buttons = new ArrayList<>(2);

        this.rootWindow = null;
        this.config = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        description = designBuilder.buildDescription();
        for(int i = 0; i < 2; i++) {
            JButton jButton = designBuilder.buildJButtonDesign();
            buttons.add(jButton);
        }
    }

    @Override
    public void applyLogic() {
        buttons.get(0).addActionListener(event -> rootWindow.showCard(ItemDescriptionC.class, 1));
        buttons.get(1).addActionListener(event -> rootWindow.showCard(ItemDescriptionC.class, 1));
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
        buttons.get(0).setText(config.getButton1());
        buttons.get(1).setText(config.getButton2());
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
