package ru.app.project.windows.cards.panels.iSelect;

import ru.app.project.components.JImageButton;
import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.ISelectCInfoCfg;
import ru.app.project.design.impl.panels.iSelect.BasicHeaderPDBuilder;
import ru.app.project.design.interf.panels.iSelect.HeaderPDBuilder;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.utility.TSCalc;
import ru.app.project.windows.cards.ISelectC;
import ru.app.project.windows.root.RootWindow;
import ru.app.project.windows.template.DynamicCard;
import ru.app.project.windows.template.DynamicPanel;
import ru.app.project.windows.template.StaticCard;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Arrays;

public class HeaderP extends JPanel implements DynamicPanel {
    private RootWindow rootWin;
    private final HeaderPDBuilder designBuilder;
    private ISelectCInfoCfg.Item cfg;
    private ISelectCInfoCfg addCfg;
    private DynamicCard parent;

    private JImageButton lBtn;
    private JLabel desc;
    private JImageButton rBtn;

    private Double descRatio = null;

    private int id;
    private final int maxId;

    public HeaderP() {
        this.designBuilder = new BasicHeaderPDBuilder(this);

        this.cfg = null;
        this.rootWin = null;
        this.maxId = Arrays.stream(AppProperties.getNumOfPagesInISelect()).sum();

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        lBtn = designBuilder.buildJButton1Design();
        desc = designBuilder.buildJLabelDesign();
        rBtn = designBuilder.buildJButton2Design();
    }

    @Override
    public void applyLogic(){
        lBtn.addActionListener(event -> rootWin.showCard(parent, ISelectC.class, (id - 1) < 1 ? maxId : (id - 1)));
        rBtn.addActionListener(event -> rootWin.showCard(parent, ISelectC.class, (id + 1) > maxId ? 1 : (id + 1)));

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
        this.parent = (DynamicCard) parent;;
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
