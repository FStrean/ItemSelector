package ru.app.project.windows.cards.itemDescription.panels;

import ru.app.project.design.itemDescription.impl.panels.BasicHeaderPDBuilder;
import ru.app.project.design.itemDescription.interf.panels.HeaderPDBuilder;
import ru.app.project.windows.MainWindow;
import ru.app.project.windows.cards.itemDescription.ItemDescriptionC;

import javax.swing.*;
import java.awt.event.ActionListener;

public class HeaderP extends JPanel {
    private final MainWindow mainWindow;
    private int id;
    private JButton buttonLeft;
    private JButton buttonRight;
    private JLabel description;

    private final HeaderPDBuilder designBuilder;
    public HeaderP(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.designBuilder = new BasicHeaderPDBuilder(this);
        this.id = 1;
        this.applyDesign();
        this.applyLogic();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void applyDesign() {
        buttonLeft = designBuilder.buildJButtonLeftDesign();
        buttonRight = designBuilder.buildJButtonRightDesign();
        description = designBuilder.buildJLabelDesign();
    }

    public void applyLogic(){
        buttonLeft.addActionListener(event -> mainWindow.showCard(ItemDescriptionC.class, (id - 1) < 1 ? 15 : (id - 1)));
        buttonRight.addActionListener(event -> mainWindow.showCard(ItemDescriptionC.class, (id + 1) > 15 ? 1 : (id + 1)));
    }

    public void onLeaveButtonPressedEvent(ActionListener l) {
        buttonLeft.addActionListener(l);
        buttonRight.addActionListener(l);
    }

    public void setDescriptionText(String text) {
        description.setText(text);
    }
}
