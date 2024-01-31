package ru.app.project.windows.cards.panels.iSelect;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.ISelectCInfoCfg;
import ru.app.project.design.impl.panels.iSelect.BasicFooterPDBuilder;
import ru.app.project.design.interf.panels.iSelect.FooterPDBuilder;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.utility.TSCalc;
import ru.app.project.windows.template.StaticCard;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.root.RootWindow;
import ru.app.project.windows.cards.ISelectSelectC;
import ru.app.project.windows.cards.MSelectC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FooterP extends JPanel implements StaticPanel {
    private RootWindow rootWin;
    private final FooterPDBuilder designBuilder;
    private ISelectCInfoCfg cfg;
    private StaticCard parent;

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
        btn.addActionListener(event -> rootWin.showCard(parent, ISelectSelectC.class));
        hBtn.addActionListener(event -> rootWin.showCard(parent, MSelectC.class));

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
    public void setParent(StaticCard parent) {
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
