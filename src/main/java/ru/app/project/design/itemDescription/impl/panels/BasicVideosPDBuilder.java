package ru.app.project.design.itemDescription.impl.panels;

import ru.app.project.components.JImage;
import ru.app.project.design.itemDescription.interf.panels.VideosPDBuilder;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class BasicVideosPDBuilder implements VideosPDBuilder {
    private final JPanel panel;
    public BasicVideosPDBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }
    @Override
    public EmbeddedMediaPlayerComponent buildEmbeddedMediaPlayerComponent() {
        EmbeddedMediaPlayerComponent videoPlayerPanel = new EmbeddedMediaPlayerComponent();
        videoPlayerPanel.setMinimumSize(new Dimension(1, 1));
        panel.add(videoPlayerPanel);
        return videoPlayerPanel;
    }
}
