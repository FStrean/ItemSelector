package ru.app.project.windows.cards.iSelect.panels;

import ru.app.project.components.JImage;
import ru.app.project.config.window.ISelectCInfoCfg;
import ru.app.project.design.iSelect.impl.panels.BasicLeftPDBuilder;
import ru.app.project.design.iSelect.interf.panels.LeftPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LeftP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final LeftPDBuilder designBuilder;
    private ISelectCInfoCfg.Item cfg;
    private ISelectCInfoCfg addCfg;
    private MutableComponent parent;

    private JLabel desc;
    private JLabel desc1;
    private JImage img1;
    private JLabel desc2;
    private JImage img2;

    public LeftP() {
        this.designBuilder = new BasicLeftPDBuilder(this);

        this.cfg = null;
        this.rootWin = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        //desc = designBuilder.buildJLabelDesign();
        desc1 = designBuilder.buildJLabel1Design();
        img1 = designBuilder.buildJImage1Design();
        desc2 = designBuilder.buildJLabel2Design();
        img2 = designBuilder.buildJImage2Design();

        //desc.setVisible(false);
        desc1.setVisible(false);
        img1.setVisible(false);
        desc2.setVisible(false);
        img2.setVisible(false);
    }

    @Override
    public void applyLogic() {
    }

    @Override
    public void applyConfig() {
        if(!cfg.getLeftDesc1().isEmpty()) {
            desc1.setText("<html>" + addCfg.getLeftDesc1Style() + cfg.getLeftDesc1() + "</html>");
            desc1.setVisible(true);
        }
        if(!cfg.getLeftImg1().isEmpty()) {
            addImageToFrame(img1, cfg.getLeftImg1());
        }
        if(!cfg.getLeftDesc2().isEmpty()) {
            desc2.setText("<html>" + addCfg.getLeftDesc2Style() + cfg.getLeftDesc2() + "</html>");
            desc2.setVisible(true);
        }
        if(!cfg.getLeftImg2().isEmpty()) {
            addImageToFrame(img2, cfg.getLeftImg2());
        }
    }

    @Override
    public void runOnLeaveAction() {
        //desc.setVisible(false);
        desc1.setVisible(false);
        img1.removeImage();
        img1.setVisible(false);
        desc2.setVisible(false);
        img2.removeImage();
        img2.setVisible(false);
    }

    @Override
    public void setParent(MutableComponent parent) {
        this.parent = parent;
    }

    @Override
    public void setRootWin(RootWindow rootWin) {
        this.rootWin = rootWin;
    }

    @Override
    public void setCfg(Object cfg) {
        this.cfg = (ISelectCInfoCfg.Item) cfg;
    }

    public void setAddCfg(Object cfg) {
        this.addCfg = (ISelectCInfoCfg) cfg;
    }

    private void addImageToFrame(JImage jImage, String path) {
        try {
            load(jImage, path);
        } catch (IOException e) {
            JOptionPane.showMessageDialog((JFrame) rootWin, e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void load(JImage jImage, String path) throws IOException {
        File imageFile = new File(path);
        BufferedImage image = ImageIO.read(imageFile);

        if(image == null) {
            throw new IOException("Image is null");
        }

        jImage.setImg(image);
        jImage.setVisible(true);
    }
}
