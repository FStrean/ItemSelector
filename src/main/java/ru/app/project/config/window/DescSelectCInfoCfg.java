package ru.app.project.config.window;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.app.project.config.AppProperties;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class DescSelectCInfoCfg {
    private String hHeader;
    private List<String> images;
    private List<String> selectButtons;
    private String btnHeader;
    private String button;
    private String fHeader;
    public DescSelectCInfoCfg() {
        this.hHeader = "";
        this.images = new ArrayList<>();
        for (int i = 0; i < AppProperties.getMaxNumOfImgInDescSelect(); i++) {
            this.images.add("");
        }
        this.btnHeader = "";
        this.selectButtons = new ArrayList<>();
        for (int i = 0; i < AppProperties.getNumOfItemsInSelectDesc(); i++) {
            this.selectButtons.add("");
        }
        this.button = "";
        this.fHeader = "";
    }

    @XmlElement(name = "hHeader")
    public String getHHeader() {
        return hHeader;
    }

    @XmlElement(name = "image")
    public List<String> getImages() {
        return images;
    }

    @XmlElement(name = "btnHeader")
    public String getBtnHeader() {
        return btnHeader;
    }

    @XmlElement(name = "selectButton")
    public List<String> getSelectButtons() {
        return selectButtons;
    }

    @XmlElement(name = "button")
    public String getButton() {
        return button;
    }

    @XmlElement(name = "fHeader")
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
