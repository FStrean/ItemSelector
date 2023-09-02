package ru.app.project.windows.panels;

import ru.app.project.algo.RingBuffer;
import ru.app.project.components.ImagePanel;
import ru.app.project.config.AppProperties;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ItemWindowImages extends JPanel {
    private final RingBuffer<ImagePanel> images;

    public ItemWindowImages() {
        this.setLayout(new GridBagLayout());

        ImagePanel[] imagesArray = new ImagePanel[AppProperties.getMaxNumberOfImagesInItemWindow()];
        for(int i = 0; i < imagesArray.length; i++) {
            imagesArray[i] = new ImagePanel();
        }

        this.images = new RingBuffer<>(List.of(imagesArray));

        for(ImagePanel image : images.getElements()) {
            this.add(image);
        }
    }

    public List<ImagePanel> getImages() {
        return images.getElements();
    }

    public void reset() {
        images.reset();
    }

    public void load(String path) throws IOException {
        ImagePanel imagePanel = images.getNext();

        File imageFile = new File(path);
        BufferedImage image = ImageIO.read(imageFile);

        if(image == null) {
            throw new IOException("Image is null");
        }

        imagePanel.setVisible(true);
        imagePanel.setImage(image);
    }
}
