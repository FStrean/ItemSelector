package ru.app.project.windows.itemDescription;

import ru.app.project.components.ImagePanel;
import ru.app.project.config.AppProperties;
import ru.app.project.config.ItemDescriptionWStateConfig;
import ru.app.project.design.itemDescription.interf.ItemDescriptionWDBuilder;
import ru.app.project.design.itemDescription.impl.BasicItemDescriptionWDBuilder;
import ru.app.project.utility.ItemDescriptionWContentUtil;
import ru.app.project.windows.itemDescription.panels.ImagesP;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ItemDescriptionW {
    private final JFrame frame;
    private final JFrame parentFrame;

    private final ItemDescriptionWContentUtil itemWindowState =
            new ItemDescriptionWContentUtil(AppProperties.getItemWindowContentConfigName());
    private ItemDescriptionWStateConfig.Item config;

    private final ItemDescriptionWDBuilder designBuilder;

    private JPanel descriptionPanel;
    private JLabel description;
    private ImagesP images;

    private EmbeddedMediaPlayerComponent videoPlayer;

    public ItemDescriptionW(String title, JFrame parentFrame) throws HeadlessException {
        this.frame = new JFrame(title);

        this.parentFrame = parentFrame;
        this.designBuilder = new BasicItemDescriptionWDBuilder(this.frame);

        this.initializeDesign();
        this.createStructure();

        this.defineWindowClosedActions();

        this.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void show(int id) {
        config = itemWindowState.load(id);
        loadConfig();
        parentFrame.setVisible(false);
        frame.setVisible(true);
    }

    private void createStructure() {
        createDescriptionPanel();
        createImagePanel();
        createVideoPlayerPanel();
    }

    private void createDescriptionPanel() {
        description = new JLabel();
        descriptionPanel.add(description);
    }

    private void createImagePanel() {
        images.getImages().forEach(image -> image.setVisible(false));
    }

    private void createVideoPlayerPanel() {
        videoPlayer.setVisible(false);
        videoPlayer.mediaPlayer().controls().setRepeat(true);
        videoPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                videoPlayer.mediaPlayer().controls()
                        .setPause(videoPlayer.mediaPlayer().status().isPlaying());
            }
        });
    }

    private void defineWindowClosedActions() {
        this.frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                //TODO
                images.reset();

                for(ImagePanel image : ItemDescriptionW.this.images.getImages()) {
                    image.removeImage();
                    image.setVisible(false);
                }

                ItemDescriptionW.this.videoPlayer.mediaPlayer().controls().stop();
                ItemDescriptionW.this.videoPlayer.setVisible(false);

                ItemDescriptionW.this.parentFrame.setVisible(true);
            }
        });
    }

    private void loadConfig() {
        description.setText(config.getDescription());

        if(!config.getVideo().isEmpty()) {
            videoPlayer.setVisible(true);
            //videoPlayer.mediaPlayer().media().play(config.getVideo());
        }

        for(String path : config.getImages()) {
            if(!path.isEmpty()) {
                addImageToFrame(path);
            }
        }
    }

    private void initializeDesign() {
        descriptionPanel = designBuilder.buildDescriptionPanelDesign();
        images = designBuilder.buildImagePanelDesign();
        videoPlayer = designBuilder.buildVideoPlayerPanelDesign();
    }

    private void addImageToFrame(String path) {
        try {
            images.load(path);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}
