package ru.app.project.utility;

import ru.app.project.components.ImagePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    private final ImagePanel imagePanel;
    private String path;

    public ImageUtil() {
        this.imagePanel = new ImagePanel();
        this.path = null;
    }

    public void loadImage(String path) throws IOException {
        this.path = path;
        File imageFile = new File(path);
        BufferedImage image = ImageIO.read(imageFile);

        if(image == null) {
            throw new IOException("Image is null");
        }

        imagePanel.setImage(image);
    }

    public void clearImage() {
        imagePanel.setImage(null);
        path = null;
    }

    public ImagePanel getImageBasicPanel() {
        return imagePanel;
    }

    public String getPath() {
        return path;
    }
}
