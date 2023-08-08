package ru.app.project.config;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public final class ItemWindowConfig {
    private List<Item> items = new ArrayList<>();

    public ItemWindowConfig() {
    }

    public ItemWindowConfig(List<Item> items) {
        this.items = items;
    }

    @XmlElement(name = "item")
    public List<Item> getItems() {
        return items;
    }

    public static class Item {
        private int id;
        private String description;
        private List<String> images = new ArrayList<>();
        private String video;

        public Item() {
        }

        public Item(int id, String description, List<String> images, String video) {
            this.id = id;
            this.description = description;
            this.images = images;
            this.video = video;
        }

        @XmlAttribute
        public int getId() {
            return id;
        }

        @XmlElement
        public String getDescription() {
            return description;
        }

        @XmlElement(name = "image")
        public List<String> getImages() {
            return images;
        }

        @XmlElement
        public String getVideo() {
            return video;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public void setVideo(String video) {
            this.video = video;
        }
    }
}
