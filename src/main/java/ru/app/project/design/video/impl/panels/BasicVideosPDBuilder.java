package ru.app.project.design.video.impl.panels;

import ru.app.project.components.RelativeLayout;
import ru.app.project.design.video.interf.panels.VideosPDBuilder;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;


public class BasicVideosPDBuilder implements VideosPDBuilder {
    private final JPanel panel;
    public BasicVideosPDBuilder(JPanel panel) {
        this.panel = panel;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.X_AXIS, 10);

        layout.setFill(true);
        this.panel.setOpaque(false);
        this.panel.setLayout(layout);
    }


    @Override
    public EmbeddedMediaPlayerComponent buildEmbeddedMediaPlayerComponent() {
        EmbeddedMediaPlayerComponent videoPlayerPanel = new EmbeddedMediaPlayerComponent();

        videoPlayerPanel.setMinimumSize(new Dimension(1, 1));

        panel.add(videoPlayerPanel, 33.3f);

        return videoPlayerPanel;
    }
}
