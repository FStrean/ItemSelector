package ru.app.project.design.impl;

import ru.app.project.components.RelativeLayout;
import ru.app.project.design.interf.ISelectCDBuilder;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.cards.panels.iSelect.*;

import javax.swing.*;
import java.awt.*;

public class BasicISelectCDBuilder implements ISelectCDBuilder {
    private final JPanel panel;
    private final JPanel contentPanelH;
    private final JPanel contentPanelV;
    public BasicISelectCDBuilder(JPanel panel) {
        this.panel = panel;
        this.contentPanelH = new JPanel();
        this.contentPanelV = new JPanel();
        RelativeLayout mainLayout = new RelativeLayout(RelativeLayout.Y_AXIS, 5);
        RelativeLayout contentLayoutH = new RelativeLayout(RelativeLayout.X_AXIS, 5);
        RelativeLayout contentLayoutV = new RelativeLayout(RelativeLayout.Y_AXIS, 5);

        contentLayoutH.setFill(true);
        contentLayoutV.setFill(true);
        mainLayout.setFill(true);
        this.panel.setBackground(Color.WHITE);
        this.panel.setLayout(mainLayout);
        this.contentPanelH.setOpaque(false);
        this.contentPanelH.setLayout(contentLayoutH);
        this.contentPanelV.setOpaque(false);
        this.contentPanelV.setLayout(contentLayoutV);
    }

    @Override
    public StaticPanel buildHeaderPanelDesign() {
        HeaderP hp = new HeaderP();

        panel.add(hp, 10.0f);

        return hp;
    }

    @Override
    public StaticPanel buildUnderHeaderPanelDesign() {
        UnderHeaderP uhp = new UnderHeaderP();

        contentPanelV.add(uhp, 20.0f);
        panel.add(contentPanelV, 80.0f);

        return uhp;
    }

    @Override
    public StaticPanel buildLeftPanelDesign() {
        LeftP ip = new LeftP();

        contentPanelH.add(ip, 50.0f);
        contentPanelV.add(contentPanelH, 80.f);

        return ip;
    }

    @Override
    public StaticPanel buildRightPanelDesign() {
        RightP dp = new RightP();

        contentPanelH.add(dp, 50.0f);

        return dp;
    }


    @Override
    public StaticPanel buildFooterPanelDesign() {
        FooterP fp = new FooterP();

        panel.add(fp, 10.0f);

        return fp;
    }

    @Override
    public void paint(Graphics g) {

    }
}
