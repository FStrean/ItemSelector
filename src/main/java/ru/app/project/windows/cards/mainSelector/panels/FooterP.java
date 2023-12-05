package ru.app.project.windows.cards.mainSelector.panels;

import ru.app.project.design.mainSelector.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.mainSelector.interf.panels.FooterPDBuilder;

import javax.swing.*;

public class FooterP extends JPanel {
    private JLabel description;

    private final FooterPDBuilder designBuilder;
    public FooterP( ) {
        this.designBuilder = new BasicFooterPDBuilder(this);
        this.applyDesign();
        this.applyLogic();
    }

    public void applyDesign() {
        description = designBuilder.buildJLabelDesign();
    }

    public void applyLogic(){
    }

    public void setDescriptionText(String text) {
        description.setText(text);
    }
}
