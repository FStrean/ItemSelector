package ru.app.project.design;

import java.awt.*;

public class BasicSettings {
    public static GridBagConstraints getDefaultGridBagLayout() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        return constraints;
    }
}
