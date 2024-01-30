package ru.app.project.design.impl.panels.iDescSelect;

import ru.app.project.components.RoundButton;
import ru.app.project.config.AppProperties;
import ru.app.project.design.interf.panels.iDescSelect.ButtonsPDBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BasicButtonsPDBuilder implements ButtonsPDBuilder {
    private JPanel panel;
    public BasicButtonsPDBuilder(JPanel panel) {
        this.panel = panel;

        this.panel.setOpaque(false);
        this.panel.setLayout(new GridLayout(0, AppProperties.getNumOfItemsInIDescSelect() / 3));
    }

    @Override
    public JButton buildJButtonDesign() {
        RoundButton button = new RoundButton("", 40, new Color(164, 164, 164));
        JPanel p = new JPanel(new BorderLayout());

        button.setForeground(Color.BLACK);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        p.setOpaque(false);
        p.setBorder(new EmptyBorder(15, 15, 15, 15));

        p.add(button);
        panel.add(p);

        return button;
    }
}
