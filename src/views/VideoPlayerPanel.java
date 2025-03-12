package views;

import java.awt.BorderLayout;
import java.io.File;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.swing.JPanel;

public class VideoPlayerPanel extends JPanel {
    private JFXPanel jfxPanel;
    private MediaPlayer mediaPlayer;

    public VideoPlayerPanel(String videoPath) {
        setLayout(new BorderLayout());
        jfxPanel = new JFXPanel();
        add(jfxPanel, BorderLayout.CENTER);

        Platform.runLater(() -> initFX(videoPath));
    }

    private void initFX(String videoPath) {
        File file = new File(videoPath);
        if (!file.exists()) {
            System.out.println("Arquivo não encontrado: " + videoPath);
            return;
        }

        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setPreserveRatio(true);

        Scene scene = new Scene(new javafx.scene.layout.StackPane(mediaView));
        jfxPanel.setScene(scene);

        mediaView.fitWidthProperty().bind(scene.widthProperty());
        mediaView.fitHeightProperty().bind(scene.heightProperty());
    }

    public void playVideo() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }
    public void pauseVideo() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void stopVideo() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public boolean isPaused() {
        return mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED;
    }
}
