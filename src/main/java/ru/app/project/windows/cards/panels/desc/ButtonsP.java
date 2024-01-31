package ru.app.project.windows.cards.panels.desc;

import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.DescCInfoCfg;
import ru.app.project.design.interf.panels.desc.ButtonsPDBuilder;
import ru.app.project.design.impl.panels.desc.BasicButtonsPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.template.StaticCard;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.root.RootWindow;
import ru.app.project.windows.cards.IDescSelectC;
import ru.app.project.windows.cards.SelectC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ButtonsP extends JPanel implements StaticPanel {
    private RootWindow rootWin;
    private final ButtonsPDBuilder designBuilder;
    private DescCInfoCfg cfg;
    private StaticCard parent;

    private JButton btn1;
    private JButton btn2;

    private Double btnRatio = null;

    public ButtonsP() {
        this.designBuilder = new BasicButtonsPDBuilder(this);

        this.rootWin = null;
        this.cfg = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        btn1 = designBuilder.buildJButtonDesign();
        btn2 = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic() {
        btn1.addActionListener(event -> rootWin.showCard(parent, IDescSelectC.class));
        btn2.addActionListener(event -> rootWin.showCard(parent, SelectC.class));

        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if(btnRatio == null) {
                        btnRatio = RelTSRatioCalc.getTextRatio(btn1);
                    }
                    TSCalc.calcTextSize(btn1, btnRatio);
                    TSCalc.calcTextSize(btn2, btnRatio);
                }
            });
        }
    }

    @Override
    public void runOnLeaveAction() {

    }

    @Override
    public void applyConfig() {
        btn1.setText(cfg.getButton1());
        btn2.setText(cfg.getButton2());
    }

    @Override
    public void setParent(StaticCard parent) {
        this.parent = parent;
    }

    @Override
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (DescCInfoCfg) cfg;
    }
}
