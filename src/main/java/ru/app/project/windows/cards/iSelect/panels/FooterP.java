package ru.app.project.windows.cards.iSelect.panels;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.window.ISelectCInfoCfg;
import ru.app.project.design.iSelect.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.iSelect.interf.panels.FooterPDBuilder;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.utility.TSCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.iSelectSelect.ISelectSelectC;
import ru.app.project.windows.cards.mSelect.MSelectC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final FooterPDBuilder designBuilder;
    private ISelectCInfoCfg cfg;
    private MutableComponent parent;

    private JButton btn;
    private JLabel desc;
    private JImageButton hBtn;


    private Double btnRatio = null;
    private Double descRatio = null;

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
            rootWin.showCard(ISelectSelectC.class);
        });
        hBtn.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWin.showCard(MSelectC.class);
        });

        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descRatio == null) {
                        btnRatio = RelTSRatioCalc.getTextRatio(btn);
                        descRatio = RelTSRatioCalc.getTextRatio(desc);
                    }
                    TSCalc.calcTextSize(desc, descRatio);
                    TSCalc.calcTextSize(btn, btnRatio);
                }
            });
        }
    }

    @Override
    public void applyConfig() {
        desc.setText(cfg.getFHeader());
        btn.setText(cfg.getButton());
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
        this.cfg = (ISelectCInfoCfg) cfg;
    }
}
