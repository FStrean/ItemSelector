package ru.app.project.utility;

import ru.app.project.config.AppProperties;

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
    private final Class<T> cfgObjClass;
    private T cfgObj;
    private final StringBuilder filename;

    public ConfigLoader(Class<T> cfgObjClass) {
        this.cfgObjClass = cfgObjClass;
        this.filename = new StringBuilder(AppProperties.getCfgPath());
        this.load();
    }

    public T getCfg() {
        return cfgObj;
    }

    private void load() {
        File cf = new File(filename.append("/").append(cfgObjClass.getSimpleName()).append(".xml").toString());
        if(!cf.exists()) {
            JOptionPane.showMessageDialog(null,
                    "Отсутствует конфигурационный файл: " + cf.getAbsolutePath() + "\n" +
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

        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(cfgObjClass);
            Unmarshaller um = jc.createUnmarshaller();

            cfgObj = cfgObjClass.cast(um.unmarshal(cf));
        }
        catch (JAXBException e) {
            JOptionPane.showMessageDialog(null,
                    "Ошибка при распознавании конфигурационного файла: " + e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToFile() {
        try {
            JAXBContext co = JAXBContext.newInstance(cfgObjClass);
            Marshaller mo = co.createMarshaller();
            mo.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mo.marshal(cfgObj, new FileOutputStream(filename.toString()));
        } catch (JAXBException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Не удалось сохранить конфигурационный файл после создания: " + e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadObject() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> c = cfgObjClass.getConstructor();
        cfgObj = c.newInstance();
    }
}
