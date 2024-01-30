package ru.app.project.config.cards;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class MSelectCInfoCfg {
    private String hHeader;
    private String button1;
    private String button2;
    private String button3;
    private String fHeader;

    public MSelectCInfoCfg() {
        this.hHeader = "";
        this.button1 = "";
        this.button2 = "";
        this.button3 = "";
        this.fHeader = "";
    }

    @XmlElement(name = "hHeader")
    public String getHHeader() {
        return hHeader;
    }

    @XmlElement(name = "button1")
    public String getButton1() {
        return button1;
    }

    @XmlElement(name = "button2")
    public String getButton2() {
        return button2;
    }

    @XmlElement(name = "button3")
    public String getButton3() {
        return button3;
    }

    @XmlElement(name = "fHeader")
    public String getFHeader() {
        return fHeader;
    }

    public void setHHeader(String hHeader) {
        this.hHeader = hHeader;
    }

    public void setButton1(String button1) {
        this.button1 = button1;
    }

    public void setButton2(String button2) {
        this.button2 = button2;
    }

    public void setButton3(String button3) {
        this.button3 = button3;
    }

    public void setFHeader(String fHeader) {
        this.fHeader = fHeader;
    }
}
