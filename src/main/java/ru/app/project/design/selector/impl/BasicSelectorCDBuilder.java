package ru.app.project.design.selector.impl;

import ru.app.project.design.selector.interf.SelectorCDBuilder;
import ru.app.project.components.RelativeLayout;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.cards.selector.panels.ButtonsP;
import ru.app.project.windows.cards.selector.panels.FooterP;
import ru.app.project.windows.cards.selector.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicSelectorCDBuilder implements SelectorCDBuilder {
    private final JPanel panel;
    public BasicSelectorCDBuilder(JPanel panel) {
        this.panel = panel;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);
        layout.setFill(true);
        this.panel.setLayout(layout);
    }

    @Override
    public BasicPanel buildHeaderPanelDesign() {
        HeaderP headerPanel = new HeaderP();
        panel.add(headerPanel, 15.0f);
        return headerPanel;
    }

    @Override
    public BasicPanel buildCenterPanelDesign() {
        ButtonsP buttonsPanel = new ButtonsP();
        panel.add(buttonsPanel, 55.0f);
        return buttonsPanel;
    }

    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP headerPanel = new FooterP();
        panel.add(headerPanel, 30.0f);
        return headerPanel;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = panel.getWidth(), h = panel.getHeight();
        Color color1 = Color.WHITE;
        Color color2 = Color.GRAY;
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);  // Изменены координаты здесь
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
