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
                        new ItemWindowConfig.Item(1, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(2, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(3, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(4, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(5, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(6, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(7, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(8, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(9, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(10, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(11, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(12, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(13, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(14, getDescription(), new ArrayList<>(), ""),
                        new ItemWindowConfig.Item(15, getDescription(), new ArrayList<>(), "")
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
                    listItem.setDescription(item.getDescription());
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

    private String getDescription() {
        return """
                <html>
                    It is a long established fact that a reader will be distracted by the
                    readable content of a page when looking at its layout.
                    The point of using Lorem Ipsum is that it has a more-or-less normal
                    distribution of letters, as opposed to using 'Content here,
                    content here', making it look like readable English.
                    Many desktop publishing packages and web page editors<br>
                    now use Lorem Ipsum as their default model text, and a search for
                    'lorem ipsum' will uncover many web sites still in their infancy.
                    Various versions have evolved over the years, sometimes by accident,
                    sometimes on purpose (injected humour and the like).
                <html>
                """;
    }
}
