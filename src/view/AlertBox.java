package view;

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
import model.Adres;
import model.Cafe;
import model.CafeLijst;
import model.CafeSoort;


/**
 * Created by Administrator on 2-11-2015.
 */
public class AlertBox {

        public static void displayCafeToevoegenScene(String title, String message){

            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setMinWidth(350);
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Cafe toegevoegd aan DB", ButtonType.OK);

            GridPane formLayout = new GridPane();
            formLayout.setAlignment(Pos.CENTER);
            formLayout.setVgap(10);
            formLayout.setHgap(10);
            formLayout.setPadding(new Insets(20, 20, 20, 20));


            Text sceneTitle = new Text("Voer de cafe gegevens in");
            sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            formLayout.add(sceneTitle, 0, 0, 2, 1);

            Label lbl1 = new Label("_Name:");
            formLayout.add(lbl1, 0, 1);
            Label lbl2 = new Label("_Address:");
            formLayout.add(lbl2, 0, 2);
            Label lbl3 = new Label("_Soort:");
            formLayout.add(lbl3, 0, 3);

            TextField textField_CafeNaam = new TextField();
            lbl1.setLabelFor(textField_CafeNaam);
            lbl1.setMnemonicParsing(true);
            formLayout.add(textField_CafeNaam, 2, 1);

            TextField textField_CafeAdres = new TextField();
            lbl2.setLabelFor(textField_CafeAdres);
            lbl2.setMnemonicParsing(true);
            formLayout.add(textField_CafeAdres, 2, 2);

            ComboBox<CafeSoort> comboBox_CafeSoort = new ComboBox<>();
            comboBox_CafeSoort.getItems().setAll(CafeSoort.values());
            lbl3.setLabelFor(comboBox_CafeSoort);
            lbl3.setMnemonicParsing(true);
            formLayout.add(comboBox_CafeSoort, 2, 3);


            HBox hBtn = new HBox(10);


            Button buttonToevoegen = new Button("Toevoegen");
            hBtn.setAlignment(Pos.BOTTOM_RIGHT);
            hBtn.getChildren().add(buttonToevoegen);
            formLayout.add(buttonToevoegen, 3, 4);
            buttonToevoegen.setOnAction(e -> {
                Adres cafeAdres = new Adres();
                cafeAdres.setStreet(textField_CafeAdres.getText());
                Cafe cafe = new Cafe(textField_CafeNaam.getText(), cafeAdres, comboBox_CafeSoort.getValue());
                CafeLijst.toevoegen(cafe);
                alert.show();
            });


            Button buttonExit = new Button("Close");
            hBtn.getChildren().add(buttonExit);
            buttonExit.setOnAction(e -> window.close());
            formLayout.add(buttonExit, 4, 4);

            formLayout.setHalignment(lbl1, HPos.RIGHT);
            formLayout.setHalignment(lbl2, HPos.RIGHT);
            formLayout.setHalignment(lbl3, HPos.RIGHT);


            Scene toevoegenCafeScene = new Scene(formLayout);
            window.setScene(toevoegenCafeScene);

            window.showAndWait();


        }

        public static void kiesStartCafeScene(String title){

            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setMinWidth(350);
            GridPane formLayout = new GridPane();
            formLayout.setVgap(10);
            formLayout.setHgap(10);
            formLayout.setPadding(new Insets(10));

            Label label1 = new Label("Kies je cafe");
            formLayout.add(label1, 2, 0);
            label1.setAlignment(Pos.CENTER);

            ComboBox<String>cafes = new ComboBox<>();
           // cafes.getItems().setAll(CafeLijst.getCafes()); // Nakijken!!!!
            formLayout.add(cafes, 2, 3);

            Button buttonGO = new Button("GO!");
            buttonGO.setShape(new Circle(35.0));
            formLayout.add(buttonGO, 2, 5);

            /**
             * Dit gaat methodes oproepen om de aangeduide string (cafe)  uit de arraylist te halen als cafe object en deze
             * meegeven met de actionButton.
             *
             *
             */

            buttonGO.setOnAction(e -> window.close());

        /*{
            // window.show(StartGUI.cafeBezoekScene());
        });*/

            Scene chooseCafe = new Scene(formLayout);
            window.setScene(chooseCafe);
            window.show();


        }


        public static void eindeBezoekScene(String title, long beginTijd, long eindTijd, double  totaleTijd,int totaalaantalConsumpties){
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setMinWidth(350);
            GridPane formLayout = new GridPane();
            formLayout.setVgap(10);
            formLayout.setHgap(10);
            formLayout.setPadding(new Insets(10));



            Text statsText = new Text("STATS");
            formLayout.add(statsText, 0, 0);

            Label lbl1 = new Label("Begin tijd: ");
            formLayout.add(lbl1, 0, 1);
            Label beginTijdLabel = new Label(Long.toString(beginTijd));
            beginTijdLabel.setId("statsLabel");
            formLayout.add(beginTijdLabel, 1, 1);

            Label lbl2 = new Label("Eind tijd: ");
            formLayout.add(lbl2, 0, 2);
            Label eindTijdLabel = new Label(Long.toString(eindTijd));
            eindTijdLabel.setId("statsLabel");
            formLayout.add(beginTijdLabel, 1, 2);

            Label lbl3 = new Label("Totale tijd: ");
            formLayout.add(lbl3, 0, 3);
            Label totaleTijdLabel = new Label(Double.toString(totaleTijd));
            eindTijdLabel.setId("statsLabel");
            formLayout.add(beginTijdLabel, 1, 3);

            Label lbl4 = new Label("Aantal consumpties: ");
            formLayout.add(lbl4, 0, 4);
            Label totaalAantalConsumptiesLabel = new Label(Long.toString(totaalaantalConsumpties));
            eindTijdLabel.setId("statsLabel");
            formLayout.add(beginTijdLabel, 1, 4);


            Button buttonOK = new Button("OK");
            buttonOK.setOnAction(e -> window.close());
            buttonOK.setAlignment(Pos.BOTTOM_RIGHT);
            formLayout.add(buttonOK,3,4);

            Scene statScene = new Scene(formLayout);
            window.setScene(statScene);
            window.show();






        }





    }


