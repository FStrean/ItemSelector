package ru.app.project.windows.root;

import ru.app.project.config.AppProperties;
import ru.app.project.config.SystemProperties;
import ru.app.project.windows.cards.DescC;
import ru.app.project.windows.cards.ISelectC;
import ru.app.project.windows.cards.ISelectSelectC;
import ru.app.project.windows.cards.IDescC;
import ru.app.project.windows.cards.IDescSelectC;
import ru.app.project.windows.cards.MSelectC;
import ru.app.project.windows.cards.SelectC;
import ru.app.project.windows.cards.VideoC;
import ru.app.project.windows.template.DynamicCard;
import ru.app.project.windows.template.StaticCard;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RootWindowImpl extends JFrame implements RootWindow {
    private final CardLayout cardLayout;

    private final Map<String, JPanel> cards = new HashMap<>();

    public RootWindowImpl(String title) {
        this.cardLayout = new CardLayout();

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.defineInitialWindowSize();
        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        setLayout(cardLayout);
    }

    @Override
    public void applyLogic() {
        MSelectC mSelectC = new MSelectC(this);
        DescC descC = new DescC(this);
        IDescSelectC iDescSelectC = new IDescSelectC(this);
        SelectC selectC = new SelectC(this);
        IDescC iDescC = new IDescC(this);
        ISelectSelectC iSelectSelectC = new ISelectSelectC(this);
        ISelectC iSelectC = new ISelectC(this);
        VideoC videoC = new VideoC(this);

        cards.put(MSelectC.class.getSimpleName(), mSelectC);
        cards.put(DescC.class.getSimpleName(), descC);
        cards.put(IDescSelectC.class.getSimpleName(), iDescSelectC);
        cards.put(SelectC.class.getSimpleName(), selectC);
        cards.put(IDescC.class.getSimpleName(), iDescC);
        cards.put(ISelectSelectC.class.getSimpleName(), iSelectSelectC);
        cards.put(ISelectC.class.getSimpleName(), iSelectC);
        cards.put(VideoC.class.getSimpleName(), videoC);

        add(mSelectC, MSelectC.class.getSimpleName());
        add(descC, DescC.class.getSimpleName());
        add(iDescSelectC, IDescSelectC.class.getSimpleName());
        add(selectC, SelectC.class.getSimpleName());
        add(iDescC, IDescC.class.getSimpleName());
        add(iSelectSelectC, ISelectSelectC.class.getSimpleName());
        add(iSelectC, ISelectC.class.getSimpleName());
        add(videoC, VideoC.class.getSimpleName());
    }

    @Override
    public void showCard(StaticCard previous, Class<? extends DynamicCard> cardClass, int i) {
        previous.runOnLeaveAction();
        cardLayout.show(this.getContentPane(), cardClass.getSimpleName());
        ((DynamicCard)(cards.get(cardClass.getSimpleName()))).showState(i);
    }

    @Override
    public void showCard(StaticCard previous, Class<? extends StaticCard> cardClass) {
        previous.runOnLeaveAction();
        cardLayout.show(this.getContentPane(), cardClass.getSimpleName());
    }

    private void defineInitialWindowSize() {
        int width = SystemProperties.getScreenWidth();
        int height = SystemProperties.getScreenHeight();

        int x = (width - height) / 2;
        int y = (width - height) / 2;

        this.setSize(AppProperties.getWinW(), AppProperties.getWinH());
        this.setLocation(x, y);

        this.setLocationRelativeTo(null);
    }
}
