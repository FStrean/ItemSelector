package ru.app.project.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImage extends JPanel {
    private BufferedImage image = null;
    public JImage() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();

            double intermediateImageWidthRatio = (double)imageWidth / panelWidth;
            double intermediateImageHeightRatio = (double)imageHeight / panelHeight;

            double imageRatio = Math.max(intermediateImageWidthRatio, intermediateImageHeightRatio);

            int newImageWidth = (int) (imageWidth / imageRatio);
            int newImageHeight = (int) (imageHeight / imageRatio);

            g.drawImage(image, 0, 0, newImageWidth, newImageHeight, this);
        }
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.repaint();
    }

    public void removeImage() {
        this.setImage(null);
    }

    public BufferedImage getImage() {
        return image;
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
