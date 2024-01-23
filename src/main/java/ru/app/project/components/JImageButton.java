package ru.app.project.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.ImageObserver;

public class JImageButton extends JPanel {
    public static final int LINE_START = 0;
    public static final int CENTER = 1;
    public static final int LINE_END = 2;

    private JButton btn;
    private final Image img;
    private final ImageObserver imgObs;

    private final int imgWidth;
    private final int imgHeight;

    private int newImgWidth = -1;
    private int newImgHeight = -1;

    private final int x = 0;
    private final int y = 0;
    private float tRatio = 0.5f, lRatio = 0.5f, bRatio = 0.5f, rRatio = 0.5f;
    private int tPad = 0, lPad = 0, bPad = 0, rPad = 0;

    public JImageButton(String path){
        super();
        this.setOpaque(false);
        ImageIcon icon = new ImageIcon(path);
        this.img = icon.getImage();
        this.imgObs = icon.getImageObserver();

        this.imgWidth = this.img.getWidth(this.imgObs);
        this.imgHeight = this.img.getHeight(this.imgObs);

        this.paintButton();
        this.initResizeLogic();

        this.setLayout(new BorderLayout());
        this.add(btn);
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

    public void addActionListener(ActionListener l) {
        btn.addActionListener(l);
    }

    private void paintButton() {
        btn = new JButton() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setSize(new Dimension(newImgWidth, newImgHeight));
                if(!getModel().isArmed()) {
                    g.drawImage(img, x, y, newImgWidth, newImgHeight, imgObs);
                }
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setStroke(new BasicStroke(3f));
                if (getModel().isRollover()) {
                    g2.setColor(UIManager.getColor("Button.shadow"));
                } else if(getModel().isArmed()) {
                    g2.setColor(Color.GRAY);
                    btn.setContentAreaFilled(true);
                } else {
                    g2.setColor(new Color(0, 0, 0, 0));
                }

                g2.drawRect(x, y, getWidth(), getHeight());
                g2.dispose();
            }
        };
        btn.setContentAreaFilled(false);
    }

    private void initResizeLogic() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int pWidth = JImageButton.this.getWidth();
                int pHeight = JImageButton.this.getHeight();

                double wRatio;
                if (pWidth == 0) {
                    wRatio = imgWidth;
                } else {
                    wRatio = (double) imgWidth / pWidth;
                }

                double hRatio;
                if (pHeight == 0) {
                    hRatio = imgHeight;
                } else {
                    hRatio = (double) imgHeight / pHeight;
                }

                double imgRatio = Math.max(wRatio, hRatio);

                newImgWidth = Math.min((int) ((double) imgWidth / imgRatio), imgWidth);
                newImgHeight = Math.min((int) ((double) imgHeight / imgRatio), imgHeight);

                tPad = (int) ((float) (pHeight - newImgHeight) * tRatio);
                lPad = (int) ((float) (pWidth - newImgWidth) * lRatio);
                bPad = (int) ((float) (pHeight - newImgHeight) * bRatio);
                rPad = (int) ((float) (pWidth - newImgWidth) * rRatio);

                JImageButton.this.setBorder(new EmptyBorder(tPad, lPad, bPad, rPad));
                if(isVisible()) {
                    JImageButton.this.updateUI();
                }
            }

        });
    }
}
