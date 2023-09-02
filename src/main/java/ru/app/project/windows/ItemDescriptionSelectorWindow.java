package ru.app.project.windows;

import ru.app.project.config.AppProperties;
import ru.app.project.config.SystemProperties;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ItemDescriptionSelectorWindow {
    private final JFrame frame ;
    private final ItemDescriptionWindow itemDescriptionWindow;
    public ItemDescriptionSelectorWindow(String title) {
        frame = new JFrame(title);
        itemDescriptionWindow = new ItemDescriptionWindow(AppProperties.getItemWindowName(), frame);

        createStructure();
        defineInitialWindowSize();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void defineInitialWindowSize() {
        int width = SystemProperties.getScreenWidth();
        int height = SystemProperties.getScreenHeight();

        int x = (width - height) / 2;
        int y = (width - height) / 2;

        frame.setSize(width / 3, (int)((double)height / 1.5));
        frame.setLocation(x, y);

        frame.setLocationRelativeTo(null);
    }


    private void createStructure() {
        JButton[] itemButton = getButtons();

        JPanel mainPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(boxLayout);

        for (int i = 0; i < itemButton.length; i++) {
            applyButtonAction(itemButton[i], i + 1);

            JPanel buttonPanel = new JPanel(new BorderLayout());
            buttonPanel.add(itemButton[i]);
            applyButtonPanelUI(buttonPanel);

            mainPanel.add(buttonPanel);
        }

        frame.add(mainPanel);
    }

    private void applyButtonPanelUI(JPanel buttonPanel) {
        buttonPanel.setBorder(new EmptyBorder(5, 1, 5, 1));
    }

    private void applyButtonAction(JButton button, int id) {
        button.addActionListener(event -> itemDescriptionWindow.show(id));
    }

    private JButton[] getButtons() {
        return new JButton[]{
                new JButton("1"),
                new JButton("2"),
                new JButton("3"),
                new JButton("4"),
                new JButton("5"),
                new JButton("6"),
                new JButton("7"),
                new JButton("8"),
                new JButton("9"),
                new JButton("10"),
                new JButton("11"),
                new JButton("12"),
                new JButton("13"),
                new JButton("14"),
                new JButton("15")
        };
    }
}
