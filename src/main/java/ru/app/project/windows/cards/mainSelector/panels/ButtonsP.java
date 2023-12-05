package ru.app.project.windows.cards.mainSelector.panels;

import ru.app.project.design.mainSelector.impl.panels.BasicButtonsPDBuilder;
import ru.app.project.design.mainSelector.interf.panels.ButtonsPDBuilder;
import ru.app.project.windows.MainWindow;
import ru.app.project.windows.cards.description.DescriptionC;
import ru.app.project.windows.cards.itemDescriptionSelector.ItemDescriptionSelectorC;
import ru.app.project.windows.cards.selector.SelectorC;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonsP extends JPanel {
    private final MainWindow mainWindow;
    private final List<JButton> buttons;
    private final ButtonsPDBuilder designBuilder;
    public ButtonsP(MainWindow mainWindow) {
        this.designBuilder = new BasicButtonsPDBuilder(this);
        this.buttons = new ArrayList<>(3);
        this.mainWindow = mainWindow;

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
        buttons.get(0).addActionListener(event -> mainWindow.showCard(DescriptionC.class));

        buttons.get(1).setText("Состав");
        buttons.get(1).addActionListener(event -> mainWindow.showCard(ItemDescriptionSelectorC.class));

        buttons.get(2).setText("Работа");
        buttons.get(2).addActionListener(event -> mainWindow.showCard(SelectorC.class));
    }
}
