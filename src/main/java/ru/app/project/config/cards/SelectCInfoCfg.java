package ru.app.project.config.cards;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SelectCInfoCfg {
    private String hHeader;
    private String desc;
    private String button1;
    private String button2;
    private String lButton1;
    private String lButton2;
    private String fHeader;

    public SelectCInfoCfg() {
        this.hHeader = "";
        this.desc = "";
        this.button1 = "";
        this.button2 = "";
        this.lButton1 = "";
        this.lButton2 = "";
        this.fHeader = "";
    }

    @XmlElement(name = "hHeader")
    public String getHHeader() {
        return hHeader;
    }

    @XmlElement(name = "desc")
    public String getDesc() {
        return desc;
    }

    @XmlElement(name = "button1")
    public String getButton1() {
        return button1;
    }

    @XmlElement(name = "button2")
    public String getButton2() {
        return button2;
    }

    @XmlElement(name = "lButton1")
    public String getLButton1() {
        return lButton1;
    }

    @XmlElement(name = "lButton2")
    public String getLButton2() {
        return lButton2;
    }
    @XmlElement(name = "fHeader")
    public String getFHeader() {
        return fHeader;
    }

    public void setHHeader(String hHeader) {
        this.hHeader = hHeader;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setButton1(String button1) {
        this.button1 = button1;
    }

    public void setButton2(String button2) {
        this.button2 = button2;
    }

    public void setLButton1(String lButton1) {
        this.lButton1 = lButton1;
    }

    public void setLButton2(String lButton2) {
        this.lButton2 = lButton2;
    }

    public void setFHeader(String fHeader) {
        this.fHeader = fHeader;
    }
}
