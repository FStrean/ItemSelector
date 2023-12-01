package ru.app.project;

import ru.app.project.config.AppProperties;
import ru.app.project.windows.itemDescriptionSelector.ItemDescriptionSelectorW;

import javax.swing.*;
import java.io.File;

public class App
{
    public static void main( String[] args ) {
        App.createFolders();
        ItemDescriptionSelectorW window = new ItemDescriptionSelectorW(AppProperties.getMainWindowName());
    }

    private static void createFolders() {
        File configPath = new File(AppProperties.getConfigFolderPath());
        if(configPath.mkdirs()) {
            JOptionPane.showMessageDialog(null,
                    "Отсутствует путь: " + configPath.getAbsolutePath() + "\n" +
                    "Был создан новый путь автоматически",
                    "Предупреждение", JOptionPane.WARNING_MESSAGE);
        }
    }
}
