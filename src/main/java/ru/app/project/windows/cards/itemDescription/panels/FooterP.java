package ru.app.project.windows.cards.itemDescription.panels;

import ru.app.project.design.itemDescription.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.itemDescription.interf.panels.FooterPDBuilder;
import ru.app.project.windows.RootWindow;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FooterP extends JPanel {
    private final RootWindow rootWindow;
    private JLabel description;
    private JButton button;

    private final FooterPDBuilder designBuilder;
    public FooterP(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
        this.designBuilder = new BasicFooterPDBuilder(this);
        this.applyDesign();
        this.applyLogic();
    }

    public void applyDesign() {
        description = designBuilder.buildJLabelDesign();
        button = designBuilder.buildJButtonDesign();
    }

    public void applyLogic(){
    }
    public void onLeaveButtonPressedEvent(ActionListener l) {
        button.addActionListener(l);
    }

    public void setDescriptionText(String text) {
        description.setText(text);
    }
}
