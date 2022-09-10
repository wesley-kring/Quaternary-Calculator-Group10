package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ToggleButton;

public class App extends Application {
    private String operaton;
    private StringBuilder displayText = new StringBuilder();
    private final Calculator calculator = new Calculator("0");
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
    private final Button square = new Button("\u33A1");
    private final Button squareRoot = new Button("\u221A");
    private final ToggleButton decimal = new ToggleButton("decimal");



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
        //decimal.setOnAction(event -> decimalTask());
    }

    private Parent setCalculatorLayout() {
        VBox calculatorUi = new VBox();
        HBox displayArea = new HBox();
        displayArea.prefHeightProperty().bind(calculatorUi.heightProperty().multiply(.25));
        display.setEditable(false);
        display.prefHeightProperty().bind(displayArea.heightProperty());
        display.prefWidthProperty().bind(displayArea.widthProperty().multiply(.75));
        decimal.prefHeightProperty().bind(displayArea.heightProperty());
        decimal.prefWidthProperty().bind(displayArea.widthProperty().multiply(.25));
        displayArea.getChildren().addAll(display, decimal);

        HBox buttonRowOne = new HBox();
        buttonRowOne.prefHeightProperty().bind(calculatorUi.heightProperty().multiply(.25));
        buttonRowOne.getChildren().addAll(zero, one, add, multiply);
        zero.prefWidthProperty().bind(buttonRowOne.widthProperty().multiply(.25));
        one.prefWidthProperty().bind(buttonRowOne.widthProperty().multiply(.25));
        add.prefWidthProperty().bind(buttonRowOne.widthProperty().multiply(.25));
        multiply.prefWidthProperty().bind(buttonRowOne.widthProperty().multiply(.25));
        zero.prefHeightProperty().bind(buttonRowOne.heightProperty());
        one.prefHeightProperty().bind(buttonRowOne.heightProperty());
        add.prefHeightProperty().bind(buttonRowOne.heightProperty());
        multiply.prefHeightProperty().bind(buttonRowOne.heightProperty());

        HBox buttonRowTwo = new HBox();
        buttonRowTwo.prefHeightProperty().bind(calculatorUi.heightProperty().multiply(.25));
        buttonRowTwo.getChildren().addAll(two, three, subtract, divide);
        two.prefWidthProperty().bind(buttonRowTwo.widthProperty().multiply(.25));
        three.prefWidthProperty().bind(buttonRowTwo.widthProperty().multiply(.25));
        subtract.prefWidthProperty().bind(buttonRowTwo.widthProperty().multiply(.25));
        divide.prefWidthProperty().bind(buttonRowTwo.widthProperty().multiply(.25));
        two.prefHeightProperty().bind(buttonRowTwo.heightProperty());
        three.prefHeightProperty().bind(buttonRowTwo.heightProperty());
        subtract.prefHeightProperty().bind(buttonRowTwo.heightProperty());
        divide.prefHeightProperty().bind(buttonRowTwo.heightProperty());

        HBox buttonRowThree = new HBox();
        buttonRowThree.prefHeightProperty().bind(calculatorUi.heightProperty().multiply(.25));
        buttonRowThree.getChildren().addAll(equals, clear, square, squareRoot);
        equals.prefWidthProperty().bind(buttonRowThree.widthProperty().multiply(.25));
        clear.prefWidthProperty().bind(buttonRowThree.widthProperty().multiply(.25));
        square.prefWidthProperty().bind(buttonRowThree.widthProperty().multiply(.25));
        squareRoot.prefWidthProperty().bind(buttonRowThree.widthProperty().multiply(.25));
        equals.prefHeightProperty().bind(buttonRowThree.heightProperty());
        clear.prefHeightProperty().bind(buttonRowThree.heightProperty());
        square.prefHeightProperty().bind(buttonRowThree.heightProperty());
        squareRoot.prefHeightProperty().bind(buttonRowThree.heightProperty());


        calculatorUi.getChildren().addAll(displayArea, buttonRowOne, buttonRowTwo, buttonRowThree);
        calculatorUi.setMinSize(300, 400);
        return calculatorUi;
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