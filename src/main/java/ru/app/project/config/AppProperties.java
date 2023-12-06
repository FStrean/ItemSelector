package ru.app.project.config;

import ru.app.project.config.window.ItemDescriptionWStateConfig;

public class AppProperties {
    public static String getConfigFolderPath() {
        return "config";
    }

    public static String getItemWindowContentConfigName() {
        return ItemDescriptionWStateConfig.class.getSimpleName() + ".xml";
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
