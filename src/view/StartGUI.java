package view;/**
 * Created by Administrator on 2-11-2015.
 */

import controller.KroegenTocht;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Cafe;
import model.Cafebezoek;


public class StartGUI extends Application {
    Stage window;
    Scene HomeScene,StatistiekenScene,ActionScene;



    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        KroegenTocht.setVoorbeelden();
        window = primaryStage;
        window.setTitle("Kroegentocht");

        /**
         * Create Grid
         */
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        /**
         * Create Hbox
         */

        VBox vboxButtons = new VBox();
        vboxButtons.setSpacing(10);
        vboxButtons.setPadding(new Insets(0, 20, 10, 20));

        /**
         * Creating text - labels - buttons
         * and
         * Adding to GridPane
         */
        Text welcomeText = new Text("KROEGENTOCHT");
        welcomeText.setId("welcomeText");
        gridPane.add(welcomeText, 2, 0);


        /**
         * Button naar --> Toevoegen cafe Scene
         */
        Button toevoegenCafeButton = new Button("Toevoegen Cafe");
        toevoegenCafeButton.setAlignment(Pos.CENTER);
        toevoegenCafeButton.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(toevoegenCafeButton, 2, 1);
        toevoegenCafeButton.setOnAction(a -> AlertBox.displayCafeToevoegenScene("Toevoegen Cafe", "Probleem bij toevoegen"));

        /**
         * Button naar --> Selectie cafe
         */
        Button startenButton = new Button("Start");
        startenButton.setOnAction(e -> {
            AlertBox.kiesStartCafeScene("Get ready!");
            // cafebezoekScene();

        });
        startenButton.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(startenButton, 2, 2);

        /**
         * Button naar --> Statistieken Scene
         */

        Button statistiekenButton = new Button("Statistieken");
        statistiekenButton.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(statistiekenButton, 2, 3);

        /**
         * Button naar --> Close program
         */
        Button closeProgram = new Button("Exit");
        closeProgram.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(closeProgram, 2, 4);
        closeProgram.setOnAction(e -> window.close());

        /**
         * Setup HomeScene
         */

        gridPane.getChildren().addAll(toevoegenCafeButton, startenButton, statistiekenButton, closeProgram);
        Scene homeScene = new Scene(gridPane,300, 400);
        window.setScene(homeScene);
        homeScene.getStylesheets().add(StartGUI.class.getResource("Kroegentocht.css").toExternalForm());
        window.show();




    }







}
