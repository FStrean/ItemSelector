package ru.app.project.windows.cards.mSelect.panels;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.MSelectCInfoCfg;
import ru.app.project.design.mSelect.impl.panels.BasicButtonsPDBuilder;
import ru.app.project.design.mSelect.interf.panels.ButtonsPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.desc.DescC;
import ru.app.project.windows.cards.iDescSelect.IDescSelectC;
import ru.app.project.windows.cards.selector.SelectC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class ButtonsP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final ButtonsPDBuilder designBuilder;
    private MSelectCInfoCfg cfg;
    private MutableComponent parent;

    private final List<JButton> buttons;

    private Double buttonsRatio = null;

    public ButtonsP() {
        this.designBuilder = new BasicButtonsPDBuilder(this);
        this.buttons = new ArrayList<>(3);

        this.rootWin = null;
        this.cfg = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        for(int i = 0; i < 3; i++) {
            JButton jButton = designBuilder.buildJButtonDesign();
            buttons.add(jButton);
        }
    }

    @Override
    public void applyLogic() {
        buttons.get(0).addActionListener(event -> rootWin.showCard(DescC.class));
        buttons.get(1).addActionListener(event -> rootWin.showCard(IDescSelectC.class));
        buttons.get(2).addActionListener(event -> rootWin.showCard(SelectC.class));

        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (buttonsRatio == null) {
                        buttonsRatio = RelTSRatioCalc.getTextRatio(buttons.get(0));
                    }
                    TSCalc.calcTextSize(buttons.get(0), buttonsRatio);
                    TSCalc.calcTextSize(buttons.get(1), buttonsRatio);
                    TSCalc.calcTextSize(buttons.get(2), buttonsRatio);
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
        buttons.get(0).setText(cfg.getButton1());
        buttons.get(1).setText(cfg.getButton2());
        buttons.get(2).setText(cfg.getButton3());
    }

    @Override
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (MSelectCInfoCfg) cfg;
    }
}
