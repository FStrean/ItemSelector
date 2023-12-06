package ru.app.project.windows;

import ru.app.project.config.SystemProperties;
import ru.app.project.windows.cards.description.DescriptionC;
import ru.app.project.windows.cards.itemDescription.ItemDescriptionC;
import ru.app.project.windows.cards.itemDescriptionSelector.ItemDescriptionSelectorC;
import ru.app.project.windows.cards.mainSelector.MainSelectorC;
import ru.app.project.windows.cards.selector.SelectorC;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RootWindowImpl extends JFrame implements RootWindow {
    private final CardLayout cardLayout;

    private final Map<String, JPanel> cards = new HashMap<>();

    public RootWindowImpl(String title) {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        defineInitialWindowSize();

        cardLayout = new CardLayout();

        applyDesign();
        applyLogic();
    }

    private void applyDesign() {
        setLayout(cardLayout);
    }

    private void applyLogic() {
        MainSelectorC mainSelectorC = new MainSelectorC(this);
        cards.put(MainSelectorC.class.getSimpleName(), mainSelectorC);
        add(mainSelectorC, MainSelectorC.class.getSimpleName());

        DescriptionC descriptionC = new DescriptionC(this);
        cards.put(DescriptionC.class.getSimpleName(), descriptionC);
        add(descriptionC, DescriptionC.class.getSimpleName());

        ItemDescriptionSelectorC itemDescriptionSelectorC = new ItemDescriptionSelectorC(this);
        cards.put(ItemDescriptionSelectorC.class.getSimpleName(), itemDescriptionSelectorC);
        add(itemDescriptionSelectorC, ItemDescriptionSelectorC.class.getSimpleName());

        SelectorC selectorC = new SelectorC(this);
        cards.put(SelectorC.class.getSimpleName(), selectorC);
        add(selectorC, SelectorC.class.getSimpleName());

        ItemDescriptionC itemDescriptionC = new ItemDescriptionC(this);
        cards.put(ItemDescriptionC.class.getSimpleName(), itemDescriptionC);
        add(itemDescriptionC, ItemDescriptionC.class.getSimpleName());
    }

    @Override
    public void showCard(Class<?> cardClass, int i) {
        if(cardClass == ItemDescriptionC.class) {
            cardLayout.show(this.getContentPane(), cardClass.getSimpleName());
            ((ItemDescriptionC)(cards.get(cardClass.getSimpleName()))).showState(i);
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

        this.setSize((int)((double)width / 1.5), (int)((double)height / 1.5));
        this.setLocation(x, y);

        this.setLocationRelativeTo(null);
    }
}
