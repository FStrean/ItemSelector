package ru.app.project.windows.cards.panels.iDesc;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.IDescCInfoCfg;
import ru.app.project.design.impl.panels.iDesc.BasicHeaderPDBuilder;
import ru.app.project.design.interf.panels.iDesc.HeaderPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.*;
import ru.app.project.windows.cards.IDescC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HeaderP extends JPanel implements DynamicPanel {
    private RootWindow rootWin;
    private final HeaderPDBuilder designBuilder;
    private IDescCInfoCfg.Item cfg;
    private IDescCInfoCfg addCfg;
    private DynamicCard parent;

    private JImageButton lBtn;
    private JImageButton rBtn;
    private JLabel desc;

    private Double descRatio = null;

    private int id;

    public HeaderP() {
        this.designBuilder = new BasicHeaderPDBuilder(this);

        this.cfg = null;
        this.rootWin = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        lBtn = designBuilder.buildJButton1Design();
        rBtn = designBuilder.buildJButton2Design();
        desc = designBuilder.buildJLabelDesign();
    }

    @Override
    public void applyLogic(){
        int maxId = AppProperties.getNumOfItemsInIDescSelect();
        lBtn.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWin.showCard(IDescC.class, (id - 1) < 1 ? maxId : (id - 1));
        });
        rBtn.addActionListener(event -> {
            parent.runOnLeaveAction();
            rootWin.showCard(IDescC.class, (id + 1) > maxId ? 1 : (id + 1));
        });

        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descRatio == null) {
                        descRatio = RelTSRatioCalc.getTextRatio(addCfg.getHHeaderStyle(), desc.getWidth());
                    }
                    TSCalc.calcTextSize(desc, descRatio);
                }
            });
        }
    }

    @Override
    public void applyConfig() {
        id = cfg.getId();

        desc.setText("<html>" + addCfg.getHHeaderStyle() + cfg.getHHeader() + "</html>");
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
