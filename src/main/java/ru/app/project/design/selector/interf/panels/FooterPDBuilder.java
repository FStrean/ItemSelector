package ru.app.project.design.selector.interf.panels;

import ru.app.project.components.ImageButton;

import javax.swing.*;

public interface FooterPDBuilder {
    JButton buildLeftButtonDesign();
    JLabel buildJLabelDesign();
    ImageButton buildJButtonDesign();
}
