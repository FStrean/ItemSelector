package ru.app.project.design.itemDescription.impl;

import ru.app.project.design.BasicSettings;
import ru.app.project.design.itemDescription.interf.ItemDescriptionCDBuilder;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.itemDescription.panels.FooterP;
import ru.app.project.windows.cards.itemDescription.panels.HeaderP;
import ru.app.project.windows.cards.itemDescription.panels.ImagesP;
import ru.app.project.windows.cards.itemDescription.panels.VideosP;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;

public class BasicItemDescriptionCDBuilder implements ItemDescriptionCDBuilder {
    private final JPanel panel;
    public BasicItemDescriptionCDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridBagLayout());
    }

    @Override
    public HeaderP buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP();
        GridBagConstraints constraints = getHeaderPanelLayoutSettings();
        panel.add(headerPanel, constraints);
        return headerPanel;
    }

    @Override
    public ImagesP buildImagePanelDesign() {
        ImagesP imagesP = new ImagesP();
        GridBagConstraints constraints = getImagePanelLayoutSettings();
        panel.add(imagesP, constraints);
        return imagesP;
    }

    @Override
    public VideosP buildVideoPlayerPanelDesign() {
        VideosP videoPlayerPanel = new VideosP();
        GridBagConstraints constraints = getVideoPlayerLayoutSettings();
        panel.add(videoPlayerPanel, constraints);
        return videoPlayerPanel;
    }

    @Override
    public FooterP buildFooterPanelDesign() {
        FooterP headerPanel = new FooterP();
        GridBagConstraints constraints = getFooterLayoutSettings();
        panel.add(headerPanel, constraints);
        return headerPanel;
    }

    private GridBagConstraints getHeaderPanelLayoutSettings() {
        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;

        return constraints;
    }

    private GridBagConstraints getImagePanelLayoutSettings() {
        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.5;
        constraints.weighty = 1;

        return constraints;
    }

    private GridBagConstraints getVideoPlayerLayoutSettings() {
        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.5;
        constraints.weighty = 1;

        return constraints;
    }

    private GridBagConstraints getFooterLayoutSettings() {
        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;

        return constraints;
    }
}
