package ru.app.project.windows.cards.desc.panels;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.DescCInfoCfg;
import ru.app.project.design.desc.impl.panels.BasicDescriptionPDBuilder;
import ru.app.project.design.desc.interf.panels.DescriptionPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DescriptionP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final DescriptionPDBuilder designBuilder;
    private DescCInfoCfg cfg;
    private MutableComponent parent;

    private JLabel desc;

    private Double descRatio = null;

    public DescriptionP() {
        designBuilder = new BasicDescriptionPDBuilder(this);

        this.rootWin = null;
        this.cfg = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        this.desc = designBuilder.buildJLabelDesign();
    }

    @Override
    public void applyLogic() {
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
        desc.setText(cfg.getDesc());
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
