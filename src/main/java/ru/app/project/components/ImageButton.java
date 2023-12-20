package ru.app.project.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class ImageButton extends JButton {
    private final Image image;
    private final ImageObserver imageObserver;

    public ImageButton(String path){
        super();
        ImageIcon icon = new ImageIcon(path);
        image = icon.getImage();
        imageObserver = icon.getImageObserver();
    }

    @Override
    public void paintComponent(Graphics g) {
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int imageWidth = image.getWidth(imageObserver);
        int imageHeight = image.getHeight(imageObserver);

        double intermediateImageWidthRatio = (double)imageWidth / panelWidth;
        double intermediateImageHeightRatio = (double)imageHeight / panelHeight;

        double imageRatio = Math.max(intermediateImageWidthRatio, intermediateImageHeightRatio);

        int newImageWidth = (int) (imageWidth / imageRatio);
        int newImageHeight = (int) (imageHeight / imageRatio);

        int size = getWidth();
        if(getWidth() != newImageWidth) {
            size = newImageWidth;
        }
        setSize(new Dimension(size, size));
        super.paintComponent(g);
        int x = 0;
        int y = 0;
        //y = (int)((double)(panelHeight - newImageWidth) / 2);
        g.drawImage(image,  x , y , newImageWidth , newImageHeight , imageObserver);
    }
}
