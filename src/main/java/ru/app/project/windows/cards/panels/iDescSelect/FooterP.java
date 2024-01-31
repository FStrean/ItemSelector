package ru.app.project.windows.cards.panels.iDescSelect;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.IDescSelectCInfoCfg;
import ru.app.project.design.impl.panels.iDescSelect.BasicFooterPDBuilder;
import ru.app.project.design.interf.panels.iDescSelect.FooterPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.template.StaticCard;
import ru.app.project.windows.template.StaticPanel;
import ru.app.project.windows.root.RootWindow;
import ru.app.project.windows.cards.MSelectC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FooterP extends JPanel implements StaticPanel {
    private RootWindow rootWin;
    private final FooterPDBuilder designBuilder;
    private IDescSelectCInfoCfg cfg;
    private StaticCard parent;

    private JLabel desc;
    private JImageButton btn;

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
        desc = designBuilder.buildJLabelDesign();
        btn = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic() {
        btn.addActionListener(event -> rootWin.showCard(parent, MSelectC.class));
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
        desc.setText(cfg.getFHeader());
    }

    @Override
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (IDescSelectCInfoCfg) cfg;
    }
}
