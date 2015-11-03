/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Date;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Cafe;
import model.CafeLijst;
import model.CafeSoort;
import model.Cafebezoek;

/**
 *
 * @author Isaak
 */
public class AlertBox {

	/**
	 * 
	 * @param titel
	 * @param bericht 
	 */
	public static void displayCafeToevoegenScene(String titel, String bericht)
	{
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cafe is toegevoegd", ButtonType.OK);
		Stage scherm = new Stage();
		scherm.initModality(Modality.APPLICATION_MODAL);
		scherm.setTitle(titel);
		scherm.setMinWidth(350);

		GridPane gridPaneel = new GridPane();
		gridPaneel.setAlignment(Pos.CENTER);
		gridPaneel.setVgap(10);
		gridPaneel.setHgap(10);
		gridPaneel.setPadding(new Insets(20, 20, 20, 20));

		Text sceneTitle = new Text("Voer de gegevens van het café in");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		gridPaneel.add(sceneTitle, 0, 0, 2, 1);

		Label lblNaam = new Label("_Name:");
		gridPaneel.add(lblNaam, 0, 1);
		Label lblAdres = new Label("_Address:");
		gridPaneel.add(lblAdres, 0, 2);
		Label lblSoort = new Label("_Soort:");
		gridPaneel.add(lblSoort, 0, 3);

		TextField txtFieldCafeNaam = new TextField();
		lblNaam.setLabelFor(txtFieldCafeNaam);
		lblNaam.setMnemonicParsing(true);
		gridPaneel.add(txtFieldCafeNaam, 2, 1);

		TextField txtFieldCafeAdres = new TextField();
		lblAdres.setLabelFor(txtFieldCafeAdres);
		lblAdres.setMnemonicParsing(true);
		gridPaneel.add(txtFieldCafeAdres, 2, 2);

		ComboBox<CafeSoort> cmboxCafeSoort = new ComboBox<>();
		cmboxCafeSoort.getItems().setAll(CafeSoort.values());
		lblSoort.setLabelFor(cmboxCafeSoort);
		lblSoort.setMnemonicParsing(true);
		gridPaneel.add(cmboxCafeSoort, 2, 3);

		HBox hBtn = new HBox(10);

		Button btnToevoegen = new Button("Toevoegen");
		hBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hBtn.getChildren().add(btnToevoegen);
		gridPaneel.add(btnToevoegen, 3, 4);
		btnToevoegen.setOnAction((ActionEvent e) ->
		{
			/*Adres cafeAdres = new Adres();
			cafeAdres.setStreet(txtFieldCafeAdres.getText());
			new Cafe(txtFieldCafeNaam.getText(), cafeAdres, cmboxCafeSoort.getValue());

			alert.show();*/
		});

		Button btnExit = new Button("Close");
		hBtn.getChildren().add(btnExit);
		btnExit.setOnAction(e -> scherm.close());
		gridPaneel.add(btnExit, 4, 4);

		gridPaneel.setHalignment(lblNaam, HPos.RIGHT);
		gridPaneel.setHalignment(lblAdres, HPos.RIGHT);
		gridPaneel.setHalignment(lblSoort, HPos.RIGHT);

		Scene toevoegenCafeScene = new Scene(gridPaneel);
		scherm.setScene(toevoegenCafeScene);
		scherm.showAndWait();
	}
	
	/**
	 * 
	 * @param title 
	 */
	public static void kiesStartCafeScene(String title)
	{
		Stage scherm = new Stage();
		scherm.initModality(Modality.APPLICATION_MODAL);
		scherm.setTitle(title);
		scherm.setMinWidth(350);
		
		GridPane gridPaneel = new GridPane();
		gridPaneel.setVgap(10);
		gridPaneel.setHgap(10);
		gridPaneel.setPadding(new Insets(10));

		Label lblKies = new Label("Kies je cafe");
		gridPaneel.add(lblKies, 2, 0);
		lblKies.setAlignment(Pos.CENTER);

		/*ComboBox<String> cmboxCafes = new ComboBox<>();
		cmboxCafes.getItems().setAll(CafeLijst.getCafeNamen());
		gridPaneel.add(cmboxCafes, 2, 3);*/

		Button btnGo = new Button("GO!");
		btnGo.setShape(new Circle(100));
		gridPaneel.add(btnGo, 2, 5);

		/*
		 * Dit gaat methodes oproepen om de aangeduide string (cafe) uit de arraylist 
		 * te halen als cafe object en deze meegeven met de actionButton.
		 */
		btnGo.setOnAction((ActionEvent e) ->
		{
			/*String cafeNaam = cmboxCafes.getValue();
			cafebezoekScene("Cafe Bezoek", cafeNaam, CafeLijst.getCafeUitLijst(cafeNaam));
			scherm.close();*/
		} );

		Scene cafeKiezen = new Scene(gridPaneel);
		scherm.setScene(cafeKiezen);
	}
	
