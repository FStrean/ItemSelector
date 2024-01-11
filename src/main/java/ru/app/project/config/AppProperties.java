package ru.app.project.config;

public class AppProperties {
    private static final int winW = (int)((double)SystemProperties.getScreenWidth() / 1.3);
    private static final int winH = (int)((double)SystemProperties.getScreenHeight() / 1.3);
    public static int getWinW() {
        return winW;
    }
    public static int getWinH() {
        return winH;
    }
    public static String getConfigFolderPath() {
        return "config";
    }
    public static int getNumberOfItemsInItemDescriptionWindow() {
        return 15;
    }
    public static int getMaxNumberOfImagesInItemDescriptionWindow() {
        return 3;
    }
    public static int getMaxNumberOfVideosInItemDescriptionWindow() {
        return 2;
    }
}
