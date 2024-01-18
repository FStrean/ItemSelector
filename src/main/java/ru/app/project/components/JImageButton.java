package ru.app.project.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.ImageObserver;

public class JImageButton extends JPanel {
    private JButton button;
    private final Image image;
    private final ImageObserver imageObserver;

    private final int imageWidth;
    private final int imageHeight;

    private int newImageWidth = -1;
    private int newImageHeight = -1;

    private int x = 0;
    private int y = 0;
    private float topRatio = 0.5f, leftRatio = 0.5f, bottomRatio = 0.5f, rightRatio = 0.5f;
    private int top = 0, left = 0, bottom = 0, right = 0;

    public JImageButton(String path){
        super();
        this.setOpaque(false);
        ImageIcon icon = new ImageIcon(path);
        this.image = icon.getImage();
        this.imageObserver = icon.getImageObserver();

        this.imageWidth = this.image.getWidth(this.imageObserver);
        this.imageHeight = this.image.getHeight(this.imageObserver);

        this.paintButton();
        this.initResizeLogic();

        this.setLayout(new BorderLayout());
        this.add(button);
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

    public void addActionListener(ActionListener l) {
        button.addActionListener(l);
    }

    private void paintButton() {
        button = new JButton() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setSize(new Dimension(newImageWidth, newImageHeight));
                if(!getModel().isArmed()) {
                    g.drawImage(image, x, y, newImageWidth, newImageHeight, imageObserver);
                }
            }
        };
    }

    private void initResizeLogic() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int panelWidth = JImageButton.this.getWidth();
                int panelHeight = JImageButton.this.getHeight();

                double intermediateImageWidthRatio;
                if (panelWidth == 0) {
                    intermediateImageWidthRatio = imageWidth;
                } else {
                    intermediateImageWidthRatio = (double) imageWidth / panelWidth;
                }

                double intermediateImageHeightRatio;
                if (panelHeight == 0) {
                    intermediateImageHeightRatio = imageHeight;
                } else {
                    intermediateImageHeightRatio = (double) imageHeight / panelHeight;
                }

                double imageRatio = Math.max(intermediateImageWidthRatio, intermediateImageHeightRatio);

                newImageWidth = Math.min((int) ((double) imageWidth / imageRatio), imageWidth);
                newImageHeight = Math.min((int) ((double) imageHeight / imageRatio), imageHeight);

                top = (int) ((float) (panelHeight - newImageHeight) * topRatio);
                left = (int) ((float) (panelWidth - newImageWidth) * leftRatio);
                bottom = (int) ((float) (panelHeight - newImageHeight) * bottomRatio);
                right = (int) ((float) (panelWidth - newImageWidth) * rightRatio);

                JImageButton.this.setBorder(new EmptyBorder(top, left, bottom, right));
                if(isVisible()) {
                    JImageButton.this.updateUI();
                }
            }

        });
    }
}
