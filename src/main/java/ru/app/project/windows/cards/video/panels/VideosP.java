package ru.app.project.windows.cards.video.panels;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.VideoCInfoCfg;
import ru.app.project.design.video.impl.panels.BasicVideosPDBuilder;
import ru.app.project.design.video.interf.panels.VideosPDBuilder;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.utility.TSCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.iDesc.IDescC;
import ru.app.project.windows.cards.iSelectSelect.ISelectSelectC;
import ru.app.project.windows.cards.video.VideoC;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

public class VideosP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final VideosPDBuilder designBuilder;
    private VideoCInfoCfg cfg;
    private MutableComponent parent;

    private List<EmbeddedMediaPlayerComponent> videos;

    private EmbeddedMediaPlayerComponent video1;
    private EmbeddedMediaPlayerComponent video2;
    private EmbeddedMediaPlayerComponent video3;

    private Double descRatio = null;
    private Double btnRatio = null;

    public VideosP() {
        this.designBuilder = new BasicVideosPDBuilder(this);

        this.rootWin = null;
        this.cfg = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        video1 = designBuilder.buildEmbeddedMediaPlayerComponent();
        video2 = designBuilder.buildEmbeddedMediaPlayerComponent();
        video3 = designBuilder.buildEmbeddedMediaPlayerComponent();
        video1.setVisible(false);
        video2.setVisible(false);
        video3.setVisible(false);
    }

    @Override
    public void applyLogic() {
        video1.mediaPlayer().controls().setRepeat(true);
        video1.videoSurfaceComponent().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                video1.mediaPlayer().controls()
                        .setPause(video1.mediaPlayer().status().isPlaying());
            }
        });

        video2.mediaPlayer().controls().setRepeat(true);
        video2.videoSurfaceComponent().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                video2.mediaPlayer().controls()
                        .setPause(video2.mediaPlayer().status().isPlaying());
            }
        });

        video3.mediaPlayer().controls().setRepeat(true);
        video3.videoSurfaceComponent().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                video3.mediaPlayer().controls()
                        .setPause(video3.mediaPlayer().status().isPlaying());
            }
        });
    }

    @Override
    public void runOnLeaveAction() {
        video1.mediaPlayer().controls().stop();
        video1.setVisible(false);

        video2.mediaPlayer().controls().stop();
        video2.setVisible(false);

        video3.mediaPlayer().controls().stop();
        video3.setVisible(false);
    }

    @Override
    public void setParent(MutableComponent parent) {
        this.parent = parent;
    }

    @Override
    public void applyConfig() {
        int id1 = ((VideoC)parent).getId() * 3 - 3;
        int id2 = ((VideoC)parent).getId() * 3 - 2;
        int id3 = ((VideoC)parent).getId() * 3 - 1;

        int size = cfg.getVideos().size();

        if(id1 < size && !cfg.getVideos().get(id1).isEmpty()) {
            video1.setVisible(true);
            String path1 = cfg.getVideos().get(id1);
            if (!path1.isEmpty()) {
                addVideoToFrame(video1, path1);
            }
        }

        if(id2 < size && !cfg.getVideos().get(id2).isEmpty()) {
            video1.setVisible(true);
            String path2 = cfg.getVideos().get(id2);
            if (!path2.isEmpty()) {
                addVideoToFrame(video2, path2);
            }
        }

        if(id3 < size && !cfg.getVideos().get(id3).isEmpty()) {
            video1.setVisible(true);
            String path3 = cfg.getVideos().get(id3);
            if (!path3.isEmpty()) {
                addVideoToFrame(video3, path3);
            }
        }
    }

    @Override
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (VideoCInfoCfg) cfg;
    }

    private void addVideoToFrame(EmbeddedMediaPlayerComponent video, String path) {
        try {
            load(video, path);
        } catch (IOException e) {
            JOptionPane.showMessageDialog((JFrame) rootWin, e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void load(EmbeddedMediaPlayerComponent video, String path) throws IOException {
        video.setVisible(true);
        video.mediaPlayer().media().play(path);
    }
}
