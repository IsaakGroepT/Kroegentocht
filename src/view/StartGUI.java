package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: De JavaFX GUI
 */
public class StartGUI extends Application {
	
	@Override
	public void start(Stage scherm)
	{
		scherm.setTitle("Kroegentocht Applicatie");

		GridPane gridPaneel = new GridPane();
		gridPaneel.setAlignment(Pos.CENTER);
		gridPaneel.setPadding(new Insets(20, 20, 20, 20));
		gridPaneel.setVgap(10);
		gridPaneel.setHgap(10);

		VBox vboxBtn = new VBox();
		vboxBtn.setSpacing(10);
		vboxBtn.setPadding(new Insets(0, 20, 10, 20));

		Text txtWelkom = new Text("KROEGENTOCHT");
		txtWelkom.setId("welkomTekst");
		gridPaneel.add(txtWelkom, 2, 0);
		
		// Button naar --> Toevoegen cafe Scene
		Button btnToevoegenCafe = new Button("Cafe Toevoegen");
		btnToevoegenCafe.setAlignment(Pos.CENTER);
		btnToevoegenCafe.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(btnToevoegenCafe, 2, 1);
		btnToevoegenCafe.setOnAction((ActionEvent e) ->
		{
			AlertBox.displayCafeToevoegenScene("Cafe Toevoegen", "Probleem bij toevoegen");
		});

		// Button naar --> Selectie cafe
		Button btnStarten = new Button("Start");
		btnStarten.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(btnStarten, 2, 2);
		btnStarten.setOnAction((ActionEvent e) ->
		{
			AlertBox.kiesStartCafeScene("Get ready!");
		});

		// Button naar --> Statistieken Scene
		Button btnStatistieken = new Button("Statistieken");
		btnStatistieken.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(btnStatistieken, 2, 3);

		// Exit knop
		Button btnExit = new Button("Exit");
		btnExit.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(btnExit, 2, 4);
		btnExit.setOnAction((ActionEvent e) ->
		{
			scherm.close();
		});
		
		// Setup scene
        gridPaneel.getChildren().addAll(btnToevoegenCafe, btnStarten, btnStatistieken, btnExit);
        Scene homeScene = new Scene(gridPaneel, 300, 400);
        scherm.setScene(homeScene);
        homeScene.getStylesheets().add(StartGUI.class.getResource("Kroegentocht.css").toExternalForm());
        scherm.show();
	}
}
