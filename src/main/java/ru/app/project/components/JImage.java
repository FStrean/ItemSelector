package ru.app.project.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

public class JImage extends JPanel {
    public static final int LINE_START = 0;
    public static final int CENTER = 1;
    public static final int LINE_END = 2;

    private BufferedImage img = null;

    private JPanel imgPanel;

    private final int x = 0;
    private final int y = 0;
    private float tRatio = 0.5f, lRatio = 0.5f, bRatio = 0.5f, rRatio = 0.5f;
    private int tPad = 0, lPad = 0, bPad = 0, rPad = 0;

    private int imgWidth;
    private int imgHeight;
    private int newImgWidth = -1;
    private int newImgHeight = -1;
    public JImage() {
        this.paintImage();
        this.initResizeLogic();

        this.imgPanel.setOpaque(false);
        this.setOpaque(false);

        this.setLayout(new BorderLayout());
        this.add(imgPanel);
    }

    public void setImg(BufferedImage img) {
        this.img = img;
        this.imgPanel.repaint();

        if(img != null) {
            imgWidth = img.getWidth();
            imgHeight = img.getHeight();
        }
    }

    public void removeImage() {
        this.setImg(null);
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setAlign(int xAlign, int yAlign) {
        switch (xAlign) {
            case LINE_START -> {
                lRatio = 0.0f;
                rRatio = 1.0f;
            }
            case CENTER -> {
                lRatio = 0.5f;
                rRatio = 0.5f;
            }
            case LINE_END -> {
                lRatio = 1.0f;
                rRatio = 0.0f;
            }
        }

        switch (yAlign) {
            case LINE_START -> {
                tRatio = 0.0f;
                bRatio = 1.0f;
            }
            case CENTER -> {
                tRatio = 0.5f;
                bRatio = 0.5f;
            }
            case LINE_END -> {
                tRatio = 1.0f;
                bRatio = 0.0f;
            }
        }
    }

    private void paintImage() {
        imgPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, x, y, newImgWidth, newImgHeight, this);
            }
        };
    }

    private void initResizeLogic() {
        addComponentListener(
                new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        if(img != null) {
                            int panWidth = getWidth();
                            int panHeight = getHeight();

                            double wRatio = (double) imgWidth / panWidth;
                            double hRatio = (double) imgHeight / panHeight;

                            double imgRatio = Math.max(wRatio, hRatio);

                            newImgWidth = Math.min((int) ((double) imgWidth / imgRatio), imgWidth);
                            newImgHeight = Math.min((int) ((double) imgHeight / imgRatio), imgHeight);

                            tPad = (int) ((float) (panHeight - newImgHeight) * tRatio);
                            lPad = (int) ((float) (panWidth - newImgWidth) * lRatio);
                            bPad = (int) ((float) (panHeight - newImgHeight) * bRatio);
                            rPad = (int) ((float) (panWidth - newImgWidth) * rRatio);

                            JImage.this.setBorder(new EmptyBorder(tPad, lPad, bPad, rPad));

                            if(JImage.this.isVisible()) {
                                JImage.this.updateUI();
                            }
                        }
                    }
                }
        );
    }
}
