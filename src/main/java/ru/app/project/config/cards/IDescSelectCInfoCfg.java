package ru.app.project.config.cards;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.app.project.config.AppProperties;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class IDescSelectCInfoCfg {
    @XmlElement(name = "lButton")
    private String lButton;
    @XmlElement(name = "hHeader")
    private String hHeader;
    @XmlElement(name = "rButton")
    private String rButton;
    @XmlElement(name = "button")
    private List<String> buttons;
    @XmlElement(name = "fHeader")
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
    public String getLButton() {
        return lButton;
    }

    public String getHHeader() {
        return hHeader;
    }

    public String getRButton() {
        return rButton;
    }

    public List<String> getButtons() {
        return buttons;
    }

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
