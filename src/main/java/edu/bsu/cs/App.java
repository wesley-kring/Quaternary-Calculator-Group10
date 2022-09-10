package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private String operaton;
    private StringBuilder displayText = new StringBuilder();
    private Calculator calculator = new Calculator("0");
    private final TextField display = new TextField();
    private final Button zero = new Button("0");
    private final Button one = new Button("1");
    private final Button two = new Button("2");
    private final Button three = new Button("3");
    private final Button clear = new Button("C");
    private final Button equals = new Button("=");
    private final Button add = new Button("+");
    private final Button subtract = new Button("-");
    private final Button multiply = new Button("*");
    private final Button divide = new Button("/");
    private final Button square = new Button("x²");
    private final Button squareRoot = new Button("√");



    public App() {
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
        clear.setOnAction(event -> clearTask());
        equals.setOnAction(event -> equalsTask());
        add.setOnAction(event -> addTask());
        subtract.setOnAction(event -> subtractTask());
        multiply.setOnAction(event -> multiplyTask());
        divide.setOnAction(event -> divideTask());
        square.setOnAction(event -> squareTask());
        squareRoot.setOnAction(event -> squareRootTask());

    }

    private Parent setCalculatorLayout() {
        VBox calculatorUI = new VBox(50);
        HBox displayArea = new HBox();
        display.setEditable(false);
        displayArea.getChildren().add(display);
        HBox buttonRowOne = new HBox();
        buttonRowOne.setFillHeight(true);
        buttonRowOne.getChildren().addAll(zero, one, add, multiply);
        HBox buttonRowTwo = new HBox();
        buttonRowTwo.setFillHeight(true);
        buttonRowTwo.getChildren().addAll(two, three, subtract, divide);
        HBox buttonRowThree = new HBox();
        buttonRowThree.setFillHeight(true);
        buttonRowThree.getChildren().addAll(equals, clear, square, squareRoot);
        calculatorUI.getChildren().addAll(displayArea, buttonRowOne, buttonRowTwo, buttonRowThree);
        return calculatorUI;
    }

    private void zeroTask(){
        displayText.append("0");
        display.setText(displayText.toString());
    }
    private void oneTask(){
        displayText.append("1");
        display.setText(displayText.toString());
    }
    private void twoTask(){
        displayText.append("2");
        display.setText(displayText.toString());
    }
    private void threeTask(){
        displayText.append("3");
        display.setText(displayText.toString());
    }
    private void addTask(){
        operaton = "+";
        calculator.cacheNumber(displayText.toString());
        displayText = new StringBuilder();
        display.setText(displayText.toString());
    }
    private void subtractTask(){
        operaton = "-";
        calculator.cacheNumber(displayText.toString());
        displayText = new StringBuilder();
        display.setText(displayText.toString());
    }
    private void multiplyTask(){
        operaton = "*";
        calculator.cacheNumber(displayText.toString());
        displayText = new StringBuilder();
        display.setText(displayText.toString());
    }
    private void divideTask(){
        operaton = "/";
        calculator.cacheNumber(displayText.toString());
        displayText = new StringBuilder();
        display.setText(displayText.toString());
    }
    private void squareTask(){
        operaton = "^2";
        calculator.cacheNumber(displayText.toString());
        displayText = new StringBuilder(calculator.square());
        display.setText(displayText.toString());
    }
    private void squareRootTask(){
        operaton = "^1/2";
        calculator.cacheNumber(displayText.toString());
        displayText = new StringBuilder(calculator.squareRoot());
        display.setText(displayText.toString());
    }
    private void clearTask(){
        if(displayText.toString().equals("")) {
            calculator.cacheNumber(displayText.toString());
        }
        displayText = new StringBuilder();
        display.setText(displayText.toString());
    }
    private void equalsTask(){
        switch (operaton) {
            case "+" -> {
                displayText = new StringBuilder(calculator.add(displayText.toString()));
                display.setText(displayText.toString());
            }
            case "-" -> {
                displayText = new StringBuilder(calculator.subtract(displayText.toString()));
                display.setText(displayText.toString());
            }
            case "*" -> {
                displayText = new StringBuilder(calculator.multiply(displayText.toString()));
                display.setText(displayText.toString());
            }
            case "/" -> {
                displayText = new StringBuilder(calculator.divide(displayText.toString()));
                display.setText(displayText.toString());
            }
            case "^2" -> {
                displayText = new StringBuilder(calculator.square());
                display.setText(displayText.toString());
            }
            case "^1/2" -> {
                displayText = new StringBuilder(calculator.squareRoot());
                display.setText(displayText.toString());
            }
            default -> display.setText(displayText.toString());
        }
    }
}

