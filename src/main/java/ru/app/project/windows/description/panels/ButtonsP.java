package ru.app.project.windows.description.panels;

import ru.app.project.config.AppProperties;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonsP extends JPanel {
    private final List<JButton> items;

    ButtonsP() {
        items = new ArrayList<>(AppProperties.getNumberOfButtonsInItemDescriptionSelectorWindow());
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setText("" + (i + 1));
        }
        items.forEach(item -> item.setText("1"));
    }
}
