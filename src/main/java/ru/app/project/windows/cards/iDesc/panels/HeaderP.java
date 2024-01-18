package ru.app.project.windows.cards.iDesc.panels;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.window.IDescCInfoCfg;
import ru.app.project.design.iDesc.impl.panels.BasicHeaderPDBuilder;
import ru.app.project.design.iDesc.interf.panels.HeaderPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.iDesc.IDescC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HeaderP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final HeaderPDBuilder designBuilder;
    private IDescCInfoCfg.Item cfg;
    private IDescCInfoCfg addCfg;
    private MutableComponent parent;

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
        int maxId = AppProperties.getNumOfItemsInIDesc();
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
