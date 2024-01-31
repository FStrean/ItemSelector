package ru.app.project.windows.cards.panels.iDesc;

import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.IDescCInfoCfg;
import ru.app.project.design.impl.panels.iDesc.BasicDescriptionPDBuilder;
import ru.app.project.design.interf.panels.iDesc.DescriptionPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.*;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DescriptionP extends JPanel implements DynamicPanel {
    private RootWindow rootWin;
    private final DescriptionPDBuilder designBuilder;
    private IDescCInfoCfg.Item cfg;
    private IDescCInfoCfg addCfg;
    private DynamicCard parent;
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
    public void setParent(StaticCard parent) {
        this.parent = (DynamicCard) parent;
    }

    @Override
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (IDescCInfoCfg.Item) cfg;
    }

    @Override
    public void setAddCfg(Object config) {
        this.addCfg = (IDescCInfoCfg)config;
    }
}
