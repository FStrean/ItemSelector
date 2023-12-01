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
        return ItemDescriptionWStateConfig.class.getSimpleName() + ".xml";
    }

    public static int getNumberOfButtonsInItemDescriptionSelectorWindow() {
        return 15;
    }

    public static int getMaxNumberOfImagesInItemDescriptionWindow() {
        return 3;
    }

    public static int getMaxNumberOfVideosInItemDescriptionWindow() {
        return 2;
    }
}
