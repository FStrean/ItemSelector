package ru.app.project;

import com.sun.jna.NativeLibrary;
import ru.app.project.config.AppProperties;
import ru.app.project.windows.root.RootWindowImpl;
import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.Properties;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        if (System.getProperty("java.home") == null) {
            System.out.println("No Java Home set, assuming that we are running from GraalVM. Fixing...");
            System.setProperty("user.home", new File(AppProperties.getWorkingDirPath()).getAbsolutePath());
            if(System.getProperty("os.name").equals("Linux")) {
                App.renameFontConfigFiles();
            }
            System.setProperty("java.home", new File(AppProperties.getWorkingDirPath() + "/lib/libjvm").getAbsolutePath());
        }
        RootWindowImpl mainWindow = null;
        try {
            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), AppProperties.getWorkingDirPath() + "/lib/libvlc_win_x64");
            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), AppProperties.getWorkingDirPath() + "/lib/libvlc_astra_x64");
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

    private static String getVersionString(File f) {
        try (Scanner sc  = new Scanner(f)) {
            return sc.findInLine("(\\d)+((\\.)(\\d)+)*");
        } catch (Exception ignored) {
        }
        return null;
    }

    private static void renameFontConfigFiles() {
        String osName = "";
        String osVersion = "";
        try {
            File f;
            if ((f = new File("/etc/lsb-release")).canRead()) {
                Properties props = new Properties();
                props.load(new FileInputStream(f));
                osName = props.getProperty("DISTRIB_ID");
                osVersion =  props.getProperty("DISTRIB_RELEASE");
            } else if ((f = new File("/etc/redhat-release")).canRead()) {
                osName = "RedHat";
                osVersion = getVersionString(f);
            } else if ((f = new File("/etc/SuSE-release")).canRead()) {
                osName = "SuSE";
                osVersion = getVersionString(f);
            } else if ((f = new File("/etc/turbolinux-release")).canRead()) {
                osName = "Turbo";
                osVersion = getVersionString(f);
            } else if ((f = new File("/etc/fedora-release")).canRead()) {
                osName = "Fedora";
                osVersion = getVersionString(f);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        osName = osName.substring(1, osName.length() - 1);

        String hostname;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostname = "localhost";
        }
        String userDir = ".";
        String version = System.getProperty("java.version");
        String fs = File.separator;
        String dir = userDir+fs+".java"+fs+"fonts"+fs+version;
        String name_ru = "fcinfo-1-"+hostname+"-"+
                osName+"-"+osVersion+"-"+"ru-RU"+".properties";
        String name_en = "fcinfo-1-"+hostname+"-"+
                osName+"-"+osVersion+"-"+"en-"+".properties";
        String ru = dir+fs+name_ru;
        String en = dir+fs+name_en;
        String directoryPath = ".java/fonts/21.0.2/";
        File directory = new File(directoryPath);
        if(directory.exists()) {
            File[] files = directory.listFiles();
            if(files == null) {
                return;
            }
            if(!files[0].getName().equals(ru) && !files[0].getName().equals(en)) {
                File newFile = new File(ru);
                if (files[0].renameTo(newFile)) {
                    System.out.println("Renamed file to " + files[0].getName());
                }
            }
            if(!files[1].getName().equals(ru) && !files[1].getName().equals(en)) {
                File newFile = new File(en);
                if (files[1].renameTo(newFile)) {
                    System.out.println("Renamed file to " + files[1].getName());
                }
            }
        }
    }
}