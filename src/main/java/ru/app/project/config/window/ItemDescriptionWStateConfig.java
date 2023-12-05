package ru.app.project.config.window;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.app.project.config.AppProperties;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public final class ItemDescriptionWStateConfig {
    private final List<Item> items;

    public ItemDescriptionWStateConfig() {
        this.items = new ArrayList<>();

        for(int i = 0; i < AppProperties.getNumberOfItemsInItemDescriptionWindow(); i++) {
            items.add(new Item());
        }
    }

    @XmlElement(name = "item")
    public List<Item> getItems() {
        return items;
    }

    public static class Item {
        private int id;
        private String description;
        private List<String> images;
        private String video;

        private static int id_count = 1;


        public Item() {
            this.id = id_count++;
            this.description = "";
            this.images = new ArrayList<>();
            for (int i = 0; i < AppProperties.getMaxNumberOfImagesInItemDescriptionWindow(); i++) {
                this.images.add("");
            }
            this.video = "";
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
