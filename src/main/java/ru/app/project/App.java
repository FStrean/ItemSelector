package ru.app.project;

import com.sun.jna.NativeLibrary;
import ru.app.project.config.AppProperties;
import ru.app.project.windows.root.RootWindowImpl;
import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil;

import javax.swing.*;
import java.io.File;

public class App {
    public static void main(String[] args) {
        RootWindowImpl mainWindow = null;
        try {
            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "./lib/win64");
            App.createFolders();
            mainWindow = new RootWindowImpl("Multimedia-Software");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainWindow, e.getMessage(),
                    "Unknown error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void createFolders() {
        File configPath = new File(AppProperties.getCfgPath());
        if(configPath.mkdirs()) {
            JOptionPane.showMessageDialog(null,
                    "Отсутствует путь: " + configPath.getAbsolutePath() + "\n" +
                    "Был создан новый путь автоматически",
                    "Предупреждение", JOptionPane.WARNING_MESSAGE);
        }
    }
}
