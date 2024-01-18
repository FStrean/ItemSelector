package ru.app.project.windows;

import ru.app.project.config.AppProperties;
import ru.app.project.config.SystemProperties;
import ru.app.project.windows.cards.desc.DescC;
import ru.app.project.windows.cards.iDesc.IDescC;
import ru.app.project.windows.cards.iDescSelect.IDescSelectC;
import ru.app.project.windows.cards.mSelect.MSelectC;
import ru.app.project.windows.cards.selector.SelectC;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RootWindowImpl extends JFrame implements RootWindow, CustomizableComponent {
    private final CardLayout cardLayout;

    private final Map<String, JPanel> cards = new HashMap<>();

    public RootWindowImpl(String title) {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        this.defineInitialWindowSize();

        this.cardLayout = new CardLayout();

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
        cards.put(MSelectC.class.getSimpleName(), mSelectC);
        add(mSelectC, MSelectC.class.getSimpleName());

        DescC descC = new DescC(this);
        cards.put(DescC.class.getSimpleName(), descC);
        add(descC, DescC.class.getSimpleName());

        IDescSelectC iDescSelectC = new IDescSelectC(this);
        cards.put(IDescSelectC.class.getSimpleName(), iDescSelectC);
        add(iDescSelectC, IDescSelectC.class.getSimpleName());

        SelectC selectC = new SelectC(this);
        cards.put(SelectC.class.getSimpleName(), selectC);
        add(selectC, SelectC.class.getSimpleName());

        IDescC iDescC = new IDescC(this);
        cards.put(IDescC.class.getSimpleName(), iDescC);
        add(iDescC, IDescC.class.getSimpleName());
    }

    @Override
    public void showCard(Class<?> cardClass, int i) {
        if(cardClass == IDescC.class) {
            cardLayout.show(this.getContentPane(), cardClass.getSimpleName());
            ((IDescC)(cards.get(cardClass.getSimpleName()))).showState(i);
        } else {
            showCard(cardClass);
        }
    }

    @Override
    public void showCard(Class<?> cardClass) {
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
