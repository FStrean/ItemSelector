package ru.app.project.config;

public class AppProperties {
    public static String getConfigFolderPath() {
        return "config";
    }

    public static String getItemWindowName() {
        return "Item Window";
    }

    public static String getMainWindowName() {
        return "Item Selector";
    }

    public static String getItemWindowContentConfigName() {
        return ItemDescriptionWindowContentConfig.class.getSimpleName() + ".xml";
    }

    public static int getMaxNumberOfImagesInItemWindow() {
        return 3;
    }

    public static int getMaxNumberOfVideosInItemWindow() {
        return 2;
    }
}
