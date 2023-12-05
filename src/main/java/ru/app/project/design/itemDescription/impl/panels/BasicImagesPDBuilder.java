package ru.app.project.design.itemDescription.impl.panels;

import ru.app.project.components.JImage;
import ru.app.project.design.itemDescription.interf.panels.ImagesPDBuilder;
import ru.app.project.windows.cards.itemDescription.panels.ImagesP;

import javax.swing.*;
import java.awt.*;

public class BasicImagesPDBuilder implements ImagesPDBuilder {
    private final JPanel panel;
    public BasicImagesPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }

    @Override
    public JImage buildJImageDesign() {
        JImage imagesPanel = new JImage();
        panel.add(imagesPanel);
        return imagesPanel;
    }
}
