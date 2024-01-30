package ru.app.project.design.video.impl;

import ru.app.project.components.RelativeLayout;
import ru.app.project.design.video.interf.VideoCDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.cards.video.panels.VideosP;
import ru.app.project.windows.cards.video.panels.FooterP;
import ru.app.project.windows.cards.video.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicVideoCDBuilder implements VideoCDBuilder {
    private final JPanel panel;
    public BasicVideoCDBuilder(JPanel panel) {
        this.panel = panel;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);

        layout.setFill(true);
        this.panel.setLayout(layout);
    }

    @Override
    public BasicPanel buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP();

        panel.add(headerPanel, 10.0f);

        return headerPanel;
    }

    @Override
    public BasicPanel buildCenterPanelDesign() {
        VideosP videosPanel = new VideosP();

        panel.add(videosPanel, 60.0f);

        return videosPanel;
    }

    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP headerPanel = new FooterP();

        panel.add(headerPanel, 30.0f);

        return headerPanel;
    }

    @Override
    public void paint(Graphics g) {

    }
}
