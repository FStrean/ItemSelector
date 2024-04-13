package ru.app.project.windows.cards.panels.video;

import ru.app.project.config.cards.VideoCInfoCfg;
import ru.app.project.design.impl.panels.video.BasicVideosPDBuilder;
import ru.app.project.design.interf.panels.video.VideosPDBuilder;
import ru.app.project.windows.root.RootWindow;
import ru.app.project.windows.template.DynamicCard;
import ru.app.project.windows.template.DynamicPanel;
import ru.app.project.windows.template.StaticCard;
import uk.co.caprica.vlcj.player.base.Marquee;
import uk.co.caprica.vlcj.player.base.MarqueePosition;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

public class VideosP extends JPanel implements DynamicPanel {
    private RootWindow rootWin;
    private final VideosPDBuilder designBuilder;
    private VideoCInfoCfg cfg;
    private DynamicCard parent;

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
        applyVideoPlayerSettings(video1);
        applyVideoPlayerSettings(video2);
        applyVideoPlayerSettings(video3);
    }

    private void applyVideoPlayerSettings(EmbeddedMediaPlayerComponent video) {
        video.mediaPlayer().controls().setRepeat(true);
        video.videoSurfaceComponent().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(video.mediaPlayer().status().isPlaying()) {
                    Marquee marquee = Marquee.marquee()
                            .text("Paused")
                            .size(100)
                            .colour(Color.WHITE)
                            .position(MarqueePosition.CENTRE)
                            .opacity(0.5f)
                            .timeout(0)
                            .enable();
                    video.mediaPlayer().marquee().set(marquee);
                } else {
                    Marquee marquee = Marquee.marquee()
                            .text("Playing")
                            .size(100)
                            .colour(Color.WHITE)
                            .position(MarqueePosition.CENTRE)
                            .opacity(0.5f)
                            .timeout(1500)
                            .enable();
                    video.mediaPlayer().marquee().set(marquee);
                }
                video.mediaPlayer().controls().pause();
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
    public void setParent(StaticCard parent) {
        this.parent = (DynamicCard) parent;
    }

    @Override
    public void applyConfig() {
        int id1 = parent.getId() * 3 - 3;
        int id2 = parent.getId() * 3 - 2;
        int id3 = parent.getId() * 3 - 1;

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
        ((JFrame)rootWin).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("N");
                video1.release();
                video2.release();
                video3.release();
                System.out.println("I");
            }
        });
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (VideoCInfoCfg) cfg;
    }

    @Override
    public void setAddCfg(Object config) {
        this.cfg = (VideoCInfoCfg) config;
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
        video.mediaPlayer().media().startPaused(path);
        Marquee marquee = Marquee.marquee()
                .text("Paused")
                .size(100)
                .colour(Color.WHITE)
                .position(MarqueePosition.CENTRE)
                .opacity(0.5f)
                .timeout(0)
                .enable();
        video.mediaPlayer().marquee().set(marquee);
    }
}
