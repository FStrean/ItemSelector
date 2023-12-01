package ru.app.project.windows.itemDescription.panels;

import ru.app.project.algo.RingBuffer;
import ru.app.project.config.AppProperties;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VideosP extends JPanel {
    private final RingBuffer<EmbeddedMediaPlayerComponent> videos;

    public VideosP() {
        this.setLayout(new GridBagLayout());

        EmbeddedMediaPlayerComponent[] videosArray = new EmbeddedMediaPlayerComponent[AppProperties.getMaxNumberOfVideosInItemDescriptionWindow()];
        for(int i = 0; i < videosArray.length; i++) {
            videosArray[i] = new EmbeddedMediaPlayerComponent();
        }

        this.videos = new RingBuffer<>(java.util.List.of(videosArray));

        for(EmbeddedMediaPlayerComponent image : videos.getElements()) {
            this.add(image);
        }
    }

    public List<EmbeddedMediaPlayerComponent> getVideos() {
        return videos.getElements();
    }

    public void reset() {
        videos.reset();
    }

//    public void load(String path) throws IOException {
//        EmbeddedMediaPlayerComponent videoPanel = videos.getNext();
//
//        File imageFile = new File(path);
//        BufferedImage image = ImageIO.read(imageFile);
//
//        if(image == null) {
//            throw new IOException("Image is null");
//        }
//
//        videoPanel.setVisible(true);
//        videoPanel.setImage(image);
//    }
}
