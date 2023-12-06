package ru.app.project.windows.cards.mainSelector.panels;

import ru.app.project.design.mainSelector.impl.panels.BasicButtonsPDBuilder;
import ru.app.project.design.mainSelector.interf.panels.ButtonsPDBuilder;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.description.DescriptionC;
import ru.app.project.windows.cards.itemDescriptionSelector.ItemDescriptionSelectorC;
import ru.app.project.windows.cards.selector.SelectorC;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonsP extends JPanel {
    private final RootWindow rootWindow;
    private final List<JButton> buttons;
    private final ButtonsPDBuilder designBuilder;
    public ButtonsP(RootWindow rootWindow) {
        this.designBuilder = new BasicButtonsPDBuilder(this);
        this.buttons = new ArrayList<>(3);
        this.rootWindow = rootWindow;

        applyDesign();
        applyLogic();
    }

    public void applyDesign() {
        for(int i = 0; i < 3; i++) {
            JButton jButton = designBuilder.buildJButtonDesign();
            buttons.add(jButton);
        }
    }

    public void applyLogic() {
        buttons.get(0).setText("Назначение");
        buttons.get(0).addActionListener(event -> rootWindow.showCard(DescriptionC.class));

        buttons.get(1).setText("Состав");
        buttons.get(1).addActionListener(event -> rootWindow.showCard(ItemDescriptionSelectorC.class));

        buttons.get(2).setText("Работа");
        buttons.get(2).addActionListener(event -> rootWindow.showCard(SelectorC.class));
    }
}
