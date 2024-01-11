package ru.app.project.design.selector.impl.panels;

import ru.app.project.components.JImage;
import ru.app.project.components.RelativeLayout;
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
    private final JPanel buttonsPanel;

    public BasicButtonsPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridBagLayout());
        buttonsPanel = new JPanel();
        RelativeLayout layout = new RelativeLayout(RelativeLayout.X_AXIS, 20);
        layout.setFill(true);
        buttonsPanel.setLayout(layout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.8;
        panel.add(buttonsPanel, constraints);
    }

    @Override
    public JLabel buildDescription() {
        JLabel label = new JLabel();
        panel.add(label);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0.2;
        panel.add(label, constraints);
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
        buttonsPanel.add(buttonPanel, 50.0f);
        return button;
    }
}
