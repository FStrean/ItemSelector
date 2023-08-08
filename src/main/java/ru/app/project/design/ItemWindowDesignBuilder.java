package ru.app.project.design;

import ru.app.project.components.FileChooserButton;
import ru.app.project.components.ImageBasicPanel;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;

public interface ItemWindowDesignBuilder {
    void buildDescriptionPanelDesign(JPanel descriptionPanel);
    void buildImageChooserButtonDesign(FileChooserButton imageChooserButton);
    void buildImageDesign(ImageBasicPanel imagePanel, int i);
    void buildVideoChooserButtonDesign(FileChooserButton videoChooserButton);
    void buildVideoPlayerDesign(EmbeddedMediaPlayerComponent videoPlayer);
    void defineInitialWindowSize();
}
