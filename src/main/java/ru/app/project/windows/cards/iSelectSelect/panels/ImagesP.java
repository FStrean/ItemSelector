package ru.app.project.windows.cards.iSelectSelect.panels;

import ru.app.project.algo.RingBuffer;
import ru.app.project.components.JImage;
import ru.app.project.config.AppProperties;
import ru.app.project.config.window.ISelectSelectCInfoCfg;
import ru.app.project.design.iSelectSelect.impl.panels.BasicImagesPDBuilder;
import ru.app.project.design.iSelectSelect.interf.panels.ImagesPDBuilder;
import ru.app.project.windows.BasicPanel;
import ru.app.project.windows.MutableComponent;
import ru.app.project.windows.RootWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImagesP extends JPanel implements BasicPanel {
    private RootWindow rootWin;
    private final ImagesPDBuilder designBuilder;
    private ISelectSelectCInfoCfg cfg;
    private MutableComponent parent;

    private RingBuffer<JImage> images;

    public ImagesP() {
        this.designBuilder = new BasicImagesPDBuilder(this);

        this.cfg = null;
        this.rootWin = null;

        this.applyDesign();
        this.applyLogic();
    }

    @Override
    public void applyDesign() {
        List<JImage> jImages = new ArrayList<>(AppProperties.getMaxNumOfImgInISelectSelect());
        for (int i = 0; i < AppProperties.getMaxNumOfImgInIDesc(); i++) {
            JImage image = designBuilder.buildJImageDesign();
            jImages.add(image);
            image.setVisible(false);
        }

        images = new RingBuffer<>(jImages);
    }

    @Override
    public void applyLogic() {
    }

    @Override
    public void applyConfig() {
        for(String path : cfg.getImages()) {
            if(!path.isEmpty()) {
                addImageToFrame(path);
            }
        }
    }

    @Override
    public void runOnLeaveAction() {
        images.reset();
        for(JImage image : images.getElements()) {
            image.removeImage();
            image.setVisible(false);
        }
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
        this.cfg = (ISelectSelectCInfoCfg) cfg;
    }

    private void addImageToFrame(String path) {
        try {
            load(path);
        } catch (IOException e) {
            JOptionPane.showMessageDialog((JFrame) rootWin, e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void load(String path) throws IOException {
        JImage jImage = images.getNext();

        File imageFile = new File(path);
        BufferedImage image = ImageIO.read(imageFile);

        if(image == null) {
            throw new IOException("Image is null");
        }

        jImage.setImg(image);
        jImage.setVisible(true);
    }
}
