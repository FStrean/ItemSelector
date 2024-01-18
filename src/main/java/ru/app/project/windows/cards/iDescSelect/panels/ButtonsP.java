package ru.app.project.windows.cards.iDescSelect.panels;

import ru.app.project.config.AppProperties;
import ru.app.project.config.window.IDescSelectCInfoCfg;
import ru.app.project.design.iDescSelect.impl.panels.BasicButtonsPDBuilder;
import ru.app.project.design.iDescSelect.interf.panels.ButtonsPDBuilder;
import ru.app.project.utility.TSCalc;
import ru.app.project.utility.RelTSRatioCalc;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;
import ru.app.project.windows.cards.iDesc.IDescC;

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
        for(int i = 0; i < 15; i++) {
            JButton jButton = designBuilder.buildJButtonDesign();
            buttons.add(jButton);
        }
    }

    @Override
    public void applyLogic() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if(buttonsRatio == null) {
                    buttonsRatio = RelTSRatioCalc.getTextRatio(buttons.get(0));
                }
            }
        });

        for(int i = 0; i < AppProperties.getNumOfItemsInIDesc(); i++) {
            int id = i + 1;
            buttons.get(i).addActionListener(event -> rootWin.showCard(IDescC.class, id));

            if(AppProperties.isTextDynamic()) {
                int finalI = i;
                this.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        TSCalc.calcTextSize(buttons.get(finalI), buttonsRatio);
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
        for(int i = 0; i < AppProperties.getNumOfItemsInIDesc(); i++) {
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
