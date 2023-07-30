package ru.app.project.windows;

import ru.app.project.components.FileChooserButton;
import ru.app.project.components.ImagePanel;
import ru.app.project.config.SystemProperties;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ItemWindow extends JFrame {
    private final JFrame parent;
    private JPanel descriptionPanel;
    private FileChooserButton imageChooserButton;
    private ImagePanel imagePanel;
    private FileChooserButton videoChooserButton;
    private EmbeddedMediaPlayerComponent videoPlayer;
    public ItemWindow(String title, JFrame parent) throws HeadlessException {
        super(title);

        this.parent = parent;

        defineInitialWindowSize(this);
        applyLayout(this);
        createStructure(this);
        parent.setVisible(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    private void defineInitialWindowSize(JFrame frame) {
        int width = SystemProperties.getScreenWidth();
        int height = SystemProperties.getScreenHeight();

        int x = (width - height) / 2;
        int y = (width - height) / 2;

        frame.setSize(width / 2, height / 2);
        frame.setLocation(x, y);

        frame.setLocationRelativeTo(null);
    }

    private void applyLayout(JFrame frame) {
        frame.setLayout(new GridBagLayout());
    }

    private void createStructure(JFrame frame) {
        createDescriptionPanel(frame);
        createImagePanel(frame);
        createVideoPlayer(frame);
    }


    @Override
    protected void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            videoPlayer.release();
            parent.setVisible(true);
            switch (super.getDefaultCloseOperation()) {
                case HIDE_ON_CLOSE -> setVisible(false);
                case DISPOSE_ON_CLOSE -> dispose();
                case EXIT_ON_CLOSE ->
                    // This needs to match the checkExit call in
                    // setDefaultCloseOperation
                        System.exit(0);
                default -> {
                }
            }
        }
    }

    private String getDescription() {
        return """
                <html>
                    It is a long established fact that a reader will be distracted by the
                    readable content of a page when looking at its layout.
                    The point of using Lorem Ipsum is that it has a more-or-less normal
                    distribution of letters, as opposed to using 'Content here,
                    content here', making it look like readable English.
                    Many desktop publishing packages and web page editors<br>
                    now use Lorem Ipsum as their default model text, and a search for
                    'lorem ipsum' will uncover many web sites still in their infancy.
                    Various versions have evolved over the years, sometimes by accident,
                    sometimes on purpose (injected humour and the like).
                <html>
                """;
    }

    private GridBagConstraints getDefaultDesign() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 10;
        constraints.ipady = 10;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.weightx = 1;
        constraints.weighty = 0;

        return constraints;
    }

    private void createDescriptionPanel(JFrame frame) {
        descriptionPanel = new JPanel(new BorderLayout());
        JLabel description = new JLabel();
        description.setText(getDescription());
        descriptionPanel.add(description);
        GridBagConstraints descriptionPanelConstraints = getDefaultDesign();

        frame.add(descriptionPanel, descriptionPanelConstraints);
    }

    private void createImagePanel(JFrame frame) {
        imagePanel = new ImagePanel();
        imageChooserButton = new FileChooserButton(this) {
            @Override
            public void fileSelectedActionPerformed(File file) {
                BufferedImage image = null;
                try {
                    image = ImageIO.read(file);
                    if(image == null) {
                        throw new RuntimeException("Image is null");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(frame, e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                imagePanel.addImage(image);
                imagePanel.repaint();
            }
        };
        GridBagConstraints imageChooserButtonConstraints = getDefaultDesign();
        imageChooserButtonConstraints.gridy = 1;
        imageChooserButtonConstraints.gridwidth = 1;
        imageChooserButtonConstraints.gridheight = 1;
        imageChooserButtonConstraints.fill = GridBagConstraints.NONE;
        frame.add(imageChooserButton, imageChooserButtonConstraints);
        GridBagConstraints imagePanelConstraints = getDefaultDesign();
        imagePanelConstraints.gridy = 2;
        imagePanelConstraints.gridwidth = 1;
        imagePanelConstraints.gridheight = 3;
        imagePanelConstraints.weighty = 1;

        frame.add(imagePanel, imagePanelConstraints);
    }

    private void createVideoPlayer(JFrame frame) {
        JPanel playerPanel = new JPanel(new BorderLayout());
        videoPlayer = new EmbeddedMediaPlayerComponent();
        playerPanel.add(videoPlayer);
        videoChooserButton = new FileChooserButton(this) {
            @Override
            public void fileSelectedActionPerformed(File file) {
                videoPlayer.mediaPlayer().controls().setRepeat(true);
                videoPlayer.mediaPlayer().media().play(file.getAbsolutePath());
            }
        };
        GridBagConstraints videoChooserButtonConstraints = getDefaultDesign();
        videoChooserButtonConstraints.gridx = 1;
        videoChooserButtonConstraints.gridy = 1;
        videoChooserButtonConstraints.gridwidth = 1;
        videoChooserButtonConstraints.fill = GridBagConstraints.NONE;
        videoChooserButtonConstraints.anchor = GridBagConstraints.LINE_END;
        frame.add(videoChooserButton, videoChooserButtonConstraints);
        GridBagConstraints videoPanelConstraints = getDefaultDesign();
        videoPanelConstraints.gridx = 1;
        videoPanelConstraints.gridy = 2;
        videoPanelConstraints.gridwidth = 1;
        videoPanelConstraints.gridheight = 3;
        videoPanelConstraints.weighty = 1;
        videoChooserButtonConstraints.fill = GridBagConstraints.BOTH;

        videoPanelConstraints.fill = GridBagConstraints.BOTH;
        videoPanelConstraints.anchor = GridBagConstraints.LINE_END;
        playerPanel.setMinimumSize(new Dimension(10, 10));
        frame.add(playerPanel, videoPanelConstraints);
    }
}
