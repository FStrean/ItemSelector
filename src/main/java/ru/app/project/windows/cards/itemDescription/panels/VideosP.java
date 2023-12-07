package ru.app.project.windows.cards.itemDescription.panels;

import ru.app.project.algo.RingBuffer;
import ru.app.project.config.AppProperties;
import ru.app.project.config.window.ItemDescriptionCStateConfig;
import ru.app.project.design.itemDescription.impl.panels.BasicVideosPDBuilder;
import ru.app.project.design.itemDescription.interf.panels.VideosPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VideosP extends JPanel implements BasicPanel {
    private RootWindow rootWindow;
    private ItemDescriptionCStateConfig.Item config;
    private MutableComponent parent;

    private RingBuffer<EmbeddedMediaPlayerComponent> videos;

    private final VideosPDBuilder designBuilder;

    public VideosP() {
        this.designBuilder = new BasicVideosPDBuilder(this);

        this.config = null;
        this.rootWindow = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        List<EmbeddedMediaPlayerComponent> embeddedMediaPlayerComponents = new ArrayList<>(AppProperties.getMaxNumberOfVideosInItemDescriptionWindow());
        for (int i = 0; i < AppProperties.getMaxNumberOfImagesInItemDescriptionWindow(); i++) {
            EmbeddedMediaPlayerComponent video = designBuilder.buildEmbeddedMediaPlayerComponent();
            embeddedMediaPlayerComponents.add(video);
            video.setVisible(false);
        }

        videos = new RingBuffer<>(embeddedMediaPlayerComponents);
    }

    @Override
    public void applyLogic() {
        for(EmbeddedMediaPlayerComponent video : videos.getElements()) {
            video.mediaPlayer().controls().setRepeat(true);
            video.videoSurfaceComponent().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    video.mediaPlayer().controls()
                            .setPause(video.mediaPlayer().status().isPlaying());
                }
            });
//            video.addComponentListener(new ComponentAdapter() {
//                @Override
//                public void componentResized(ComponentEvent e) {
//                    int cardWidth = ((JPanel)parent).getWidth();
//                    int componentWidth = e.getComponent().getWidth();
//                    int componentHeight = e.getComponent().getHeight();
//                    e.getComponent().setSize(new Dimension(cardWidth / 2 - 25, componentHeight));
//                }
//            });
        }
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                int cardWidth = ((JPanel)parent).getWidth();
                int componentHeight = e.getComponent().getHeight();

                e.getComponent().setSize(new Dimension(cardWidth / 2 - 25, componentHeight));
            }
        });
    }

    @Override
    public void runOnLeaveAction() {
        videos.reset();
        for(EmbeddedMediaPlayerComponent video : videos.getElements()) {
            video.mediaPlayer().controls().stop();
            video.setVisible(false);
        }
    }

    @Override
    public void loadConfig() {
        for(String path : config.getVideos()) {
            if(!path.isEmpty()) {
                addVideoToFrame(path);
            }
        }
    }

    @Override
    public void setParent(MutableComponent parent) {
        this.parent = parent;
    }

    @Override
    public void setRootWindow(RootWindow rootWindow) {
        this.rootWindow = rootWindow;
    }

    @Override
    public void setConfig(Object config) {
        this.config = (ItemDescriptionCStateConfig.Item)config;
    }

    private void addVideoToFrame(String path) {
        try {
            load(path);
        } catch (IOException e) {
            JOptionPane.showMessageDialog((JFrame) rootWindow, e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void load(String path) throws IOException {
        EmbeddedMediaPlayerComponent video = videos.getNext();

        video.setVisible(true);
        video.mediaPlayer().media().play(path);
    }
}
