package ru.app.project.config.cards;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DescCInfoCfg {
    @XmlElement(name = "hHeader")
    private String hHeader;
    @XmlElement(name = "button1")
    private String button1;
    @XmlElement(name = "button2")
    private String button2;
    @XmlElement(name = "desc")
    private String desc;
    @XmlElement(name = "fHeader")
    private String fHeader;

    public DescCInfoCfg() {
        hHeader = "";
        button1 = "";
        button2 = "";
        desc = "";
        fHeader = "";
    }

    public String getHHeader() {
        return hHeader;
    }

    public String getButton1() {
        return button1;
    }

    public String getButton2() {
        return button2;
    }

    public String getDesc() {
        return desc;
    }

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

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setFHeader(String fHeader) {
        this.fHeader = fHeader;
    }
}
