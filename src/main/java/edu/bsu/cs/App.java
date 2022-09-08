package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(setCalculatorLayout()));
        primaryStage.setTitle("Quaternary Calculator");
        primaryStage.show();
    }

    private Parent setCalculatorLayout() {
        VBox calculatorUI = new VBox();
        GridPane calculatorGrid = new GridPane();
        calculatorGrid.add(new Button("3"), 0, 0);
        calculatorGrid.add(new Button("2"), 1, 0);
        calculatorGrid.add(new Button("1"), 0, 1);
        calculatorGrid.add(new Button("0"), 1, 1);
        calculatorGrid.add(new Button("x"), 2, 0);
        calculatorGrid.add(new Button("/"), 2, 1);
        calculatorGrid.add(new Button("+"), 2, 2);
        calculatorGrid.add(new Button("-"), 2, 3);
        calculatorUI.getChildren().add(calculatorGrid);
        return calculatorUI;
    }
}

