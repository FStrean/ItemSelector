package ru.app.project.config;

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


    //Config properties
    private static final String configFolderPath = System.getProperty("user.dir") + "/config";
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
