package ru.app.project.windows.cards.mainSelector.panels;

import ru.app.project.design.mainSelector.impl.panels.BasicHeaderPDBuilder;
import ru.app.project.design.mainSelector.interf.panels.HeaderPDBuilder;

import javax.swing.*;

public class HeaderP extends JPanel {
    private JLabel description;

    private final HeaderPDBuilder designBuilder;
    public HeaderP() {
        designBuilder = new BasicHeaderPDBuilder(this);
        applyDesign();
        applyLogic();
    }

    public void applyDesign() {
        this.description = designBuilder.buildJLabelDesign();
    }

    public void applyLogic() {
    }

    public void setDescriptionText(String text) {
        description.setText(text);
    }
}
