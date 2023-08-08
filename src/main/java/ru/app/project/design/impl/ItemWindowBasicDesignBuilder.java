package ru.app.project.design.impl;

import ru.app.project.components.FileChooserButton;
import ru.app.project.components.ImageBasicPanel;
import ru.app.project.config.SystemProperties;
import ru.app.project.design.ItemWindowDesignBuilder;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;

public class ItemWindowBasicDesignBuilder implements ItemWindowDesignBuilder {
    private final JFrame frame;
    public ItemWindowBasicDesignBuilder(JFrame frame) {
        this.frame = frame;
        frame.setLayout(new GridBagLayout());
        defineInitialWindowSize();
    }

    @Override
    public void buildDescriptionPanelDesign(JPanel descriptionPanel) {
        GridBagConstraints descriptionPanelConstraints = getDefaultLayoutSettings();
        frame.add(descriptionPanel, descriptionPanelConstraints);
    }

    @Override
    public void buildImageChooserButtonDesign(FileChooserButton imageChooserButton) {
        GridBagConstraints constraints = getImageChooserButtonLayoutSettings();
        frame.add(imageChooserButton, constraints);
    }

    @Override
    public void buildImageDesign(ImageBasicPanel imagePanel, int i) {
        GridBagConstraints constraints = getImageBasicPanelLayoutSettings(i);
        frame.add(imagePanel, constraints);
    }

    @Override
    public void buildVideoChooserButtonDesign(FileChooserButton videoChooserButton) {
        GridBagConstraints constraints = getVideoChooserButtonLayoutSettings();
        frame.add(videoChooserButton, constraints);
    }

    @Override
    public void buildVideoPlayerDesign(EmbeddedMediaPlayerComponent videoPlayer) {
        GridBagConstraints constraints = getVideoPlayerLayoutSettings();
        videoPlayer.setMinimumSize(new Dimension(10, 10));
        frame.add(videoPlayer, constraints);
    }

    @Override
    public void defineInitialWindowSize() {
        int width = SystemProperties.getScreenWidth();
        int height = SystemProperties.getScreenHeight();

        int x = (width - height) / 2;
        int y = (width - height) / 2;

        frame.setSize(width / 2, height / 2);
        frame.setLocation(x, y);

        frame.setLocationRelativeTo(null);
    }

    private GridBagConstraints getImageBasicPanelLayoutSettings(int i) {
        GridBagConstraints constraints = getDefaultLayoutSettings();

        constraints.gridy = 2 + i;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1;

        return constraints;
    }

    private GridBagConstraints getImageChooserButtonLayoutSettings() {
        GridBagConstraints constraints = getDefaultLayoutSettings();
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        return constraints;
    }

    private GridBagConstraints getVideoPlayerLayoutSettings() {
        GridBagConstraints constraints = getDefaultLayoutSettings();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;

        return constraints;
    }

    private GridBagConstraints getVideoChooserButtonLayoutSettings() {
        GridBagConstraints constraints = getDefaultLayoutSettings();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        return constraints;
    }

    private GridBagConstraints getDefaultLayoutSettings() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 10;
        constraints.ipady = 10;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.weightx = 1;
        constraints.weighty = 0;

        return constraints;
    }
}