	/**
	 * 
	 * @param title
	 * @param cafeNaam
	 * @param cafe 
	 */
	public  static void cafebezoekScene(String title,String cafeNaam, Cafe cafe)
	{
		Cafebezoek cafebezoek = new Cafebezoek(cafe);
		Stage scherm = new Stage();
		scherm.initModality(Modality.APPLICATION_MODAL);

		scherm.setTitle(title);
		scherm.setMinWidth(350);
		GridPane gridPaneel = new GridPane();
		gridPaneel.setAlignment(Pos.CENTER);
		gridPaneel.setPadding(new Insets(20, 20, 20, 20));
		gridPaneel.setVgap(10);
		gridPaneel.setHgap(10);

		Text txtCafeNaam = new Text(cafeNaam);
		txtCafeNaam.setId("cafe-naam");
		gridPaneel.add(txtCafeNaam, 1, 0);

		// Timer komt hier
		Label timerField = new Label("00:01");
		timerField.setId("Timer");

		gridPaneel.add(timerField, 2, 2);

		Label lblAantalConsumpties = new Label(); //observable.
		//aantalConsumptiesLabel.setText(Integer.toString(cafebezoek.getAantalConsumpties()));
		gridPaneel.add(lblAantalConsumpties, 3, 3);
		Button btnDrink = new Button("+1");
		btnDrink.setId("drink-button");
		btnDrink.setShape(new Circle(30));
		btnDrink.setOnAction((ActionEvent e) ->
		{
			//cafebezoek.verhoogAantalConsumpties();
			//lblAantalConsumpties.setText(Integer.toString(cafebezoek.getAantalConsumpties()));
		});
		gridPaneel.add(btnDrink, 1, 3);

		Button btnStopDrinken = new Button("STOP");
		btnStopDrinken.setOnAction((ActionEvent e) ->
		{
			/*cafebezoek.eindeBezoek();
			AlertBox.eindeBezoekScene("STATS", cafebezoek.getBeginTijd(), cafebezoek.getEindTijd(), cafebezoek.getTotaleTijdVanBezoek(),cafebezoek.getAantalConsumpties());
			CafebezoekLijst.toevoegen(cafebezoek);
			scherm.close();*/
		});
		gridPaneel.add(btnStopDrinken,4,5);

		Scene sceneCafebezoek = new Scene(gridPaneel);
		scherm.setScene(sceneCafebezoek);
		scherm.show();
	}

	/**
	 * 
	 * @param title
	 * @param beginTijd
	 * @param eindTijd
	 * @param totaleTijd
	 * @param totaalAantalConsumpties 
	 */
	public static void eindeBezoekScene(String title, Date beginTijd, Date eindTijd, 
		double totaleTijd, int totaalAantalConsumpties)
	{
		Stage scherm = new Stage();
		scherm.initModality(Modality.APPLICATION_MODAL);
		scherm.setTitle(title);
		scherm.setMinWidth(350);
		
		GridPane gridPaneel = new GridPane();
		gridPaneel.setVgap(10);
		gridPaneel.setHgap(10);
		gridPaneel.setPadding(new Insets(10));

		Text statsText = new Text("STATS");
		gridPaneel.add(statsText, 0, 0);

		Label lblBegin = new Label("Begin tijd: ");
		gridPaneel.add(lblBegin, 0, 1);
		
		Label lblBeginTijd = new Label(beginTijd.toString());
		lblBeginTijd.setId("statsLabel");
		gridPaneel.add(lblBeginTijd, 1, 1);

		Label lblEinde = new Label("Eind tijd: ");
		gridPaneel.add(lblEinde, 0, 2);
		
		Label lblEindTijd = new Label(eindTijd.toString());
		lblEindTijd.setId("statsLabel");
		gridPaneel.add(lblEindTijd, 1, 2);

		Label lblTotaal = new Label("Totale tijd: ");
		gridPaneel.add(lblTotaal, 0, 3);
		
		Label lblTotaleTijd = new Label(Double.toString(totaleTijd));
		lblEindTijd.setId("statsLabel");
		gridPaneel.add(lblTotaleTijd, 1, 3);

		Label lblAantal = new Label("Aantal consumpties: ");
		gridPaneel.add(lblAantal, 0, 4);
		
		Label lblAantalConsumpties = new Label(Integer.toString(totaalAantalConsumpties));
		lblEindTijd.setId("statsLabel");
		gridPaneel.add(lblAantalConsumpties, 1, 4);

		Button btnOk = new Button("OK");
		btnOk.setAlignment(Pos.BOTTOM_RIGHT);
		btnOk.setOnAction((ActionEvent e) ->
		{
			scherm.close();
		});
		gridPaneel.add(btnOk,3,4);

		Scene statScene = new Scene(gridPaneel);
		scherm.setScene(statScene);
		scherm.show();
	}
}
