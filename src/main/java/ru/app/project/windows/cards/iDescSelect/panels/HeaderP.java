package ru.app.project.windows.cards.iDescSelect.panels;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.IDescSelectCInfoCfg;
import ru.app.project.design.iDescSelect.impl.panels.BasicHeaderPDBuilder;
import ru.app.project.design.iDescSelect.interf.panels.HeaderPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.desc.DescC;
import ru.app.project.windows.cards.selector.SelectC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HeaderP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final HeaderPDBuilder designBuilder;
    private IDescSelectCInfoCfg cfg;
    private MutableComponent parent;

    private JButton btn1;
    private JLabel desc;
    private JButton btn2;

    private Double descRatio = null;
    private Double btnRatio = null;

    public HeaderP() {
        this.designBuilder = new BasicHeaderPDBuilder(this);

        this.rootWin = null;
        this.cfg = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        btn1 = designBuilder.buildJButtonDesign();
        desc = designBuilder.buildJLabelDesign();
        btn2 = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic(){
        btn1.addActionListener(event -> rootWin.showCard(DescC.class));
        btn2.addActionListener(event -> rootWin.showCard(SelectC.class));

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
    public void setParent(MutableComponent parent) {
        this.parent = parent;
    }

    @Override
    public void applyConfig() {
        btn1.setText(cfg.getLButton());
        desc.setText(cfg.getHHeader());
        btn2.setText(cfg.getRButton());
    }

    @Override
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (IDescSelectCInfoCfg) cfg;
    }
}
