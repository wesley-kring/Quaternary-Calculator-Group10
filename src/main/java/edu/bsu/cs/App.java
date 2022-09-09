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
    private Button square;
    private Button squareRoot;

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
        one.setOnAction(event -> oneTask());
        two.setOnAction(event -> twoTask());
        three.setOnAction(event -> threeTask());
        add.setOnAction(event -> addTask());
        subtract.setOnAction(event -> subtractTask());
        multiply.setOnAction(event -> multiplyTask());
        divide.setOnAction(event -> divideTask());
        square.setOnAction(event -> squareTask());
        square.setOnAction(event -> squareRootTask());
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
        square = new Button("x²");
        squareRoot = new Button("√");
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
    private void oneTask(){
        System.out.println("1");
    }
    private void twoTask(){
        System.out.println("2");
    }
    private void threeTask(){
        System.out.println("3");
    }
    private void addTask(){
        System.out.println("+");
    }
    private void subtractTask(){
        System.out.println("-");
    }
    private void multiplyTask(){
        System.out.println("*");
    }
    private void divideTask(){
        System.out.println("/");
    }
    private void squareTask(){
        System.out.println("x²");
    }
    private void squareRootTask(){
        System.out.println("√");
    }
}

