package ru.app.project.utility;

import ru.app.project.config.ItemWindowConfig;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ItemWindowStateUtil {
    private final String configFileName;

    public ItemWindowStateUtil(String configFileName) {
        this.configFileName = configFileName;
    }

    public ItemWindowConfig.Item load(int id) {
        ItemWindowConfig itemWindowConfig = load();
        return itemWindowConfig.getItems().stream()
                .filter(listItem -> listItem.getId() == id).findFirst()
                .orElse(new ItemWindowConfig.Item());
    }

    public ItemWindowConfig load() {
        File configFile = new File(configFileName);

        if(!configFile.exists()) {
            ItemWindowConfig itemWindowConfig = new ItemWindowConfig(
                    List.of(
                        new ItemWindowConfig.Item(1, new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(2, new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(3, new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(4, new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(5, new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(6, new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(7, new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(8, new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(9, new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(10, new ArrayList<>(), "")
                    )
            );

            saveToFile(itemWindowConfig);
            return itemWindowConfig;
        }

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(ItemWindowConfig.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            return (ItemWindowConfig) jaxbUnmarshaller.unmarshal(configFile);
        }
        catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(ItemWindowConfig.Item item) {
        ItemWindowConfig itemWindowConfig = load();
        itemWindowConfig.getItems().stream()
                .filter(listItem -> listItem.getId() == item.getId()).findFirst()
                .ifPresent(listItem -> {
                    listItem.setId(item.getId());
                    listItem.setImages(item.getImages());
                    listItem.setVideo(item.getVideo());
                });
        saveToFile(itemWindowConfig);
    }

    private void saveToFile(ItemWindowConfig itemWindowConfig) {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(ItemWindowConfig.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(itemWindowConfig, new FileOutputStream(configFileName));
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
