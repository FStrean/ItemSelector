package ru.app.project.config.cards;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.app.project.config.AppProperties;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ISelectCInfoCfg {
    private String hHeaderStyle;
    private String descStyle;
    private String leftDesc1Style;
    private String leftDesc2Style;
    private String rightDesc1Style;
    private String rightDesc2Style;
    private List<Item> items;
    private String button;
    private String fHeader;

    public ISelectCInfoCfg() {
        this.hHeaderStyle = "";
        this.descStyle = "";
        this.leftDesc1Style = "";
        this.leftDesc2Style = "";
        this.rightDesc1Style = "";
        this.rightDesc2Style = "";
        this.items = new ArrayList<>();
        for(int i = 0; i < AppProperties.getNumOfItemsInISelectSelect(); i++) {
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

    @XmlElement(name = "leftDesc1Style")
    public String getLeftDesc1Style() {
        return leftDesc1Style;
    }

    @XmlElement(name = "leftDesc2Style")
    public String getLeftDesc2Style() {
        return leftDesc2Style;
    }

    @XmlElement(name = "rightDesc1Style")
    public String getRightDesc1Style() {
        return rightDesc1Style;
    }

    @XmlElement(name = "rightDesc2Style")
    public String getRightDesc2Style() {
        return rightDesc2Style;
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
        private String desc;
        private String leftDesc1;
        private String leftImg1;
        private String leftDesc2;
        private String leftImg2;
        private String rightDesc1;
        private String rightImg1;
        private String rightDesc2;
        private String rightImg2;
        private static int id_count = 1;

        public Item() {
            this.id = id_count++;
            this.hHeader = "";
            this.desc = "";
            this.leftDesc1 = "";
            this.leftImg1 = "";
            this.leftDesc2 = "";
            this.leftImg2 = "";
            this.rightDesc1 = "";
            this.rightImg1 = "";
            this.rightDesc2 = "";
            this.rightImg2 = "";
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

        @XmlElement(name = "leftDesc1")
        public String getLeftDesc1() {
            return leftDesc1;
        }

        @XmlElement(name = "leftImg1")
        public String getLeftImg1() {
            return leftImg1;
        }

        @XmlElement(name = "leftDesc2")
        public String getLeftDesc2() {
            return leftDesc2;
        }

        @XmlElement(name = "leftImg2")
        public String getLeftImg2() {
            return leftImg2;
        }

        @XmlElement(name = "rightDesc1")
        public String getRightDesc1() {
            return rightDesc1;
        }

        @XmlElement(name = "rightImg1")
        public String getRightImg1() {
            return rightImg1;
        }

        @XmlElement(name = "rightDesc2")
        public String getRightDesc2() {
            return rightDesc2;
        }

        @XmlElement(name = "rightImg2")
        public String getRightImg2() {
            return rightImg2;
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

        public void setLeftDesc1(String leftDesc1) {
            this.leftDesc1 = leftDesc1;
        }

        public void setLeftImg1(String leftImg1) {
            this.leftImg1 = leftImg1;
        }

        public void setLeftDesc2(String leftDesc2) {
            this.leftDesc2 = leftDesc2;
        }

        public void setLeftImg2(String leftImg2) {
            this.leftImg2 = leftImg2;
        }

        public void setRightDesc1(String rightDesc1) {
            this.rightDesc1 = rightDesc1;
        }

        public void setRightImg1(String rightImg1) {
            this.rightImg1 = rightImg1;
        }

        public void setRightDesc2(String rightDesc2) {
            this.rightDesc2 = rightDesc2;
        }

        public void setRightImg2(String rightImg2) {
            this.rightImg2 = rightImg2;
        }
    }

    public void setHHeaderStyle(String hHeaderStyle) {
        this.hHeaderStyle = hHeaderStyle;
    }

    public void setDescStyle(String descStyle) {
        this.descStyle = descStyle;
    }

    public void setLeftDesc1Style(String leftDesc1Style) {
        this.leftDesc1Style = leftDesc1Style;
    }

    public void setLeftDesc2Style(String leftDesc2Style) {
        this.leftDesc2Style = leftDesc2Style;
    }

    public void setRightDesc1Style(String rightDesc1Style) {
        this.rightDesc1Style = rightDesc1Style;
    }

    public void setRightDesc2Style(String rightDesc2Style) {
        this.rightDesc2Style = rightDesc2Style;
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
