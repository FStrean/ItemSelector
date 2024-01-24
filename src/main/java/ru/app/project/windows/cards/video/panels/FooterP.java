package ru.app.project.windows.cards.video.panels;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.window.VideoCInfoCfg;
import ru.app.project.design.video.impl.panels.BasicFooterPDBuilder;
import ru.app.project.design.video.interf.panels.FooterPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.desc.DescC;
import ru.app.project.windows.cards.iDescSelect.IDescSelectC;
import ru.app.project.windows.cards.mSelect.MSelectC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FooterP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final FooterPDBuilder designBuilder;
    private VideoCInfoCfg cfg;
    private MutableComponent parent;


    private JButton lBtn1;
    private JButton lBtn2;
    private JLabel desc;
    private JImageButton btn;

    private Double lBtnRatio = null;
    private Double descRatio = null;

    public FooterP() {
        this.designBuilder = new BasicFooterPDBuilder(this);

        this.rootWin = null;
        this.cfg = null;

        this.applyDesign();
        this.applyLogic();
    }
    @Override

    public void applyDesign() {
        lBtn1 = designBuilder.buildLeftButtonDesign();
        lBtn2 = designBuilder.buildLeftButtonDesign();
        desc = designBuilder.buildJLabelDesign();
        btn = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic(){
        lBtn1.addActionListener(event -> rootWin.showCard(IDescSelectC.class));
        lBtn2.addActionListener(event -> rootWin.showCard(DescC.class));
        btn.addActionListener(event -> rootWin.showCard(MSelectC.class));

        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descRatio == null) {
                        descRatio = RelTSRatioCalc.getTextRatio(desc);
                        lBtnRatio = RelTSRatioCalc.getTextRatio(lBtn1);
                    }
                    TSCalc.calcTextSize(desc, descRatio);
                    TSCalc.calcTextSize(lBtn1, lBtnRatio);
                    TSCalc.calcTextSize(lBtn2, lBtnRatio);
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
        lBtn1.setText(cfg.getButton1());
        lBtn2.setText(cfg.getButton2());
        desc.setText(cfg.getFHeader());
    }

    @Override
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (VideoCInfoCfg) cfg;
    }
}
