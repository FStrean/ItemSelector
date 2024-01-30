package ru.app.project.design.impl.panels.select;

import ru.app.project.components.JImage;
import ru.app.project.components.RelativeLayout;
import ru.app.project.design.interf.panels.select.ButtonsPDBuilder;

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
        this.buttonsPanel = new JPanel();
        GridBagConstraints constraints = new GridBagConstraints();
        RelativeLayout layout = new RelativeLayout(RelativeLayout.X_AXIS, 20);

        layout.setFill(true);
        this.panel.setOpaque(false);
        this.panel.setLayout(new GridBagLayout());
        this.buttonsPanel.setOpaque(false);
        this.buttonsPanel.setLayout(layout);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.8;

        this.panel.add(buttonsPanel, constraints);
    }

    @Override
    public JLabel buildDescription() {
        JLabel text = new JLabel();
        JPanel p = new JPanel(new BorderLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setBackground(Color.LIGHT_GRAY);
        text.setOpaque(true);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0.2;
        p.setOpaque(false);
        p.setBorder(new EmptyBorder(0, 100, 0, 100));

        p.add(text);
        panel.add(p, constraints);

        return text;
    }

    @Override
    public JButton buildJButtonDesign() {
        JPanel bp = new JPanel();
        JImage jImg = new JImage();
        File imageFile = new File("icons/arrow_down.png");
        BufferedImage img;
        try {
            img = ImageIO.read(imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JButton btn = new JButton();
        JPanel p = new JPanel(new BorderLayout());

        bp.setOpaque(false);
        bp.setLayout(new GridLayout(0,1));
        jImg.setImg(img);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        p.setOpaque(false);
        p.setBorder(new EmptyBorder(0, 80, 15, 80));

        bp.add(jImg);
        p.add(btn);
        bp.add(p);
        buttonsPanel.add(bp, 50.0f);

        return btn;
    }
}
