package ru.app.project.windows.cards.itemDescriptionSelector.panels;

import ru.app.project.design.itemDescriptionSelector.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.itemDescriptionSelector.interf.panels.FooterPDBuilder;
import ru.app.project.windows.MainWindow;
import ru.app.project.windows.cards.itemDescription.ItemDescriptionC;
import ru.app.project.windows.cards.mainSelector.MainSelectorC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FooterP extends JPanel {
    private final MainWindow mainWindow;
    private JLabel description;
    private JButton button;

    private final FooterPDBuilder designBuilder;
    public FooterP(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.designBuilder = new BasicFooterPDBuilder(this);
        this.applyDesign();
        this.applyLogic();
    }

    public void applyDesign() {
        description = designBuilder.buildJLabelDesign();
        button = designBuilder.buildJButtonDesign();
        button.setMaximumSize(new Dimension(20, 20));

    }

    public void applyLogic() {
        button.addActionListener(event -> mainWindow.showCard(MainSelectorC.class));
    }

    public void setDescriptionText(String text) {
        description.setText(text);
    }
}
