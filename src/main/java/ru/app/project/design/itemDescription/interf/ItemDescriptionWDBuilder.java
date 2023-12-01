package ru.app.project.design.itemDescription.interf;

import ru.app.project.windows.itemDescription.panels.ImagesP;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;

public interface ItemDescriptionWDBuilder {
    JPanel buildDescriptionPanelDesign();
    ImagesP buildImagePanelDesign();
    EmbeddedMediaPlayerComponent buildVideoPlayerPanelDesign();
}
