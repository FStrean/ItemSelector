package ru.app.project.windows.cards.panels.select;

import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.SelectCInfoCfg;
import ru.app.project.design.impl.panels.select.BasicButtonsPDBuilder;
import ru.app.project.design.interf.panels.select.ButtonsPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.template.StaticCard;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.root.RootWindow;
import ru.app.project.windows.cards.ISelectSelectC;
import ru.app.project.windows.cards.VideoC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ButtonsP extends JPanel implements StaticPanel {
    private RootWindow rootWin;
    private final ButtonsPDBuilder designBuilder;
    private SelectCInfoCfg cfg;
    private StaticCard parent;

    private JLabel desc;
    private JButton btn1;
    private JButton btn2;

    private Double descRatio = null;
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
        desc = designBuilder.buildDescription();
        btn1 = designBuilder.buildJButtonDesign();
        btn2 = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic() {
        btn1.addActionListener(event -> rootWin.showCard(parent, ISelectSelectC.class));
        btn2.addActionListener(event -> rootWin.showCard(parent, VideoC.class, 0));

        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descRatio == null) {
                        descRatio = RelTSRatioCalc.getTextRatio(desc);
                        btnRatio = RelTSRatioCalc.getTextRatio(btn1);
                    }
                    TSCalc.calcTextSize(desc, descRatio);
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
    public void setParent(StaticCard parent) {
        this.parent = parent;
    }

    @Override
    public void applyConfig() {
        desc.setText(cfg.getDesc());
        btn1.setText(cfg.getButton1());
        btn2.setText(cfg.getButton2());
    }

    @Override
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (SelectCInfoCfg) cfg;
    }
}
