package ru.app.project.design.impl.panels.mSelect;

import ru.app.project.components.RoundButton;
import ru.app.project.design.interf.panels.mSelect.ButtonsPDBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BasicButtonsPDBuilder implements ButtonsPDBuilder {
    private final JPanel panel;
    public BasicButtonsPDBuilder(JPanel panel) {
        this.panel = panel;

        this.panel.setOpaque(false);
        this.panel.setLayout(new GridLayout(0,1));
    }

    @Override
    public JButton buildJButtonDesign() {
        RoundButton btn = new RoundButton("", 40, Color.BLACK);
        JPanel p = new JPanel(new BorderLayout());

        btn.setForeground(Color.WHITE);
        p.setOpaque(false);
        p.setBorder(new EmptyBorder(15, 40, 15, 40));
        p.add(btn);

        panel.add(p);

        return btn;
    }
}
