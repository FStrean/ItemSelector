package ru.app.project.config.window;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SelectorCStateConfig {
    private String hDescription;
    private String button1;
    private String button2;
    private String fDescription;

    public SelectorCStateConfig() {
        this.hDescription = "";
        this.button1 = "";
        this.button2 = "";
        this.fDescription = "";
    }

    @XmlElement(name = "hDescription")
    public String getHDescription() {
        return hDescription;
    }

    @XmlElement(name = "button1")
    public String getButton1() {
        return button1;
    }

    @XmlElement(name = "button2")
    public String getButton2() {
        return button2;
    }

    @XmlElement(name = "fDescription")
    public String getFDescription() {
        return fDescription;
    }

    public void setHDescription(String hDescription) {
        this.hDescription = hDescription;
    }

    public void setButton1(String button1) {
        this.button1 = button1;
    }

    public void setButton2(String button2) {
        this.button2 = button2;
    }

    public void setFDescription(String fDescription) {
        this.fDescription = fDescription;
    }
}
