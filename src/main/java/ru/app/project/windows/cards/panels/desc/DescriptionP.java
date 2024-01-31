package ru.app.project.windows.cards.panels.desc;

import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.DescCInfoCfg;
import ru.app.project.design.impl.panels.desc.BasicDescriptionPDBuilder;
import ru.app.project.design.interf.panels.desc.DescriptionPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.template.StaticCard;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.root.RootWindow;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DescriptionP extends JPanel implements StaticPanel {
    private RootWindow rootWin;
    private final DescriptionPDBuilder designBuilder;
    private DescCInfoCfg cfg;
    private StaticCard parent;

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
    public void setParent(StaticCard parent) {
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
