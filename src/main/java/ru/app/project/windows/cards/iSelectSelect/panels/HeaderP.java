package ru.app.project.windows.cards.iSelectSelect.panels;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.ISelectSelectCInfoCfg;
import ru.app.project.design.iSelectSelect.impl.panels.BasicHeaderPDBuilder;
import ru.app.project.design.iSelectSelect.interf.panels.HeaderPDBuilder;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.utility.TSCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HeaderP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final HeaderPDBuilder designBuilder;
    private ISelectSelectCInfoCfg cfg;
    private MutableComponent parent;

    private JLabel desc;

    private Double descRatio = null;

    private int id;

    public HeaderP() {
        this.designBuilder = new BasicHeaderPDBuilder(this);

        this.cfg = null;
        this.rootWin = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        desc = designBuilder.buildJLabelDesign();
    }

    @Override
    public void applyLogic(){
        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descRatio == null) {
                        descRatio = RelTSRatioCalc.getTextRatio(desc);
                    }
                    TSCalc.calcTextSize(desc, descRatio);
                }
            });
        }
    }

    @Override
    public void applyConfig() {
        desc.setText(cfg.getHHeader());
    }

    @Override
    public void runOnLeaveAction() {

    }

    @Override
    public void setParent(MutableComponent parent) {
        this.parent = parent;
    }

    @Override
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (ISelectSelectCInfoCfg) cfg;
    }
}
