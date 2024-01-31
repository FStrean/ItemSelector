package ru.app.project.windows.cards.panels.iSelect;

import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.ISelectCInfoCfg;
import ru.app.project.design.impl.panels.iSelect.BasicUnderHeaderPDBuilder;
import ru.app.project.design.interf.panels.iSelect.UnderHeaderPDBuilder;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.utility.TSCalc;
import ru.app.project.windows.root.RootWindow;
import ru.app.project.windows.template.DynamicCard;
import ru.app.project.windows.template.DynamicPanel;
import ru.app.project.windows.template.StaticCard;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class UnderHeaderP extends JPanel implements DynamicPanel {
    private RootWindow rootWin;
    private final UnderHeaderPDBuilder designBuilder;
    private ISelectCInfoCfg.Item cfg;
    private ISelectCInfoCfg addCfg;
    private DynamicCard parent;

    private JLabel desc;

    private Double descRatio = null;
    public UnderHeaderP() {
        this.designBuilder = new BasicUnderHeaderPDBuilder(this);

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
                        descRatio = RelTSRatioCalc.getTextRatio(addCfg.getDescStyle(), desc.getWidth());
                    }
                    TSCalc.calcTextSize(desc, descRatio);
                }
            });
        }
    }

    @Override
    public void applyConfig() {
        if(!cfg.getDesc().isEmpty()) {
            desc.setText("<html>" + addCfg.getDescStyle() + cfg.getDesc() + "</html>");
        }

        setVisible(!cfg.getDesc().isEmpty());

        if(descRatio != null) {
            TSCalc.calcTextSize(desc, descRatio);
        }
    }

    @Override
    public void runOnLeaveAction() {

    }

    @Override
    public void setParent(StaticCard parent) {
        this.parent = (DynamicCard) parent;
    }

    @Override
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (ISelectCInfoCfg.Item) cfg;
    }

    @Override
    public void setAddCfg(Object config) {
        this.addCfg = (ISelectCInfoCfg)config;
    }
}
