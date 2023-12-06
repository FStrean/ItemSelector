package ru.app.project.windows.cards.itemDescriptionSelector.panels;

import ru.app.project.design.itemDescriptionSelector.impl.panels.BasicHeaderPDBuilder;
import ru.app.project.design.itemDescriptionSelector.interf.panels.HeaderPDBuilder;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.description.DescriptionC;
import ru.app.project.windows.cards.selector.SelectorC;

import javax.swing.*;
import java.awt.event.ActionListener;

public class HeaderP extends JPanel {
    private final RootWindow rootWindow;
    private JButton buttonLeft;
    private JLabel description;
    private JButton buttonRight;

    private final HeaderPDBuilder designBuilder;
    public HeaderP(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
        this.designBuilder = new BasicHeaderPDBuilder(this);
        this.applyDesign();
        this.applyLogic();
    }

    public void applyDesign() {
        buttonLeft = designBuilder.buildJButtonLeftDesign();
        description = designBuilder.buildJLabelDesign();
        buttonRight = designBuilder.buildJButtonRightDesign();
    }

    public void applyLogic(){
        buttonLeft.addActionListener(event -> rootWindow.showCard(DescriptionC.class));
        buttonRight.addActionListener(event -> rootWindow.showCard(SelectorC.class));
    }

    public void onLeaveButtonPressedEvent(ActionListener l) {
        buttonLeft.addActionListener(l);
        buttonRight.addActionListener(l);
    }

    public void setDescriptionText(String text) {
        description.setText(text);
    }
}
