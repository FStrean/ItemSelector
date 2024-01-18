package ru.app.project.windows.cards.iDesc.panels;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.IDescCInfoCfg;
import ru.app.project.design.iDesc.impl.panels.BasicDescriptionPDBuilder;
import ru.app.project.design.iDesc.interf.panels.DescriptionPDBuilder;
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
    private IDescCInfoCfg.Item cfg;
    private IDescCInfoCfg addCfg;
    private MutableComponent parent;
    private JLabel desc;

    private Double descRatio = null;

    public DescriptionP() {
        this.designBuilder = new BasicDescriptionPDBuilder(this);

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
    public void applyLogic() {
        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descRatio == null) {
                        descRatio = RelTSRatioCalc.getTextRatio(addCfg.getDescStyle(), desc.getWidth());
                    }
                    TSCalc.calcTextSize(desc, descRatio);
                }
            });
        }
    }

    @Override
    public void applyConfig() {
        desc.setText("<html>" + addCfg.getDescStyle() + cfg.getDesc() + "</html>");
        if(descRatio != null) {
            TSCalc.calcTextSize(desc, descRatio);
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
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (IDescCInfoCfg.Item) cfg;
    }

    public void setAddCfg(Object config) {
        this.addCfg = (IDescCInfoCfg)config;
    }
}
