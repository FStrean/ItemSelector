package ru.app.project.design.impl;

import ru.app.project.components.RelativeLayout;
import ru.app.project.design.interf.VideoCDBuilder;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.cards.panels.video.VideosP;
import ru.app.project.windows.cards.panels.video.FooterP;
import ru.app.project.windows.cards.panels.video.HeaderP;

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
    public StaticPanel buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP();

        panel.add(headerPanel, 10.0f);

        return headerPanel;
    }

    @Override
    public StaticPanel buildCenterPanelDesign() {
        VideosP videosPanel = new VideosP();

        panel.add(videosPanel, 60.0f);

        return videosPanel;
    }

    @Override
    public StaticPanel buildFooterPanelDesign() {
        FooterP headerPanel = new FooterP();

        panel.add(headerPanel, 30.0f);

        return headerPanel;
    }

    @Override
    public void paint(Graphics g) {

    }
}
