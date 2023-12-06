package ru.app.project.windows.cards.itemDescriptionSelector.panels;

import ru.app.project.design.itemDescriptionSelector.impl.panels.BasicButtonsPDBuilder;
import ru.app.project.design.itemDescriptionSelector.interf.panels.ButtonsPDBuilder;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.itemDescription.ItemDescriptionC;

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
        for(int i = 0; i < 15; i++) {
            JButton jButton = designBuilder.buildJButtonDesign();
            buttons.add(jButton);
        }
    }

    public void applyLogic() {
        for(int i = 0; i < 15; i++) {
            int id = i + 1;
            buttons.get(i).setText(String.valueOf(id));
            buttons.get(i).addActionListener(event -> rootWindow.showCard(ItemDescriptionC.class, id));
        }
    }
}
