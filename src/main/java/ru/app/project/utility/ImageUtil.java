package ru.app.project.utility;

import ru.app.project.components.JImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    private final JImage jImage;
    private String path;

    public ImageUtil() {
        this.jImage = new JImage();
        this.path = null;
    }

    public void loadImage(String path) throws IOException {
        this.path = path;
        File imageFile = new File(path);
        BufferedImage image = ImageIO.read(imageFile);

        if(image == null) {
            throw new IOException("Image is null");
        }

        jImage.setImage(image);
    }

    public void clearImage() {
        jImage.setImage(null);
        path = null;
    }

    public JImage getImageBasicPanel() {
        return jImage;
    }

    public String getPath() {
        return path;
    }
}
