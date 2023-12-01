package ru.app.project.design.itemDescription.impl;

import ru.app.project.config.SystemProperties;
import ru.app.project.design.itemDescription.interf.ItemDescriptionWDBuilder;
import ru.app.project.windows.itemDescription.panels.ImagesP;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;

public class BasicItemDescriptionWDBuilder implements ItemDescriptionWDBuilder {
    private final JFrame frame;
    public BasicItemDescriptionWDBuilder(JFrame frame) {
        this.frame = frame;
        frame.setLayout(new GridBagLayout());
        defineInitialWindowSize();
    }

    @Override
    public JPanel buildDescriptionPanelDesign() {
        JPanel descriptionPanel = new JPanel();
        GridBagConstraints constraints = getDescriptionPanelLayoutSettings();
        frame.add(descriptionPanel, constraints);
        return descriptionPanel;
    }

    @Override
    public ImagesP buildImagePanelDesign() {
        ImagesP imagesP = new ImagesP();
        GridBagConstraints constraints = getImagePanelLayoutSettings();
        frame.add(imagesP, constraints);
        return imagesP;
    }

    @Override
    public EmbeddedMediaPlayerComponent buildVideoPlayerPanelDesign() {
        EmbeddedMediaPlayerComponent videoPlayerPanel = new EmbeddedMediaPlayerComponent() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
            }
        };
        GridBagConstraints constraints = getVideoPlayerLayoutSettings();
        videoPlayerPanel.setMinimumSize(new Dimension(50, 50));
        frame.add(videoPlayerPanel, constraints);
        return videoPlayerPanel;
    }

    private void defineInitialWindowSize() {
        int width = SystemProperties.getScreenWidth();
        int height = SystemProperties.getScreenHeight();

        int x = (width - height) / 2;
        int y = (width - height) / 2;

        frame.setSize(width / 2, height / 2);
        frame.setLocation(x, y);

        frame.setLocationRelativeTo(null);
    }

    private GridBagConstraints getDescriptionPanelLayoutSettings() {
        GridBagConstraints constraints = getDefaultLayoutSettings();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;

        return constraints;
    }

    private GridBagConstraints getImagePanelLayoutSettings() {
        GridBagConstraints constraints = getDefaultLayoutSettings();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        return constraints;
    }

    private GridBagConstraints getVideoPlayerLayoutSettings() {
        GridBagConstraints constraints = getDefaultLayoutSettings();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        return constraints;
    }

    private GridBagConstraints getDefaultLayoutSettings() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 10;
        constraints.ipady = 10;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.LINE_START;

        return constraints;
    }
}
