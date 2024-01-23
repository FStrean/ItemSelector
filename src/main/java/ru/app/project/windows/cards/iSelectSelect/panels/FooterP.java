package ru.app.project.windows.cards.iSelectSelect.panels;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.window.ISelectSelectCInfoCfg;
import ru.app.project.design.iSelectSelect.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.iSelectSelect.interf.panels.FooterPDBuilder;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.utility.TSCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.mSelect.MSelectC;
import ru.app.project.windows.cards.select.SelectC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final FooterPDBuilder designBuilder;
    private ISelectSelectCInfoCfg cfg;
    private MutableComponent parent;

    private JButton btn;
    private JLabel desc;
    private JImageButton hBtn;


    private Double btnTRatio = null;
    private Double descTRatio = null;

    public FooterP() {
        this.designBuilder = new BasicFooterPDBuilder(this);

        this.cfg = null;
        this.rootWin = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        btn = designBuilder.buildJButton1Design();
        desc = designBuilder.buildJLabelDesign();
        hBtn = designBuilder.buildJButton2Design();
    }

    @Override
    public void applyLogic(){
        btn.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWin.showCard(SelectC.class);
        });
        hBtn.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWin.showCard(MSelectC.class);
        });

        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descTRatio == null) {
                        btnTRatio = RelTSRatioCalc.getTextRatio(btn);
                        descTRatio = RelTSRatioCalc.getTextRatio(desc);
                    }
                    TSCalc.calcTextSize(desc, descTRatio);
                    TSCalc.calcTextSize(btn, btnTRatio);
                }
            });
        }
    }

    @Override
    public void applyConfig() {
        btn.setText(cfg.getButton());
        desc.setText(cfg.getFHeader());
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
