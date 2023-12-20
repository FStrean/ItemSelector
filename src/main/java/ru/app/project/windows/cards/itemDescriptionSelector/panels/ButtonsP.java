package ru.app.project.windows.cards.itemDescriptionSelector.panels;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.ItemDescriptionCStateConfig;
import ru.app.project.config.window.ItemDescriptionSelectorCStateConfig;
import ru.app.project.design.itemDescriptionSelector.impl.panels.BasicButtonsPDBuilder;
import ru.app.project.design.itemDescriptionSelector.interf.panels.ButtonsPDBuilder;
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
    private ItemDescriptionSelectorCStateConfig config;
    private MutableComponent parent;

    private final List<JButton> buttons;

    public ButtonsP() {
        this.designBuilder = new BasicButtonsPDBuilder(this);
        this.buttons = new ArrayList<>(3);

        this.rootWindow = null;
        this.config = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        for(int i = 0; i < 15; i++) {
            JButton jButton = designBuilder.buildJButtonDesign();
            buttons.add(jButton);
        }
    }

    @Override
    public void applyLogic() {
        for(int i = 0; i < AppProperties.getNumberOfItemsInItemDescriptionWindow(); i++) {
            int id = i + 1;
            buttons.get(i).addActionListener(event -> rootWindow.showCard(ItemDescriptionC.class, id));
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
        for(int i = 0; i < AppProperties.getNumberOfItemsInItemDescriptionWindow(); i++) {
            buttons.get(i).setText(config.getButtons().get(i));
        }
    }

    @Override
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {
        this.config = (ItemDescriptionSelectorCStateConfig)config;
    }
}
