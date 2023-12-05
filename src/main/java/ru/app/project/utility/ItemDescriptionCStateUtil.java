package ru.app.project.utility;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.ItemDescriptionWStateConfig;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ItemDescriptionCStateUtil {
    private ItemDescriptionWStateConfig itemDescriptionWStateConfig;
    private final String configFileName;

    private final StringBuilder filename;

    public ItemDescriptionCStateUtil(String configFileName) {
        filename = new StringBuilder(AppProperties.getConfigFolderPath());
        this.configFileName = configFileName;
        this.itemDescriptionWStateConfig = loadFromFile();
    }

    public ItemDescriptionWStateConfig.Item load(int id) {
        return itemDescriptionWStateConfig.getItems().stream()
                .filter(listItem -> listItem.getId() == id).findFirst()
                .orElse(new ItemDescriptionWStateConfig.Item());
    }

    private ItemDescriptionWStateConfig loadFromFile() {
        File configFile = new File(filename.append("/").append(configFileName).toString());
        if(!configFile.exists()) {
            JOptionPane.showMessageDialog(null,
                    "Отсутствует конфигурационный файл: " + configFile.getAbsolutePath() + "\n" +
                            "Был создан новый пустой файл автоматически",
                    "Предупреждение", JOptionPane.WARNING_MESSAGE);
            itemDescriptionWStateConfig = getDefaultConfig();
            saveToFile();
            return itemDescriptionWStateConfig;
        }

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(ItemDescriptionWStateConfig.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            return (ItemDescriptionWStateConfig) jaxbUnmarshaller.unmarshal(configFile);
        }
        catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(ItemDescriptionWStateConfig.Item item) {
        itemDescriptionWStateConfig.getItems().stream()
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
            JAXBContext contextObj = JAXBContext.newInstance(ItemDescriptionWStateConfig.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(itemDescriptionWStateConfig, new FileOutputStream(filename.toString()));
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private ItemDescriptionWStateConfig getDefaultConfig() {
        return new ItemDescriptionWStateConfig();
    }
}
