package ru.app.project.design.impl;

import ru.app.project.design.interf.SelectCDBuilder;
import ru.app.project.components.RelativeLayout;
import ru.app.project.windows.StaticPanel;
import ru.app.project.windows.cards.panels.select.ButtonsP;
import ru.app.project.windows.cards.panels.select.FooterP;
import ru.app.project.windows.cards.panels.select.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicSelectCDBuilder implements SelectCDBuilder {
    private final JPanel panel;
    public BasicSelectCDBuilder(JPanel panel) {
        this.panel = panel;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);

        layout.setFill(true);
        this.panel.setLayout(layout);
    }

    @Override
    public StaticPanel buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP();

        panel.add(headerPanel, 15.0f);

        return headerPanel;
    }

    @Override
    public StaticPanel buildCenterPanelDesign() {
        ButtonsP buttonsPanel = new ButtonsP();

        panel.add(buttonsPanel, 55.0f);

        return buttonsPanel;
    }

    @Override
    public StaticPanel buildFooterPanelDesign() {
        FooterP headerPanel = new FooterP();

        panel.add(headerPanel, 30.0f);

        return headerPanel;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Color c1 = Color.WHITE, C2 = Color.GRAY;
        int w = panel.getWidth(), h = panel.getHeight();
        GradientPaint gp = new GradientPaint(0, 0, c1, 0, h, C2);  // Изменены координаты здесь

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
