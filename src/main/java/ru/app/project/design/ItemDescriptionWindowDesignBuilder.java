package ru.app.project.design;

import ru.app.project.windows.panels.ItemWindowImages;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;

public interface ItemDescriptionWindowDesignBuilder {
    JPanel buildDescriptionPanelDesign();
    ItemWindowImages buildImagePanelDesign();
    EmbeddedMediaPlayerComponent buildVideoPlayerPanelDesign();
}
