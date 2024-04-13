package ru.app.project.config;

import ru.app.project.App;

import java.io.File;
import java.net.URISyntaxException;

public class AppProperties {
    //Window properties
    private static final int winW = (int)((double)SystemProperties.getScreenWidth() / 1.2);
    private static final int winH = (int)((double)SystemProperties.getScreenHeight() / 1.2);
    public static int getWinW() {
        return winW;
    }
    public static int getWinH() {
        return winH;
    }


    public static String getWorkingDirPath() {
        if (System.getProperty("java.home") == null) {
            String jarDirectory = "";
            try {
                String jarPath;
                jarPath = App.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
                File jarFile = new File(jarPath);
                jarDirectory = jarFile.getParent();
            } catch (URISyntaxException e) {
                System.out.println(e.getMessage());
            }

            return jarDirectory;
        } else {
            return ".";
        }
    }


    //Config properties
    private static final String configFolderPath = AppProperties.getWorkingDirPath() + "/config";
    public static String getCfgPath() {
        return configFolderPath;
    }


    //App properties
    //IDesc & IDescSelect
    private static final int numOfItemsInIDescSelect = 15;
    private static final int maxNumOfImgInIDesc = 3;
    public static int getNumOfItemsInIDescSelect() {
        return numOfItemsInIDescSelect;
    }
    public static int getMaxNumOfImgInIDesc() {
        return maxNumOfImgInIDesc;
    }

    //ISelect & ISelectSelect
    private static final int numOfItemsInISelectSelect = 5;
    private static final int[] numOfPagesInISelect = {1, 1, 1, 1, 4};
    private static final int maxNumOfImgInISelectSelect = 1;
    private static final int maxNumOfImgInISelect = 1;
    public static int getNumOfItemsInISelectSelect() {
        return numOfItemsInISelectSelect;
    }
    public static int[] getNumOfPagesInISelect() {
        return numOfPagesInISelect;
    }
    public static int getMaxNumOfImgInISelectSelect() {
        return maxNumOfImgInISelectSelect;
    }

    //Video
    private static final int numOfVideos = 19;
    private static final int maxNumOfVideosInScreen = 3;
    public static int getNumOfVidInVideo() {
        return numOfVideos;
    }
    public static int getMaxNumOfVidInScreen() {
        return maxNumOfVideosInScreen;
    }

    //Other properties
    public static boolean isTextDynamic() {
        return false;
    }
}
