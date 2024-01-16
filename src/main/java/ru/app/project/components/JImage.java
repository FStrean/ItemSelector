package ru.app.project.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

public class JImage extends JPanel {
    private BufferedImage image = null;

    private JPanel imagePanel;

    private int x = 0;
    private int y = 0;
    private float topRatio = 0.5f, leftRatio = 0.5f, bottomRatio = 0.5f, rightRatio = 0.5f;
    private int top = 0, left = 0, bottom = 0, right = 0;

    private int imageWidth;
    private int imageHeight;

    private int newImageWidth = -1;
    private int newImageHeight = -1;
    public JImage() {
        this.paintImage();
        this.initResizeLogic();

        this.imagePanel.setOpaque(false);
        this.setOpaque(false);

        this.setLayout(new BorderLayout());
        this.add(imagePanel);
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.imagePanel.repaint();

        if(image != null) {
            imageWidth = image.getWidth();
            imageHeight = image.getHeight();
        }
    }

    public void removeImage() {
        this.setImage(null);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setAlign(String xAlign, String yAlign) {
        switch (xAlign) {
            case BorderLayout.LINE_START -> {
                leftRatio = 0.0f;
                rightRatio = 1.0f;
            }
            case BorderLayout.CENTER -> {
                leftRatio = 0.5f;
                rightRatio = 0.5f;
            }
            case BorderLayout.LINE_END -> {
                leftRatio = 1.0f;
                rightRatio = 0.0f;
            }
        }

        switch (yAlign) {
            case BorderLayout.LINE_START -> {
                topRatio = 0.0f;
                bottomRatio = 1.0f;
            }
            case BorderLayout.CENTER -> {
                topRatio = 0.5f;
                bottomRatio = 0.5f;
            }
            case BorderLayout.LINE_END -> {
                topRatio = 1.0f;
                bottomRatio = 0.0f;
            }
        }
    }

    private void paintImage() {
        imagePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, x, y, newImageWidth, newImageHeight, this);
            }
        };
    }

    private void initResizeLogic() {
        addComponentListener(
                new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        if(image != null) {
                            int panelWidth = getWidth();
                            int panelHeight = getHeight();

                            double intermediateImageWidthRatio = (double)imageWidth / panelWidth;
                            double intermediateImageHeightRatio = (double)imageHeight / panelHeight;

                            double imageRatio = Math.max(intermediateImageWidthRatio, intermediateImageHeightRatio);

                            newImageWidth = Math.min((int) ((double) imageWidth / imageRatio), imageWidth);
                            newImageHeight = Math.min((int) ((double) imageHeight / imageRatio), imageHeight);

                            top = (int) ((float) (panelHeight - newImageHeight) * topRatio);
                            left = (int) ((float) (panelWidth - newImageWidth) * leftRatio);
                            bottom = (int) ((float) (panelHeight - newImageHeight) * bottomRatio);
                            right = (int) ((float) (panelWidth - newImageWidth) * rightRatio);

                            JImage.this.setBorder(new EmptyBorder(top, left, bottom, right));

                            if(JImage.this.isVisible()) {
                                JImage.this.updateUI();
                            }
                        }
                    }
                }
        );
    }
}
