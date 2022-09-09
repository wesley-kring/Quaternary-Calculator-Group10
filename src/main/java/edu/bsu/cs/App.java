package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;

    public App() {
        setButtonLabels();
        setButtonEvents();
    }

    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(setCalculatorLayout()));
        primaryStage.setTitle("Quaternary Calculator");
        primaryStage.show();
    }

    private void setButtonEvents(){
        zero.setOnAction(event -> zeroTask());
    }

    private void setButtonLabels(){
        zero = new Button("0");
        one = new Button("1");
        two = new Button("2");
        three = new Button("3");
        add = new Button("+");
        subtract = new Button("-");
        multiply = new Button("*");
        divide = new Button("/");
    }

    private Parent setCalculatorLayout() {
        VBox calculatorUI = new VBox();
        GridPane calculatorGrid = new GridPane();
        calculatorGrid.add(three, 0, 0);
        calculatorGrid.add(two, 1, 0);
        calculatorGrid.add(one, 0, 1);
        calculatorGrid.add(zero, 1, 1);
        calculatorGrid.add(multiply, 2, 0);
        calculatorGrid.add(divide, 2, 1);
        calculatorGrid.add(add, 2, 2);
        calculatorGrid.add(subtract, 2, 3);
        calculatorUI.getChildren().add(calculatorGrid);
        return calculatorUI;
    }

    private void zeroTask(){
        System.out.println("0");
    }
}

