package com.example.hellojavafx;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;

/** Controls the main application screen */
public class MainViewController {
    @FXML private Button logoutButton;
    @FXML private Label  sessionLabel;
    @FXML private Button backButton;
    @FXML private Button nextButton;
    @FXML private Label  importantData;
    @FXML private ImageView  importantDataPic;
    public int currentIndex = 0;
    public String[] importantDataText = {"При пожаре звонить 01", "Телефон милиции 02", "Скорая помощь 03", "Служба газа 04"};
    public Image[] images = {
            new Image(ImageLocation.class.getResource("01.png").toExternalForm()),
            new Image(ImageLocation.class.getResource("02.jpg").toExternalForm()),
            new Image(ImageLocation.class.getResource("03.jpg").toExternalForm()),
            new Image(ImageLocation.class.getResource("04.jpg").toExternalForm())
    };
    public interface ImageLocation {};

    public void initialize() {}

    public void initSessionID(final LoginManager loginManager, String sessionID) {
        sessionLabel.setText(sessionID);
        importantDataPic.setImage(images[currentIndex]);

        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                loginManager.logout();
            }
        });
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                currentIndex++;
                currentIndex = currentIndex%4;
                importantData.setText(importantDataText[currentIndex]);
                importantDataPic.setImage(images[currentIndex]);
            }
        });
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                currentIndex--;
                if (currentIndex < 0) {
                    currentIndex = 3;
                }
                importantData.setText(importantDataText[currentIndex]);
                importantDataPic.setImage(images[currentIndex]);
            }
        });
    }
}
