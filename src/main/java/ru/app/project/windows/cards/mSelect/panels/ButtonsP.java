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
import ru.app.project.windows.cards.select.SelectC;

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

    private JButton button1;
    private JButton button2;
    private JButton button3;

    private Double buttonsRatio = null;

    public ButtonsP() {
        this.designBuilder = new BasicButtonsPDBuilder(this);

        this.rootWin = null;
        this.cfg = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        button1 = designBuilder.buildJButtonDesign();
        button2 = designBuilder.buildJButtonDesign();
        button3 = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic() {
        button1.addActionListener(event -> rootWin.showCard(DescC.class));
        button2.addActionListener(event -> rootWin.showCard(IDescSelectC.class));
        button3.addActionListener(event -> rootWin.showCard(SelectC.class));

        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (buttonsRatio == null) {
                        buttonsRatio = RelTSRatioCalc.getTextRatio(button1);
                    }
                    TSCalc.calcTextSize(button1, buttonsRatio);
                    TSCalc.calcTextSize(button2, buttonsRatio);
                    TSCalc.calcTextSize(button3, buttonsRatio);
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
        button1.setText(cfg.getButton1());
        button2.setText(cfg.getButton2());
        button3.setText(cfg.getButton3());
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
