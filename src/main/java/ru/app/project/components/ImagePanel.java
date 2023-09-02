package ru.app.project.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {
    private BufferedImage image = null;
    private String path = null;
    public ImagePanel() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null) {
            int panelWidth = this.getWidth();
            int panelHeight = this.getHeight();

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

    public String getPath() {
        return path;
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
