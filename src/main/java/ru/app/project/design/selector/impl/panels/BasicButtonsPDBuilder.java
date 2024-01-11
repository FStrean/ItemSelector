package ru.app.project.design.selector.impl.panels;

import ru.app.project.components.JImage;
import ru.app.project.design.selector.interf.panels.ButtonsPDBuilder;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BasicButtonsPDBuilder implements ButtonsPDBuilder {
    private final JPanel panel;

    public BasicButtonsPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridLayout(0,2));
    }

    @Override
    public JLabel buildDescription() {
        JLabel label = new JLabel();
        return label;
    }

    @Override
    public JButton buildJButtonDesign() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,1));
        JImage image = new JImage();
        File imageFile = new File("icons/arrow_down.png");
        BufferedImage img;
        try {
            img = ImageIO.read(imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        image.setImage(img);
        buttonPanel.add(image);
        JButton button = new JButton();
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(15, 40, 15, 40));
        jPanel.add(button);
        buttonPanel.add(jPanel);
        panel.add(buttonPanel);
        return button;
    }
}
