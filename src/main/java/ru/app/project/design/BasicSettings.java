package ru.app.project.design;

import java.awt.*;

public class BasicSettings {
    public static GridBagConstraints getDefaultGridBagLayout() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.BOTH;
        return constraints;
    }
}
