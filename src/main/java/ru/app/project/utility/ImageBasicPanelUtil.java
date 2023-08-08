package ru.app.project.utility;

import ru.app.project.components.ImageBasicPanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageBasicPanelUtil {
    private final ImageBasicPanel imageBasicPanel;
    private String path;

    public ImageBasicPanelUtil(ImageBasicPanel image) {
        this.imageBasicPanel = image;
    }

    public void loadImage(String path) throws IOException {
        this.path = path;
        File imageFile = new File(path);
        BufferedImage image = ImageIO.read(imageFile);

        if(image == null) {
            throw new IOException("Image is null");
        }

        imageBasicPanel.setImage(image);
    }

    public ImageBasicPanel getImageBasicPanel() {
        return imageBasicPanel;
    }

    public String getPath() {
        return path;
    }
}
