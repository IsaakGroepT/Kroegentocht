
package view;

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
import model.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: GUI interface
 */
public class AlertBox {

	private static final Logger logger = LogManager.getLogger("Kroegentocht");
	
	/**
	 * 
	 * @param titel
	 * @param bericht 
	 */
	public static void displayCafeToevoegenScene(String titel, String bericht)
	{
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
		btnToevoegen.setOnAction(e ->
		{
			Adres cafeAdres = new Adres();
			cafeAdres.setStreet(txtFieldCafeAdres.getText());
			// TODO: setcity en setnumber
			// TODO: validatie van input via log4j. Als sommige gegevens niet zijn ingevuld,
			// dan geeft het een algemene error maar de log zegt de details
			new Cafe(txtFieldCafeNaam.getText(), cafeAdres, 
				cmboxCafeSoort.getValue());

			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cafe is toegevoegd " + CafeLijst.getCafeNamen().toString(), ButtonType.OK);
			alert.show();
		});

		Button btnExit = new Button("Close");
		hBtn.getChildren().add(btnExit);
		gridPaneel.add(btnExit, 4, 4);
		btnExit.setOnAction(e -> scherm.close());

		// GridPane ipv gridPaneel want is statische methode, gridPaneel is een geïnstantieerd object
		GridPane.setHalignment(lblNaam, HPos.RIGHT);
		GridPane.setHalignment(lblAdres, HPos.RIGHT);
		GridPane.setHalignment(lblSoort, HPos.RIGHT);

		Scene toevoegenCafeScene = new Scene(gridPaneel);
		scherm.setScene(toevoegenCafeScene);
		scherm.showAndWait();
	}
	
	/**
	 * Wanneer er op de startknop gedrukt wordt, maken we een bezoek aan een café
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

		// Lijst van cafés toevoegen aan de combobox
		ComboBox<String> cmboxCafes = new ComboBox<>();
		// TODO: toon naam van cafe + adresgegevens ipv enkel de naam,
		// zo voorkomen we cafes die dezelfde naam hebben maar andere adressen hebben
		cmboxCafes.getItems().setAll(CafeLijst.getCafeNamen());
		gridPaneel.add(cmboxCafes, 2, 3);

		Button btnGo = new Button("GO!");
		btnGo.setShape(new Circle(100));
		gridPaneel.add(btnGo, 2, 5);

		/*
		 * Dit gaat methodes oproepen om de aangeduide string (cafe) uit de arraylist 
		 * te halen als cafe object en deze meegeven met de actionButton.
		 */
		btnGo.setOnAction(e ->
		{
			String cafeNaam = cmboxCafes.getValue();
			cafebezoekScene("Cafe Bezoek", cafeNaam, CafeLijst.getCafeUitLijst(cafeNaam));
			scherm.close();
		} );

		Scene cafeKiezen = new Scene(gridPaneel);
		scherm.setScene(cafeKiezen);
		cafeKiezen.getStylesheets().add(StartGUI.class.getResource("Kroegentocht.css").toExternalForm());
		scherm.show();
	}
	
	/**
	 * 
	 * @param title
	 * @param cafeNaam
	 * @param cafe 
	 */
	public  static void cafebezoekScene(String title, String cafeNaam, Cafe cafe)
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

		// Datum en tijd
		String datumEnUur = cafebezoek.getBeginTijd().toString("dd/MM/YYYY hh:mm:ss");
		
		Label timerField = new Label("Start bezoek op: " + datumEnUur);
		timerField.setId("Timer");
		gridPaneel.add(timerField, 2, 2);

		Label lblAantalConsumpties = new Label(); //observable.
		lblAantalConsumpties.setText(Integer.toString(cafebezoek.getAantalConsumpties()));
		gridPaneel.add(lblAantalConsumpties, 3, 3);
		Button btnDrink = new Button("+1");
		btnDrink.setId("drink-button");
		btnDrink.setShape(new Circle(30));
		btnDrink.setOnAction((ActionEvent e) ->
		{
			cafebezoek.verhoogAantalConsumpties();
			logger.info("Er is nog een zuip toegevoegd");
			//System.out.println(cafebezoek.getAantalConsumpties());
			// TODO: bug: vanaf 10 is er een fout bij het tonen
			lblAantalConsumpties.setText(Integer.toString(cafebezoek.getAantalConsumpties()));
		});
		gridPaneel.add(btnDrink, 1, 3);

		Button btnStopDrinken = new Button("STOP");
		btnStopDrinken.setOnAction(e ->
		{
			cafebezoek.eindeVanCafebezoek();
			AlertBox.eindeBezoekScene("STATS", cafebezoek.getBeginTijd(), cafebezoek.getEindTijd(), cafebezoek.getTotaleTijdVanBezoek(),cafebezoek.getAantalConsumpties());
			scherm.close();
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
	public static void eindeBezoekScene(String title, DateTime beginTijd, DateTime eindTijd, 
		long totaleTijd, int totaalAantalConsumpties)
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
		
		Label lblBeginTijd = new Label(beginTijd.toString("dd/MM/YYYY hh:mm:ss"));
		lblBeginTijd.setId("statsLabel");
		gridPaneel.add(lblBeginTijd, 1, 1);

		Label lblEinde = new Label("Eind tijd: ");
		gridPaneel.add(lblEinde, 0, 2);
		
		Label lblEindTijd = new Label(eindTijd.toString("dd/MM/YYYY hh:mm:ss"));
		lblEindTijd.setId("statsLabel");
		gridPaneel.add(lblEindTijd, 1, 2);

		Label lblTotaal = new Label("Totale tijd: ");
		gridPaneel.add(lblTotaal, 0, 3);
		
		// Aantal minuten bezoek
		Label lblTotaleTijd = new Label();
		lblTotaleTijd.setText(totaleTijd < 1 ? "Minder dan een minuut" : "+/- " + totaleTijd + " minu(u)t(en)");
		lblEindTijd.setId("statsLabel");
		gridPaneel.add(lblTotaleTijd, 1, 3);

		Label lblAantal = new Label("Aantal consumpties: ");
		gridPaneel.add(lblAantal, 0, 4);
		
		Label lblAantalConsumpties = new Label(Integer.toString(totaalAantalConsumpties));
		lblEindTijd.setId("statsLabel");
		gridPaneel.add(lblAantalConsumpties, 1, 4);

		Button btnOk = new Button("OK");
		btnOk.setAlignment(Pos.BOTTOM_RIGHT);
		btnOk.setOnAction(e ->
		{
			scherm.close();
		});
		gridPaneel.add(btnOk,3,4);

		Scene statScene = new Scene(gridPaneel);
		scherm.setScene(statScene);
		scherm.show();
	}
}