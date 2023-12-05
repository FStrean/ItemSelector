package ru.app.project.windows.cards.itemDescription.panels;

import ru.app.project.algo.RingBuffer;
import ru.app.project.components.JImage;
import ru.app.project.config.AppProperties;
import ru.app.project.design.itemDescription.impl.panels.BasicImagesPDBuilder;
import ru.app.project.design.itemDescription.interf.panels.ImagesPDBuilder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImagesP extends JPanel {
    private RingBuffer<JImage> images;

    private final ImagesPDBuilder designBuilder;

    public ImagesP() {
        designBuilder = new BasicImagesPDBuilder(this);
        applyDesign();
        applyLogic();
    }

    public void applyDesign() {
        List<JImage> jImages = new ArrayList<>(AppProperties.getMaxNumberOfImagesInItemDescriptionWindow());
        for (int i = 0; i < AppProperties.getMaxNumberOfImagesInItemDescriptionWindow(); i++) {
            JImage image = designBuilder.buildJImageDesign();
            jImages.add(image);
            image.setVisible(false);
        }

        images = new RingBuffer<>(jImages);
    }

    public void applyLogic() {
    }

    public void resetImages() {
        images.reset();
        for(JImage image : images.getElements()) {
            image.removeImage();
            image.setVisible(false);
        }
    }

    public void load(String path) throws IOException {
        JImage jImage = images.getNext();

        File imageFile = new File(path);
        BufferedImage image = ImageIO.read(imageFile);

        if(image == null) {
            throw new IOException("Image is null");
        }

        jImage.setImage(image);
        jImage.setVisible(true);
    }
}
