package ru.app.project.windows.itemDescription.panels;

import ru.app.project.algo.RingBuffer;
import ru.app.project.components.ImagePanel;
import ru.app.project.config.AppProperties;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImagesP extends JPanel {
    private final RingBuffer<ImagePanel> images;

    public ImagesP() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        List<ImagePanel> imagePanels = new ArrayList<>(AppProperties.getMaxNumberOfImagesInItemDescriptionWindow());
        for (int i = 0; i < AppProperties.getMaxNumberOfImagesInItemDescriptionWindow(); i++) {
            imagePanels.add(new ImagePanel());
        }

        this.images = new RingBuffer<>(imagePanels);

        for (ImagePanel image : imagePanels) {
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

        imagePanel.setImage(image);
        imagePanel.setVisible(true);
    }
}
