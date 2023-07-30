package ru.app.project.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImagePanel extends JPanel {
    private final ArrayList<BufferedImage> images = new ArrayList<>();

    public ImagePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public ImagePanel(LayoutManager layout) {
        super(layout);
    }

    public ImagePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public ImagePanel() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(images.size() != 0) {
            int width = this.getWidth();
            int height = this.getHeight() / images.size();

            int imageNumber = 0;
            for (var image : images) {
                int imageWidth = image.getWidth();
                int imageHeight = image.getHeight();

                int intermediateRationWidth = (int)Math.ceil((double)imageWidth / width);
                int intermediateRationHeight = (int)Math.ceil((double)imageHeight / height);

                int ration = Math.max(intermediateRationWidth, intermediateRationHeight);

                int newImageWidth = imageWidth / ration;
                int newImageHeight = imageHeight / ration;
                g.drawImage(image, 0, height * imageNumber, newImageWidth, newImageHeight, this);

                imageNumber++;
            }
        }
    }

    public void addImage(BufferedImage image) {
        images.add(image);
    }

    @Override
    public Component add(Component component) {
        throw new UnsupportedOperationException("Method access forbidden");
    }

    @Override
    public Component add(String name, Component comp) {
        throw new UnsupportedOperationException("Method access forbidden");
    }

    @Override
    public Component add(Component comp, int index) {
        throw new UnsupportedOperationException("Method access forbidden");
    }

    @Override
    public void add(Component comp, Object constraints) {
        throw new UnsupportedOperationException("Method access forbidden");
    }

    @Override
    public void add(Component comp, Object constraints, int index) {
        throw new UnsupportedOperationException("Method access forbidden");
    }
}
