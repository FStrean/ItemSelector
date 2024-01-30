package ru.app.project.config.cards;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.app.project.config.AppProperties;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class IDescSelectCInfoCfg {
    private String lButton;
    private String hHeader;
    private String rButton;
    private List<String> buttons;
    private String fHeader;

    public IDescSelectCInfoCfg() {
        this.lButton = "";
        this.hHeader = "";
        this.rButton = "";

        this.buttons = new ArrayList<>();
        for (int i = 0; i < AppProperties.getNumOfItemsInIDescSelect(); i++) {
            this.buttons.add("");
        }

        this.fHeader = "";
    }
    @XmlElement(name = "lButton")
    public String getLButton() {
        return lButton;
    }

    @XmlElement(name = "hHeader")
    public String getHHeader() {
        return hHeader;
    }

    @XmlElement(name = "rButton")
    public String getRButton() {
        return rButton;
    }

    @XmlElement(name = "button")
    public List<String> getButtons() {
        return buttons;
    }

    @XmlElement(name = "fHeader")
    public String getFHeader() {
        return fHeader;
    }

    public void setLButton(String lButton) {
        this.lButton = lButton;
    }

    public void setHHeader(String hHeader) {
        this.hHeader = hHeader;
    }

    public void setRButton(String rButton) {
        this.rButton = rButton;
    }

    public void setButtons(List<String> buttons) {
        this.buttons = buttons;
    }

    public void setFHeader(String fHeader) {
        this.fHeader = fHeader;
    }
}
