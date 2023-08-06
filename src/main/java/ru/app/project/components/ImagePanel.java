package ru.app.project.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        image = null;
    }

    public ImagePanel(LayoutManager layout) {
        super(layout);
        image = null;
    }

    public ImagePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        image = null;
    }

    public ImagePanel() {
        image = null;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null) {
            int width = this.getWidth();
            int height = this.getHeight();

            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();

            double intermediateRationWidth = (double)imageWidth / width;
            double intermediateRationHeight = (double)imageHeight / height;

            double ration = Math.max(intermediateRationWidth, intermediateRationHeight);

            int newImageWidth = (int) (imageWidth / ration);
            int newImageHeight = (int) (imageHeight / ration);

            g.drawImage(image, 0, 0, newImageWidth, newImageHeight, this);
        }
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.repaint();
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
