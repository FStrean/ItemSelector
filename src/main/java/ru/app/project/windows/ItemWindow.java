package ru.app.project.windows;

import ru.app.project.components.FileChooserButton;
import ru.app.project.components.ImageBasicPanel;
import ru.app.project.config.ItemWindowConfig;
import ru.app.project.design.ItemWindowDesignBuilder;
import ru.app.project.design.impl.ItemWindowBasicDesignBuilder;
import ru.app.project.utility.ImageBasicPanelUtil;
import ru.app.project.utility.ItemWindowStateUtil;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class ItemWindow extends JFrame {
    private final int id;
    private final JFrame parent;



    private final ItemWindowStateUtil itemWindowState = new ItemWindowStateUtil("ItemWindow.xml");
    private final ItemWindowConfig.Item config;



    private final ItemWindowDesignBuilder designBuilder;



    private JPanel descriptionPanel;
    private FileChooserButton imageChooserButton;
    private final ImageBasicPanelUtil[] images = {
            new ImageBasicPanelUtil(new ImageBasicPanel()),
            new ImageBasicPanelUtil(new ImageBasicPanel()),
            new ImageBasicPanelUtil(new ImageBasicPanel())
    };
    private int lastImageNumber = 0;



    private FileChooserButton videoChooserButton;
    private EmbeddedMediaPlayerComponent videoPlayer;



    public ItemWindow(String title, JFrame parent, int id) throws HeadlessException {
        super(title);

        this.parent = parent;
        this.id = id;

        this.config = this.itemWindowState.load(this.id);
        this.designBuilder = new ItemWindowBasicDesignBuilder(this);

        createStructure(this);
        parent.setVisible(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void createStructure(JFrame frame) {
        createDescriptionPanel();
        createImagePanel(frame);
        createVideoPlayer();
    }

    @Override
    protected void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            videoPlayer.release();
            parent.setVisible(true);
            itemWindowState.save(config);

            switch (super.getDefaultCloseOperation()) {
                case HIDE_ON_CLOSE -> setVisible(false);
                case DISPOSE_ON_CLOSE -> dispose();
                case EXIT_ON_CLOSE -> System.exit(0);
                default -> {
                }
            }
        }

        if(e.getID() == WindowEvent.WINDOW_OPENED) {
            if(!config.getVideo().isEmpty()) {
                videoPlayer.mediaPlayer().media().play(config.getVideo());
            }
        }
    }

    private String getDescription() {
        return """
                <html>
                    It is a long established fact that a reader will be distracted by the
                    readable content of a page when looking at its layout.
                    The point of using Lorem Ipsum is that it has a more-or-less normal
                    distribution of letters, as opposed to using 'Content here,
                    content here', making it look like readable English.
                    Many desktop publishing packages and web page editors<br>
                    now use Lorem Ipsum as their default model text, and a search for
                    'lorem ipsum' will uncover many web sites still in their infancy.
                    Various versions have evolved over the years, sometimes by accident,
                    sometimes on purpose (injected humour and the like).
                <html>
                """;
    }

    private void createDescriptionPanel() {
        descriptionPanel = new JPanel(new BorderLayout());
        JLabel description = new JLabel();
        description.setText(getDescription());
        descriptionPanel.add(description);
        designBuilder.buildDescriptionPanelDesign(descriptionPanel);
    }

    private void loadImage(String path, JFrame frame) {
        try {
            if(path != null) {
                images[lastImageNumber].loadImage(path);
                images[lastImageNumber].getImageBasicPanel().setVisible(true);
                lastImageNumber = (lastImageNumber + 1) % 3;
            } else {
                images[lastImageNumber].getImageBasicPanel().setVisible(false);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createImagePanel(JFrame frame) {
        imageChooserButton = new FileChooserButton(this, "Выбрать изображение") {
            @Override
            public void fileSelectedActionPerformed(File file) {
                if(config.getImages().size() <= lastImageNumber) {
                    config.getImages().add(file.getAbsolutePath());
                } else {
                    config.getImages().set(lastImageNumber, file.getAbsolutePath());
                }
                loadImage(file.getAbsolutePath(), frame);
            }
        };

        for (int i = 0; i < 3; i++) {
            designBuilder.buildImageDesign(images[i].getImageBasicPanel(), i);
            if(i >= config.getImages().size()) {
                loadImage(null, frame);
            } else {
                loadImage(config.getImages().get(i), frame);
            }
        }

        designBuilder.buildImageChooserButtonDesign(imageChooserButton);
    }

    private void createVideoPlayer() {
        JPanel playerPanel = new JPanel(new BorderLayout());
        videoPlayer = new EmbeddedMediaPlayerComponent();
        videoPlayer.mediaPlayer().controls().setRepeat(true);
        playerPanel.add(videoPlayer);
        videoChooserButton = new FileChooserButton(this, "Выбрать видео") {
            @Override
            public void fileSelectedActionPerformed(File file) {
                config.setVideo(file.getAbsolutePath());
                videoPlayer.mediaPlayer().media().play(file.getAbsolutePath());
            }
        };

        designBuilder.buildVideoChooserButtonDesign(videoChooserButton);
        designBuilder.buildVideoPlayerDesign(videoPlayer);
    }
}
