package ru.app.project.config.cards;

import jakarta.xml.bind.annotation.*;
import ru.app.project.config.AppProperties;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class IDescCInfoCfg {
    @XmlElement(name = "hHeaderStyle")
    private String hHeaderStyle;
    @XmlElement(name = "descStyle")
    private String descStyle;
    @XmlElement(name = "item")
    private List<Item> items;
    @XmlElement(name = "button")
    private String button;
    @XmlElement(name = "fHeader")
    private String fHeader;

    public IDescCInfoCfg() {
        this.hHeaderStyle = "";
        this.descStyle = "";
        this.items = new ArrayList<>();
        for(int i = 0; i < AppProperties.getNumOfItemsInIDescSelect(); i++) {
            this.items.add(new Item());
        }
        this.button = "";
        this.fHeader = "";
    }

    public String getHHeaderStyle() {
        return hHeaderStyle;
    }

    public String getDescStyle() {
        return descStyle;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getButton() {
        return button;
    }

    public String getFHeader() {
        return fHeader;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Item {
        @XmlAttribute
        private int id;
        @XmlElement(name = "hHeader")
        private String hHeader;
        @XmlElement(name = "desc")
        private String desc;
        @XmlElement(name = "descRatio")
        private String descRatio;
        @XmlElement(name = "image")
        private List<String> images;
        @XmlElement(name = "imagesRatio")
        private String imagesRatio;

        private static int id_count = 1;


        public Item() {
            this.id = id_count++;
            this.hHeader = "";
            this.desc = "";
            this.descRatio = "";
            this.images = new ArrayList<>();
            for (int i = 0; i < AppProperties.getMaxNumOfImgInIDesc(); i++) {
                this.images.add("");
            }
            this.imagesRatio = "";
        }

        public int getId() {
            return id;
        }

        public String getHHeader() {
            return hHeader;
        }

        public String getDesc() {
            return desc;
        }

        public String getDescRatio() {
            return descRatio;
        }

        public List<String> getImages() {
            return images;
        }

        public String getImagesRatio() {
            return imagesRatio;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setHHeader(String hHeader) {
            this.hHeader = hHeader;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setDescRatio(String descRatio) {
            this.descRatio = descRatio;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public void setImagesRatio(String imagesRatio) {
            this.imagesRatio = imagesRatio;
        }
    }
    public void setHHeaderStyle(String hHeaderStyle) {
        this.hHeaderStyle = hHeaderStyle;
    }

    public void setDescStyle(String descStyle) {
        this.descStyle = descStyle;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public void setFHeader(String fHeader) {
        this.fHeader = fHeader;
    }
}
