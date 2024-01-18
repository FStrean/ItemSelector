package ru.app.project.config;

public class AppProperties {
    private static final int winW = (int)((double)SystemProperties.getScreenWidth() / 1.2);
    private static final int winH = (int)((double)SystemProperties.getScreenHeight() / 1.2);
    private static final String configFolderPath = "config";
    public static int getWinW() {
        return winW;
    }
    public static int getWinH() {
        return winH;
    }
    public static String getConfigFolderPath() {
        return configFolderPath;
    }
    public static int getNumOfItemsInIDesc() {
        return 15;
    }
    public static int getMaxNumOfImgInItemDescription() {
        return 3;
    }
    public static int getMaxNumOfVidInItemDescription() {
        return 2;
    }
    public static boolean isDynamicTextSizeOn() {
        return true;
    }
}
