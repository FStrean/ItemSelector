package ru.app.project.windows.cards.itemDescriptionSelector.panels;

import ru.app.project.design.itemDescriptionSelector.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.itemDescriptionSelector.interf.panels.FooterPDBuilder;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.mainSelector.MainSelectorC;

import javax.swing.*;
import java.awt.*;

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
        button.setMaximumSize(new Dimension(20, 20));

    }

    public void applyLogic() {
        button.addActionListener(event -> rootWindow.showCard(MainSelectorC.class));
    }

    public void setDescriptionText(String text) {
        description.setText(text);
    }
}
