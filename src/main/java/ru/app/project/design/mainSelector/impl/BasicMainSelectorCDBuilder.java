package ru.app.project.design.mainSelector.impl;

import ru.app.project.design.mainSelector.interf.MainSelectorCDBuilder;
import ru.app.project.components.RelativeLayout;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.cards.mainSelector.panels.ButtonsP;
import ru.app.project.windows.cards.mainSelector.panels.FooterP;
import ru.app.project.windows.cards.mainSelector.panels.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicMainSelectorCDBuilder implements MainSelectorCDBuilder {
    private final JPanel panel;
    public BasicMainSelectorCDBuilder(JPanel panel) {
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
        JPanel jPanel1 = new JPanel();
        jPanel1.setOpaque(false);
        JPanel jPanel2 = new JPanel();
        jPanel2.setOpaque(false);
        panel.add(jPanel1, 15.0f);
        panel.add(buttonsPanel, 50.0f);
        panel.add(jPanel2, 10.0f);
        return buttonsPanel;
    }

    @Override
    public BasicPanel buildFooterPanelDesign() {
        FooterP footerPanel = new FooterP();
        panel.add(footerPanel, 10.0f);
        return footerPanel;
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
