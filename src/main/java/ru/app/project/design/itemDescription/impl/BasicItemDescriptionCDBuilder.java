package ru.app.project.design.itemDescription.impl;

import ru.app.project.design.BasicSettings;
import ru.app.project.design.itemDescription.interf.ItemDescriptionCDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.cards.itemDescription.panels.*;
//import ru.app.project.windows.cards.itemDescription.panels.VideosP;

import javax.swing.*;
import java.awt.*;

public class BasicItemDescriptionCDBuilder implements ItemDescriptionCDBuilder {
    private final JPanel panel;
    public BasicItemDescriptionCDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridBagLayout());
    }

    @Override
    public BasicPanel buildHeader1PanelDesign() {
        Header1P header1Panel = new Header1P();
        GridBagConstraints constraints = getHeader1PanelLayoutSettings();
        panel.add(header1Panel, constraints);
        return header1Panel;
    }

    @Override
    public BasicPanel buildHeader2PanelDesign() {
        Header2P header2Panel = new Header2P();
        GridBagConstraints constraints = getHeader2PanelLayoutSettings();
        panel.add(header2Panel, constraints);
        return header2Panel;
    }

    @Override
    public BasicPanel buildLeftPanelDesign() {
        ImagesP imagesP = new ImagesP();
        GridBagConstraints constraints = getImagePanelLayoutSettings();
        panel.add(imagesP, constraints);
        return imagesP;
    }

//    @Override
//    public BasicPanel buildRightPanelDesign() {
//        VideosP videoPlayerPanel = new VideosP();
//        GridBagConstraints constraints = getVideoPlayerLayoutSettings();
//        panel.add(videoPlayerPanel, constraints);
//        return videoPlayerPanel;
//    }
    @Override
    public BasicPanel buildRightPanelDesign() {
        DescriptionP descriptionPanel = new DescriptionP();
        GridBagConstraints constraints = getDescriptionPanelLayoutSettings();
        panel.add(descriptionPanel, constraints);
        return descriptionPanel;
    }


    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP headerPanel = new FooterP();
        GridBagConstraints constraints = getFooterLayoutSettings();
        panel.add(headerPanel, constraints);
        return headerPanel;
    }

    private GridBagConstraints getHeader1PanelLayoutSettings() {
        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;

        return constraints;
    }

    private GridBagConstraints getHeader2PanelLayoutSettings() {
        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.9;
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
        constraints.weighty = 0.7;

        return constraints;
    }

    private GridBagConstraints getDescriptionPanelLayoutSettings() {
        GridBagConstraints constraints = BasicSettings.getDefaultGridBagLayout();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.5;
        constraints.weighty = 0.7;

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
