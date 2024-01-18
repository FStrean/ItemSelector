package ru.app.project.windows.cards.selector.panels;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.SelectCInfoCfg;
import ru.app.project.design.select.impl.panels.BasicButtonsPDBuilder;
import ru.app.project.design.select.interf.panels.ButtonsPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.iDesc.IDescC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ButtonsP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final ButtonsPDBuilder designBuilder;
    private SelectCInfoCfg cfg;
    private MutableComponent parent;

    private JLabel desc;
    private JButton btn1;
    private JButton btn2;

    private Double descRatio = null;
    private Double btnRatio = null;

    public ButtonsP() {
        this.designBuilder = new BasicButtonsPDBuilder(this);

        this.rootWin = null;
        this.cfg = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        desc = designBuilder.buildDescription();
        btn1 = designBuilder.buildJButtonDesign();
        btn2 = designBuilder.buildJButtonDesign();
    }

    @Override
    public void applyLogic() {
        btn1.addActionListener(event -> rootWin.showCard(IDescC.class, 1));
        btn2.addActionListener(event -> rootWin.showCard(IDescC.class, 1));

        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (descRatio == null) {
                        descRatio = RelTSRatioCalc.getTextRatio(desc);
                        btnRatio = RelTSRatioCalc.getTextRatio(btn1);
                    }
                    TSCalc.calcTextSize(desc, descRatio);
                    TSCalc.calcTextSize(btn1, btnRatio);
                    TSCalc.calcTextSize(btn2, btnRatio);
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
        desc.setText(cfg.getDesc());
        btn1.setText(cfg.getButton1());
        btn2.setText(cfg.getButton2());
    }

    @Override
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (SelectCInfoCfg) cfg;
    }
}
