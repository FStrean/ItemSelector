package ru.app.project.config.window;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DescCInfoCfg {
    private String hHeader;
    private String button1;
    private String button2;
    private String desc;
    private String fHeader;

    public DescCInfoCfg() {
        hHeader = "";
        button1 = "";
        button2 = "";
        desc = "";
        fHeader = "";
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

    @XmlElement(name = "desc")
    public String getDesc() {
        return desc;
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

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setFHeader(String fHeader) {
        this.fHeader = fHeader;
    }
}
