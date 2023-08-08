package ru.app.project.windows;

import ru.app.project.config.SystemProperties;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow {
    private final JFrame window;
    public MainWindow(String title) throws HeadlessException {
        window = new JFrame(title);

        createStructure(window);
        defineInitialWindowSize(window);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }

    private void defineInitialWindowSize(JFrame frame) {
        int width = SystemProperties.getScreenWidth();
        int height = SystemProperties.getScreenHeight();

        int x = (width - height) / 2;
        int y = (width - height) / 2;

        frame.setSize(width / 3, (int)((double)height / 1.5));
        frame.setLocation(x, y);

        frame.setLocationRelativeTo(null);
    }


    private void createStructure(JFrame frame) {
        JButton[] itemButton = getButtons();

        JPanel mainPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(boxLayout);

        int id = 1;
        for (JButton button : itemButton) {
            applyButtonAction(button, window, id);

            JPanel buttonPanel = new JPanel(new BorderLayout());
            buttonPanel.add(button);
            applyButtonPanelUI(buttonPanel);

            mainPanel.add(buttonPanel);
            id++;
        }

        frame.add(mainPanel);
    }

    private void applyButtonPanelUI(JPanel buttonPanel) {
        buttonPanel.setBorder(new EmptyBorder(5, 1, 5, 1));
    }

    private void applyButtonAction(JButton button, final JFrame parent, int id) {
        button.addActionListener(e -> new ItemWindow("Item Window", parent, id));
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
