package ru.app.project.windows.cards.description.panels;

import ru.app.project.config.AppProperties;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonsP extends JPanel {
    private final List<JButton> items;

    ButtonsP() {
        items = new ArrayList<>(AppProperties.getNumberOfItemsInItemDescriptionWindow());
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setText("" + (i + 1));
        }
        items.forEach(item -> item.setText("1"));
    }
}
