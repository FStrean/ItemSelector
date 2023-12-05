package ru.app.project.design;

import java.awt.*;

public class BasicSettings {
    public static GridBagConstraints getDefaultGridBagLayout() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 10;
        constraints.ipady = 10;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.LINE_START;

        return constraints;
    }
}
