package ru.app.project.design.select.interf.panels;

import ru.app.project.components.JImageButton;

import javax.swing.*;

public interface FooterPDBuilder {
    JButton buildLeftButtonDesign();
    JLabel buildJLabelDesign();
    JImageButton buildJButtonDesign();
}
