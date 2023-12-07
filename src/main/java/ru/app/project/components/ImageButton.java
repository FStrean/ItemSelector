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

        int dimWidth = getWidth();
        int dimHeight = getHeight();
        if(getWidth() != newImageWidth) {
            dimWidth = newImageWidth;
        }
//        if(getHeight() > newImageHeight) {
//            dimHeight = newImageHeight;
//        }

        setSize(new Dimension(dimWidth, dimHeight));
        super.paintComponent(g);
        g.drawImage(image,  0 , 0 , newImageWidth , newImageHeight , imageObserver);
    }
}
