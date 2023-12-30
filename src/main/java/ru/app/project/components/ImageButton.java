package ru.app.project.components;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

public class ImageButton extends JPanel {
    private final JButton button;
    private final Image image;
    private final ImageObserver imageObserver;

    private final int imageWidth;
    private final int imageHeight;

    public ImageButton(String path){
        super();
        ImageIcon icon = new ImageIcon(path);
        this.image = icon.getImage();
        this.imageObserver = icon.getImageObserver();

        this.imageWidth = this.image.getWidth(this.imageObserver);
        this.imageHeight = this.image.getHeight(this.imageObserver);

        button = new JButton() {
            @Override
            public void paintComponent(Graphics g) {
                int panelWidth = ImageButton.this.getWidth();
                int panelHeight = ImageButton.this.getHeight();

                double intermediateImageWidthRatio = (double)imageWidth / panelWidth;
                double intermediateImageHeightRatio = (double)imageHeight / panelHeight;

                double imageRatio = Math.max(intermediateImageWidthRatio, intermediateImageHeightRatio);

                double widthPadding = (double)panelWidth / (10 * imageRatio);
                double heightPadding = (double) panelHeight / (10 * imageRatio);

                int newImageWidth = (int) ((double)imageWidth / imageRatio - widthPadding);
                int newImageHeight = (int) ((double)imageHeight / imageRatio - heightPadding);

                setSize(new Dimension(newImageWidth, newImageHeight));

                super.paintComponent(g);
                int x = 0;
                int y = 0;
                g.drawImage(image,  x , y , newImageWidth , newImageHeight , imageObserver);
            }
        };

        this.setLayout(new BorderLayout());
        this.add(button);
    }

    public void addActionListener(ActionListener l) {
        button.addActionListener(l);
    }
}
