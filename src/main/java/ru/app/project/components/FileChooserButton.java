package ru.app.project.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooserButton extends JButton implements ActionListener {
    private final JFrame parent;

    public FileChooserButton(JFrame parent, String text) {
        super(text);
        this.addActionListener(this);
        this.parent = parent;
    }

    public void fileSelectedActionPerformed(File file) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileToUpload = new JFileChooser();

        int response = fileToUpload.showOpenDialog(parent);
        if(response == JFileChooser.APPROVE_OPTION) {
            File uploadedFile = new File(fileToUpload.getSelectedFile().getAbsolutePath());

            fileSelectedActionPerformed(uploadedFile);
        }
    }
}
