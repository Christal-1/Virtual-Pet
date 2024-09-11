package org.mobile.virtual;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VirtualPetGUI extends Application {
    private VirtualPet pet;
    private ProgressBar healthBar;
    private ProgressBar happinessBar;
    private TextArea statusArea;
    private ComboBox<String> foodComboBox;

    @Override
    public void start(Stage primaryStage) {
        // Ask for pet's name
        TextInputDialog nameDialog = new TextInputDialog("Fluffy");
        nameDialog.setTitle("Name Your Pet");
        nameDialog.setHeaderText("Virtual Pet Setup");
        nameDialog.setContentText("Please enter a name for your pet:");

        // Show dialog and capture pet name
        String petName = nameDialog.showAndWait().orElse("Fluffy");
        pet = new VirtualPet(petName);

        // Create buttons
        Button feedButton = new Button("Feed Pet");
        Button playButton = new Button("Play with Pet");
        Button checkStatusButton = new Button("Check Status");

        // Create progress bars for health and happiness
        healthBar = new ProgressBar();
        happinessBar = new ProgressBar();
        updateBars();

        // Create status text area
        statusArea = new TextArea();
        statusArea.setEditable(false);
        statusArea.setText("Welcome to the Virtual Pet game!");

        // Food selection combo box
        Label foodLabel = new Label("Select food:");
        foodComboBox = new ComboBox<>();
        foodComboBox.getItems().addAll("Carrot", "Steak", "Apple", "Fish");
        foodComboBox.setValue("Carrot");

        // Set button actions
        feedButton.setOnAction(e -> {
            String selectedFood = foodComboBox.getValue();
            pet.feed(selectedFood);
            updateStatus("You fed " + pet.getName() + " with " + selectedFood + ".");
            updateBars();
        });

        playButton.setOnAction(e -> {
            pet.play();
            updateStatus("You played with " + pet.getName() + ".");
            updateBars();
        });

        checkStatusButton.setOnAction(e -> {
            updateStatus(pet.getName() + "'s current status: Health = " + pet.getHealth() + ", Happiness = " + pet.getHappiness());
        });

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(new Label("Health:"), 0, 0);
        grid.add(healthBar, 1, 0);
        grid.add(new Label("Happiness:"), 0, 1);
        grid.add(happinessBar, 1, 1);
        grid.add(foodLabel, 0, 2);
        grid.add(foodComboBox, 1, 2);
        grid.add(feedButton, 0, 3);
        grid.add(playButton, 1, 3);
        grid.add(checkStatusButton, 2, 3);
        grid.add(statusArea, 0, 4, 3, 1);

        // Scene and Stage setup
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Virtual Pet Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateBars() {
        healthBar.setProgress(pet.getHealth() / 100.0);
        happinessBar.setProgress(pet.getHappiness() / 100.0);
    }

    private void updateStatus(String message) {
        statusArea.appendText("\n" + message);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
