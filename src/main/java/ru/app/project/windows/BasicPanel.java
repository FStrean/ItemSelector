package ru.app.project.windows;

public interface BasicPanel extends MutableComponent, CustomizableComponent{
    void runOnLeaveAction();
    void setParent(MutableComponent parent);
    void setRootWin(RootWindow rootWin);
    void setCfg(Object cfg);
}
