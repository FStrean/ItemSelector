package ru.app.project.windows;

public interface RootWindow {
    void showCard(Class<? extends MultipleStateCard> cardClass, int i);
    void showCard(Class<? extends BasicCard> cardClass);
}
