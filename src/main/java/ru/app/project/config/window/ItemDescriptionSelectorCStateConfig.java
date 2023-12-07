package ru.app.project.config.window;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.app.project.config.AppProperties;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ItemDescriptionSelectorCStateConfig {
    private String leftButton;
    private String hDescription;
    private String rightButton;
    private List<String> buttons;
    private String fDescription;

    public ItemDescriptionSelectorCStateConfig() {
        this.leftButton = "";
        this.hDescription = "";
        this.rightButton = "";

        this.buttons = new ArrayList<>();
        for (int i = 0; i < AppProperties.getNumberOfItemsInItemDescriptionWindow(); i++) {
            this.buttons.add("");
        }

        this.fDescription = "";
    }
    @XmlElement(name = "leftButton")
    public String getLeftButton() {
        return leftButton;
    }

    @XmlElement(name = "hDescription")
    public String getHDescription() {
        return hDescription;
    }

    @XmlElement(name = "rightButton")
    public String getRightButton() {
        return rightButton;
    }

    @XmlElement(name = "button")
    public List<String> getButtons() {
        return buttons;
    }

    @XmlElement(name = "fDescription")
    public String getFDescription() {
        return fDescription;
    }

    public void setLeftButton(String leftButton) {
        this.leftButton = leftButton;
    }

    public void setHDescription(String hDescription) {
        this.hDescription = hDescription;
    }

    public void setRightButton(String rightButton) {
        this.rightButton = rightButton;
    }

    public void setButtons(List<String> buttons) {
        this.buttons = buttons;
    }

    public void setFDescription(String fDescription) {
        this.fDescription = fDescription;
    }
}
