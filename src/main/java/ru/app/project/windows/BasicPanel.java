package ru.app.project.windows;

public interface BasicPanel extends MutableComponent, CustomizableComponent{
    void runOnLeaveAction();
    void setParent(MutableComponent parent);
    void setRootWindow(RootWindow rootWindow);
    void setConfig(Object config);
}
