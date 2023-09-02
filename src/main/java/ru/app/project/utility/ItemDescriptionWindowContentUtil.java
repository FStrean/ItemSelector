package ru.app.project.utility;

import ru.app.project.config.AppProperties;
import ru.app.project.config.ItemDescriptionWindowContentConfig;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class ItemDescriptionWindowContentUtil {
    private ItemDescriptionWindowContentConfig itemDescriptionWindowContentConfig;
    private final String configFileName;

    private final StringBuilder filename;

    public ItemDescriptionWindowContentUtil(String configFileName) {
        filename = new StringBuilder(AppProperties.getConfigFolderPath());
        this.configFileName = configFileName;
        this.itemDescriptionWindowContentConfig = loadFromFile();
    }

    public ItemDescriptionWindowContentConfig.Item load(int id) {
        return itemDescriptionWindowContentConfig.getItems().stream()
                .filter(listItem -> listItem.getId() == id).findFirst()
                .orElse(new ItemDescriptionWindowContentConfig.Item());
    }

    private ItemDescriptionWindowContentConfig loadFromFile() {
        File configFile = new File(filename.append("/").append(configFileName).toString());
        if(!configFile.exists()) {
            JOptionPane.showMessageDialog(null,
                    "Отсутствует конфигурационный файл: " + configFile.getAbsolutePath() + "\n" +
                            "Был создан новый пустой файл автоматически",
                    "Предупреждение", JOptionPane.WARNING_MESSAGE);
            itemDescriptionWindowContentConfig = getDefaultConfig();
            saveToFile();
            return itemDescriptionWindowContentConfig;
        }

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(ItemDescriptionWindowContentConfig.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            return (ItemDescriptionWindowContentConfig) jaxbUnmarshaller.unmarshal(configFile);
        }
        catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(ItemDescriptionWindowContentConfig.Item item) {
        itemDescriptionWindowContentConfig.getItems().stream()
                .filter(listItem -> listItem.getId() == item.getId()).findFirst()
                .ifPresent(listItem -> {
                    listItem.setId(item.getId());
                    listItem.setDescription(item.getDescription());
                    listItem.setImages(item.getImages());
                    listItem.setVideo(item.getVideo());
                });
        saveToFile();
    }

    private void saveToFile() {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(ItemDescriptionWindowContentConfig.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(itemDescriptionWindowContentConfig, new FileOutputStream(filename.toString()));
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private ItemDescriptionWindowContentConfig getDefaultConfig() {
        return new ItemDescriptionWindowContentConfig(
                List.of(
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item(),
                        new ItemDescriptionWindowContentConfig.Item()
                )
        );
    }
}
