package ru.app.project;

import com.sun.jna.NativeLibrary;
import ru.app.project.config.AppProperties;
import ru.app.project.windows.root.RootWindowImpl;
import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil;

import javax.swing.*;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class App {
    public static void main(String[] args) throws UnknownHostException {
        if (System.getProperty("java.home") == null) {
            System.out.println("No Java Home set, assuming that we are running from GraalVM. Fixing...");

            App.renameFontConfigFiles();
            System.setProperty("user.home", new File(".").getAbsolutePath());
            System.setProperty("java.home", new File("./lib/libjvm").getAbsolutePath());
        }
        RootWindowImpl mainWindow = null;
        try {
            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "./lib/libvlc_win64");
            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "./lib/libvlc_astra");
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

    private static void renameFontConfigFiles() throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostName();
        String directoryPath = ".java/fonts/21.0.2/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        for (File file : files) {
            String fileName = file.getName();

            int firstDashIndex = fileName.indexOf("-", 8);
            fileName = fileName.substring(0, firstDashIndex + 1) + hostname + fileName.substring(fileName.indexOf("-", firstDashIndex + 1));

            File newFile = new File(directoryPath + fileName);
            if (file.renameTo(newFile)) {
                System.out.println("Файл " + file.getName() + " успешно переименован.");
            } else {
                System.out.println("Не удалось переименовать файл " + file.getName() + ".");
            }
        }
    }
}
