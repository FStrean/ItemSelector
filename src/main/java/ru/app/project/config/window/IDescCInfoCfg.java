package ru.app.project.config.window;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.app.project.config.AppProperties;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public final class IDescCInfoCfg {
    private String hHeaderStyle;
    private String descStyle;
    private List<Item> items;
    private String button;
    private String fHeader;

    public IDescCInfoCfg() {
        this.hHeaderStyle = "";
        this.descStyle = "";
        this.items = new ArrayList<>();
        for(int i = 0; i < AppProperties.getNumOfItemsInIDesc(); i++) {
            this.items.add(new Item());
        }
        this.button = "";
        this.fHeader = "";
    }

    @XmlElement(name = "hHeaderStyle")
    public String getHHeaderStyle() {
        return hHeaderStyle;
    }

    @XmlElement(name = "descStyle")
    public String getDescStyle() {
        return descStyle;
    }

    @XmlElement(name = "item")
    public List<Item> getItems() {
        return items;
    }

    @XmlElement(name = "button")
    public String getButton() {
        return button;
    }

    @XmlElement(name = "fHeader")
    public String getFHeader() {
        return fHeader;
    }

    public static class Item {
        private int id;
        private String hHeader;
        private List<String> images;
        private String desc;
        private static int id_count = 1;


        public Item() {
            this.id = id_count++;
            this.hHeader = "";
            this.desc = "";
            this.images = new ArrayList<>();
            for (int i = 0; i < AppProperties.getMaxNumOfImgInIDesc(); i++) {
                this.images.add("");
            }
        }

        @XmlAttribute
        public int getId() {
            return id;
        }

        @XmlElement(name = "hHeader")
        public String getHHeader() {
            return hHeader;
        }

        @XmlElement(name = "desc")
        public String getDesc() {
            return desc;
        }

        @XmlElement(name = "image")
        public List<String> getImages() {
            return images;
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

        public void setImages(List<String> images) {
            this.images = images;
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
