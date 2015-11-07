
package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import model.*;

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
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cafe is toegevoegd", ButtonType.OK);
		Stage scherm = new Stage();
		scherm.initModality(Modality.APPLICATION_MODAL);
		scherm.setTitle(titel);

		GridPane gridPaneel = new GridPane();
		gridPaneel.setAlignment(Pos.CENTER);
		gridPaneel.setVgap(10);
		gridPaneel.setHgap(10);
		gridPaneel.setPadding(new Insets(20, 20, 20, 20));

		Text sceneTitle = new Text("Voer de gegevens van het cafe in");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		gridPaneel.add(sceneTitle, 0, 0, 2, 1);

		Label lblNaam = new Label("_Name:");
		gridPaneel.add(lblNaam, 0, 1);
		Label lblAdres = new Label("_Address:");
		gridPaneel.add(lblAdres, 0, 2);
		Label lblNummer = new Label("_Nummer:");
		gridPaneel.add(lblNummer, 0, 3);
		Label lblStad = new Label("_Stad:");
		gridPaneel.add(lblStad, 0, 4);
		Label lblSoort = new Label("_Soort:");
		gridPaneel.add(lblSoort, 0, 5);

		TextField txtFieldCafeNaam = new TextField();
		lblNaam.setLabelFor(txtFieldCafeNaam);
		lblNaam.setMnemonicParsing(true);
		gridPaneel.add(txtFieldCafeNaam, 2, 1);

		TextField txtFieldCafeAdres = new TextField();
		lblAdres.setLabelFor(txtFieldCafeAdres);
		lblAdres.setMnemonicParsing(true);
		gridPaneel.add(txtFieldCafeAdres, 2, 2);

		TextField txtFieldCafePostcode = new TextField();
		lblNummer.setLabelFor(txtFieldCafePostcode);
		lblNummer.setMnemonicParsing(true);
		gridPaneel.add(txtFieldCafePostcode, 2, 3);

		TextField txtFieldCafeStad = new TextField();
		lblStad.setLabelFor(txtFieldCafeStad);
		lblStad.setMnemonicParsing(true);
		gridPaneel.add(txtFieldCafeStad, 2, 4);

		ComboBox<CafeSoort> cmboxCafeSoort = new ComboBox<>();
		cmboxCafeSoort.getItems().setAll(CafeSoort.values());
		lblSoort.setLabelFor(cmboxCafeSoort);
		lblSoort.setMnemonicParsing(true);
		gridPaneel.add(cmboxCafeSoort, 2, 5);

		HBox hBtn = new HBox(2);

		Button btnToevoegen = new Button("Toevoegen");
		//btnToevoegen.setMinWidth(300);
		hBtn.setAlignment(Pos.BOTTOM_LEFT);
		hBtn.getChildren().add(btnToevoegen);
		gridPaneel.add(btnToevoegen, 1, 6);
		
		btnToevoegen.setOnAction((ActionEvent e) ->
		{
			if (txtFieldCafeNaam.getText().equals("") || txtFieldCafeAdres.getText().equals("") ||
				txtFieldCafePostcode.getText().equals("") || txtFieldCafeStad.getText().equals("") ||
				cmboxCafeSoort.getValue() == null)
			{
				Alert alert2 = new Alert(Alert.AlertType.ERROR, "Niet alle velden van het café zijn ingevuld!", ButtonType.OK);
				alert2.setHeaderText("Er is een probleem!");
				
				Image image = new Image("view/resources/giphy.gif");
				alert2.setGraphic(new ImageView(image));
				alert2.show();
				logger.error("Niet alle velden van het café zijn ingevuld!");
				return;
			}
			Adres cafeAdres = new Adres();
			cafeAdres.setStreet(txtFieldCafeAdres.getText());
			cafeAdres.setPostcode(txtFieldCafePostcode.getText());
			cafeAdres.setCity(txtFieldCafeStad.getText());
			// De café wordt in de constructor aan de static array toegevoegd
			new Cafe(txtFieldCafeNaam.getText(), cafeAdres, cmboxCafeSoort.getValue());

			alert.show();
		});

		Button btnExit = new Button("Close");
		hBtn.getChildren().add(btnExit);
		gridPaneel.add(btnExit, 2, 6);
		btnExit.setOnAction(e -> scherm.close());

		/*
		 * GridPane ipv gridPaneel want is statische methode, gridPaneel is een 
		 * geïnstantieerd object
		 */
		GridPane.setHalignment(lblNaam, HPos.RIGHT);
		GridPane.setHalignment(lblAdres, HPos.RIGHT);
		GridPane.setHalignment(lblSoort, HPos.RIGHT);

		Scene toevoegenCafeScene = new Scene(gridPaneel, 370, 420);
		scherm.setScene(toevoegenCafeScene);
		scherm.setResizable(false);
		toevoegenCafeScene.getStylesheets().add(StartGUI.class.getResource("Kroegentocht.css").toExternalForm());
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
	public static void cafebezoekScene(String title, String cafeNaam, Cafe cafe)
	{
		Cafebezoek cafebezoek = new Cafebezoek(cafe);
		Stage scherm = new Stage();
		scherm.initModality(Modality.APPLICATION_MODAL);

		scherm.setTitle(title);
		scherm.setMinWidth(200);
		GridPane gridPaneel = new GridPane();
		gridPaneel.setAlignment(Pos.CENTER);
		gridPaneel.setPadding(new Insets(20, 20, 20, 20));
		gridPaneel.setVgap(10);
		gridPaneel.setHgap(10);


		VBox vbox = new VBox(15);
		vbox.setAlignment(Pos.CENTER);

		Text txtCafeNaam = new Text(cafeNaam);
		txtCafeNaam.setId("cafe-naam");
		//gridPaneel.add(txtCafeNaam, 1, 0);

		// Datum en tijd
		//String datumEnUur = cafebezoek.getBeginTijd().toString("dd/MM/YYYY hh:mm:ss");
		
		//Label timerField = new Label("Start bezoek op: " + datumEnUur);
		//timerField.setId("Timer");
		//gridPaneel.add(timerField, 2, 2);

		Image imgAantalGedronken = new Image("view/resources/notDrunk.png",150,150,false,false);
		Image imgAantalGedronken2 = new Image("view/resources/happy.png",150,150,false,false);
		Image imgAantalGedronken3 = new Image("view/resources/drunk.png",150,150,false,false);

		Label lblDrunkState = new Label("STATUS");
		lblDrunkState.setId("labels-cafebezoek");
		ImageView imageView = new ImageView();
		imageView.setImage(imgAantalGedronken);
		//gridPaneel.add(imageView,2,3);

		Label lblAantalConsumptiesText = new Label("Aantal geconsumeerd:");
		lblAantalConsumptiesText.setId("labels-cafebezoek");
		//gridPaneel.add(lblAantalConsumptiesText,0,2);

		Label lblAantalConsumpties = new Label(); //observable.
		lblAantalConsumpties.setId("labels-cafebezoek");
		lblAantalConsumpties.setText(Integer.toString(cafebezoek.getAantalConsumpties()));
		gridPaneel.add(lblAantalConsumpties, 1, 2);
		Button btnDrink = new Button("+1");
		btnDrink.setId("drinkButton");
		btnDrink.setId("drink-button");
		btnDrink.setShape(new Circle(200.00));
		btnDrink.setOnAction((ActionEvent e) ->
		{
			cafebezoek.verhoogAantalConsumpties();
			logger.info("Er is nog een zuip toegevoegd");
			lblAantalConsumpties.setText(Integer.toString(cafebezoek.getAantalConsumpties()));
			
			if (cafebezoek.getAantalConsumpties() > 3 && cafebezoek.getAantalConsumpties() < 6)
			{
				imageView.setImage(imgAantalGedronken2);
			}
			else if (cafebezoek.getAantalConsumpties() >= 6)
			{
				imageView.setImage(imgAantalGedronken3);
			}

		});
		gridPaneel.add(btnDrink, 1, 3);

		Button btnStopDrinken = new Button("STOP");
		btnStopDrinken.setOnAction(e ->
		{
			cafebezoek.eindeVanCafebezoek();
			AlertBox.eindeBezoekScene("STATS", cafebezoek.getBeginTijd(), cafebezoek.getEindTijd(), 
				cafebezoek.getTotaleTijdString(), cafebezoek.getAantalConsumpties());
			scherm.close();
		});
		//gridPaneel.add(btnStopDrinken,2,4);


		vbox.getChildren().addAll(txtCafeNaam, lblDrunkState , imageView, lblAantalConsumptiesText,lblAantalConsumpties,btnDrink,btnStopDrinken);
		gridPaneel.getChildren().setAll(vbox);
		//gridPaneel.getChildren().add(imageView);
		Scene sceneCafebezoek = new Scene(gridPaneel);
		scherm.setScene(sceneCafebezoek);
		sceneCafebezoek.getStylesheets().add(StartGUI.class.getResource("Kroegentocht.css").toExternalForm());
		scherm.show();
	}

	/**
	 * 
	 * @param titel 
	 */
	public static void cafeStatistiekenScene(String titel)
	{
		Stage scherm = new Stage();
		scherm.initModality(Modality.APPLICATION_MODAL);
		scherm.setTitle(titel);
		scherm.setMinWidth(350);
		scherm.setMinHeight(400);

		GridPane gridPaneel = new GridPane();
		gridPaneel.setAlignment(Pos.CENTER);
		gridPaneel.setVgap(10);
		gridPaneel.setHgap(10);
		gridPaneel.setPadding(new Insets(20, 20, 20, 20));
		
		/* Tabel */

		TableView<Cafebezoek> statistiekenTabel;
		VBox vBox = new VBox(10);

		TableColumn cafeNaam = new TableColumn("Cafe naam");
		TableColumn datumBezoek = new TableColumn("Datum bezoek");
		TableColumn tijdOpCafe = new TableColumn("Duur van cafebezoek");
		TableColumn aantalConsumpties = new TableColumn("Aantal consumpties");
		
		cafeNaam.setMinWidth(200);
		datumBezoek.setMinWidth(200);
		tijdOpCafe.setMinWidth(200);
		aantalConsumpties.setMinWidth(200);
		
		cafeNaam.setCellValueFactory(new PropertyValueFactory<>("cafeNaam"));
		datumBezoek.setCellValueFactory(new PropertyValueFactory<>("beginTijdString"));
		tijdOpCafe.setCellValueFactory(new PropertyValueFactory<>("totaleTijdString"));
		aantalConsumpties.setCellValueFactory(new PropertyValueFactory<>("aantalConsumpties"));

		statistiekenTabel = new TableView<>();
		statistiekenTabel.setItems(getCafesInTabel());
		statistiekenTabel.getColumns().addAll(cafeNaam, datumBezoek, tijdOpCafe, aantalConsumpties);

		Button btnExit = new Button ("Close");
		btnExit.setOnAction(e -> scherm.close());

		vBox.getChildren().addAll(statistiekenTabel, btnExit);
		Scene scene = new Scene(vBox);
		scherm.setScene(scene);
		scherm.show();
	}

	/**
	 * Get alle Cafés
	 * @return 
	 */
	public static ObservableList<Cafebezoek> getCafesInTabel()
	{
		ObservableList<Cafebezoek> cafes = FXCollections.observableArrayList();
		cafes.setAll(CafebezoekLijst.getCafebezoeken());
		
		return cafes;
	}

	/**
	 * Get alle Cafés
	 * @return 
	 */
	public static ObservableList<Data> getCafesEnConsumpties()
	{
		ObservableList<Data> cafeEnConsumpties = FXCollections.observableArrayList();
		cafeEnConsumpties.addAll(new PieChart.Data("Cafe Michal: 5", 5), 
			new PieChart.Data("Cafe isaak: 25", 25), new PieChart.Data("jos concurrent: 5", 5));
		
		return cafeEnConsumpties;
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
		String totaleTijd, int totaalAantalConsumpties)
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
		statsText.setId("welkomTekst");
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
		//Label lblTotaleTijd = new Label();
		//lblTotaleTijd.setText(totaleTijd < 1 ? "Minder dan een minuut" : "+/- " + totaleTijd + " minu(u)t(en)");
		Label lblTotaleTijd = new Label(totaleTijd);
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
		statScene.getStylesheets().add(StartGUI.class.getResource("Kroegentocht.css").toExternalForm());
		scherm.show();
	}
}