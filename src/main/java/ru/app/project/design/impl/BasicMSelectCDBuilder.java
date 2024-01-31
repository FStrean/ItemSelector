package ru.app.project.design.impl;

import ru.app.project.design.interf.MSelectCDBuilder;
import ru.app.project.components.RelativeLayout;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.cards.panels.mSelect.ButtonsP;
import ru.app.project.windows.cards.panels.mSelect.FooterP;
import ru.app.project.windows.cards.panels.mSelect.HeaderP;

import javax.swing.*;
import java.awt.*;

public class BasicMSelectCDBuilder implements MSelectCDBuilder {
    private final JPanel panel;
    public BasicMSelectCDBuilder(JPanel panel) {
        this.panel = panel;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);

        layout.setFill(true);
        this.panel.setLayout(layout);
    }

    @Override
    public StaticPanel buildHeaderPanelDesign() {
        HeaderP hp = new HeaderP();

        panel.add(hp, 15.0f);

        return hp;
    }

    @Override
    public StaticPanel buildCenterPanelDesign() {
        ButtonsP bp = new ButtonsP();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p1.setOpaque(false);
        p2.setOpaque(false);

        panel.add(p1, 15.0f);
        panel.add(bp, 50.0f);
        panel.add(p2, 10.0f);

        return bp;
    }

    @Override
    public StaticPanel buildFooterPanelDesign() {
        FooterP fp = new FooterP();

        panel.add(fp, 10.0f);

        return fp;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Color c1 = Color.WHITE, c2 = Color.GRAY;
        int w = panel.getWidth(), h = panel.getHeight();
        GradientPaint gp = new GradientPaint(0, 0, c1, 0, h, c2);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
