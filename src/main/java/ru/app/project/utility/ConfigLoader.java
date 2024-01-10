package ru.app.project.utility;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.ItemDescriptionCStateConfig;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConfigLoader<T> {
    private final Class<T> configObjectClass;
    private T configObject;
    private final StringBuilder filename;

    public ConfigLoader(Class<T> configObjectClass) {
        this.configObjectClass = configObjectClass;
        this.filename = new StringBuilder(AppProperties.getConfigFolderPath());
        this.load();
    }

    public T getConfig() {
        return configObject;
    }

    private void load() {
        File configFile = new File(filename.append("/").append(configObjectClass.getSimpleName()).append(".xml").toString());
        if(!configFile.exists()) {
            JOptionPane.showMessageDialog(null,
                    "Отсутствует конфигурационный файл: " + configFile.getAbsolutePath() + "\n" +
                            "Был создан новый пустой файл автоматически",
                    "Предупреждение", JOptionPane.WARNING_MESSAGE);
            try {
                loadObject();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Не удалось инициализировать конфигурационный файл: " + e.getMessage(),
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            saveToFile();
            return;
        }

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(configObjectClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            configObject = configObjectClass.cast(jaxbUnmarshaller.unmarshal(configFile));
        }
        catch (JAXBException e) {
            JOptionPane.showMessageDialog(null,
                    "Ошибка при распознавании конфигурационного файла: " + e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToFile() {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(configObjectClass);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(configObject, new FileOutputStream(filename.toString()));
        } catch (JAXBException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Не удалось сохранить конфигурационный файл после создания: " + e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadObject() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> constructor = configObjectClass.getConstructor();
        configObject = constructor.newInstance();
    }
}
