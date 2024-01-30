package ru.app.project.windows.cards.panels.iDescSelect;

import ru.app.project.config.AppProperties;
import ru.app.project.config.cards.IDescSelectCInfoCfg;
import ru.app.project.design.impl.panels.iDescSelect.BasicButtonsPDBuilder;
import ru.app.project.design.interf.panels.iDescSelect.ButtonsPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.IDescC;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class ButtonsP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final ButtonsPDBuilder designBuilder;
    private IDescSelectCInfoCfg cfg;
    private MutableComponent parent;

    private final List<JButton> buttons;

    private Double btnRatio = null;

    public ButtonsP() {
        this.designBuilder = new BasicButtonsPDBuilder(this);
        this.buttons = new ArrayList<>();

        this.rootWin = null;
        this.cfg = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        for(int i = 0; i < AppProperties.getNumOfItemsInIDescSelect(); i++) {
            JButton jButton = designBuilder.buildJButtonDesign();
            buttons.add(jButton);
        }
    }

    @Override
    public void applyLogic() {
        if(AppProperties.isTextDynamic()) {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    if (btnRatio == null) {
                        btnRatio = RelTSRatioCalc.getTextRatio(buttons.get(0));
                    }
                }
            });
        }

        for(int i = 0; i < AppProperties.getNumOfItemsInIDescSelect(); i++) {
            int id = i + 1;
            buttons.get(i).addActionListener(event -> rootWin.showCard(IDescC.class, id));

            if(AppProperties.isTextDynamic()) {
                int finalI = i;
                this.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        TSCalc.calcTextSize(buttons.get(finalI), btnRatio);
                    }
                });
            }
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
        for(int i = 0; i < AppProperties.getNumOfItemsInIDescSelect(); i++) {
            buttons.get(i).setText(cfg.getButtons().get(i));
        }
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
