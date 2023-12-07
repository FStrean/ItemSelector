package ru.app.project.config.window;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.app.project.config.AppProperties;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public final class ItemDescriptionCStateConfig {
    private List<Item> items;
    private String button;
    private String description;

    public ItemDescriptionCStateConfig() {
        this.button = "";
        this.items = new ArrayList<>();
        for(int i = 0; i < AppProperties.getNumberOfItemsInItemDescriptionWindow(); i++) {
            this.items.add(new Item());
        }
        this.description = "";
    }

    @XmlElement(name = "item")
    public List<Item> getItems() {
        return items;
    }

    public static class Item {
        private int id;
        private String description;
        private List<String> images;
        private List<String> videos;

        private static int id_count = 1;


        public Item() {
            this.id = id_count++;
            this.description = "";

            this.images = new ArrayList<>();
            for (int i = 0; i < AppProperties.getMaxNumberOfImagesInItemDescriptionWindow(); i++) {
                this.images.add("");
            }

            this.videos = new ArrayList<>();
            for (int i = 0; i < AppProperties.getMaxNumberOfVideosInItemDescriptionWindow(); i++) {
                this.videos.add("");
            }
        }

        @XmlAttribute
        public int getId() {
            return id;
        }

        @XmlElement(name = "description")
        public String getDescription() {
            return description;
        }

        @XmlElement(name = "image")
        public List<String> getImages() {
            return images;
        }

        @XmlElement(name = "video")
        public List<String> getVideos() {
            return videos;
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

        public void setVideo(List<String> videos) {
            this.videos = videos;
        }
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    @XmlElement(name = "button")
    public String getButton() {
        return button;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
