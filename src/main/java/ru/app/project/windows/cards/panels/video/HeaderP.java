package ru.app.project.windows.cards.panels.video;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.VideoCInfoCfg;
import ru.app.project.design.impl.panels.video.BasicHeaderPDBuilder;
import ru.app.project.design.interf.panels.video.HeaderPDBuilder;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.utility.TSCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.VideoC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HeaderP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final HeaderPDBuilder designBuilder;
    private VideoCInfoCfg cfg;
    private MutableComponent parent;

    private JImageButton lBtn;
    private JLabel desc;
    private JImageButton rBtn;

    private Double descRatio = null;

    public HeaderP() {
        designBuilder = new BasicHeaderPDBuilder(this);

        this.rootWin = null;
        this.cfg = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        this.lBtn = designBuilder.buildJButton1Design();
        this.desc = designBuilder.buildJLabelDesign();
        this.rBtn = designBuilder.buildJButton2Design();
    }

    @Override
    public void applyLogic() {
        lBtn.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWin.showCard(VideoC.class, -1);
        });
        rBtn.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWin.showCard(VideoC.class, 1);
        });
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
    public void runOnLeaveAction() {

    }

    @Override
    public void setParent(MutableComponent parent) {
        this.parent = parent;
    }

    @Override
    public void applyConfig() {
        desc.setText(cfg.getHHeader());
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
