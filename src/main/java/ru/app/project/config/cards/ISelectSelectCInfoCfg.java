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
public class ISelectSelectCInfoCfg {
    @XmlElement(name = "hHeader")
    private String hHeader;
    @XmlElement(name = "image")
    private List<String> images;
    @XmlElement(name = "selectButton")
    private List<String> selectButtons;
    @XmlElement(name = "btnHeader")
    private String btnHeader;
    @XmlElement(name = "button")
    private String button;
    @XmlElement(name = "fHeader")
    private String fHeader;
    public ISelectSelectCInfoCfg() {
        this.hHeader = "";
        this.images = new ArrayList<>();
        for (int i = 0; i < AppProperties.getMaxNumOfImgInISelectSelect(); i++) {
            this.images.add("");
        }
        this.btnHeader = "";
        this.selectButtons = new ArrayList<>();
        for (int i = 0; i < AppProperties.getNumOfItemsInISelectSelect(); i++) {
            this.selectButtons.add("");
        }
        this.button = "";
        this.fHeader = "";
    }

    public String getHHeader() {
        return hHeader;
    }

    public List<String> getImages() {
        return images;
    }

    public String getBtnHeader() {
        return btnHeader;
    }

    public List<String> getSelectButtons() {
        return selectButtons;
    }

    public String getButton() {
        return button;
    }

    public String getFHeader() {
        return fHeader;
    }

    public void setHHeader(String hHeader) {
        this.hHeader = hHeader;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setBtnHeader(String btnHeader) {
        this.btnHeader = btnHeader;
    }

    public void setSelectButtons(List<String> selectButtons) {
        this.selectButtons = selectButtons;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public void setFHeader(String fHeader) {
        this.fHeader = fHeader;
    }
}
