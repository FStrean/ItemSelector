package ru.app.project.config.window;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SelectorCStateConfig {
    private String hDescription;
    private String description;
    private String button1;
    private String button2;
    private String leftButton1;
    private String leftButton2;
    private String fDescription;

    public SelectorCStateConfig() {
        this.hDescription = "";
        this.description = "";
        this.button1 = "";
        this.button2 = "";
        this.leftButton1 = "";
        this.leftButton2 = "";
        this.fDescription = "";
    }

    @XmlElement(name = "hDescription")
    public String getHDescription() {
        return hDescription;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    @XmlElement(name = "button1")
    public String getButton1() {
        return button1;
    }

    @XmlElement(name = "button2")
    public String getButton2() {
        return button2;
    }

    @XmlElement(name = "leftButton1")
    public String getLeftButton1() {
        return leftButton1;
    }

    @XmlElement(name = "leftButton2")
    public String getLeftButton2() {
        return leftButton2;
    }
    @XmlElement(name = "fDescription")
    public String getFDescription() {
        return fDescription;
    }

    public void setHDescription(String hDescription) {
        this.hDescription = hDescription;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setButton1(String button1) {
        this.button1 = button1;
    }

    public void setButton2(String button2) {
        this.button2 = button2;
    }

    public void setLeftButton1(String leftButton1) {
        this.leftButton1 = leftButton1;
    }

    public void setLeftButton2(String leftButton2) {
        this.leftButton2 = leftButton2;
    }

    public void setFDescription(String fDescription) {
        this.fDescription = fDescription;
    }
}
